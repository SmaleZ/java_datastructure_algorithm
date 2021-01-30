package com.atguigu.stack;

public class Calculator {//用中缀表达式计算

	public static void main(String[] args) {
		String expression = "(3+4)*5-6";
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';
		String keepNum = "";// 用于拼接多位数
		while (true) {
			// 依次得到expression 的每一个字符
			ch = expression.substring(index, index + 1).charAt(0);
			// 判断ch 是什么然后进行相应的处理
			if (operStack.isOper(ch)) {
				if (!operStack.isEmpty()) {
					int peek = operStack.peek();
					if ((operStack.piority(ch) <= operStack.piority(peek)) && (peek != '(')) {
						// 当栈顶为左括号时，直接把当前符号压入栈中
						oper = operStack.pop();
						if (oper == ')') {
							while (true) {
								oper = operStack.pop();
								if (oper == '(') {//当遇到左括号时，括号内的运算结束
									break;
								}
								num1 = numStack.pop();
								num2 = numStack.pop();
								res = numStack.cal(num1, num2, oper);
								numStack.push(res);
							}
							// operStack.push(ch);
							index--;// 计算完括号里的值 让index先--后++，从而保持不变，从新扫描当前符号
						} else {
							num1 = numStack.pop();
							num2 = numStack.pop();
							res = numStack.cal(num1, num2, oper);
							// 把运算结果入栈
							numStack.push(res);
							// 把ch操作符入栈
							operStack.push(ch);
						}
					} else {
						operStack.push(ch);
					}
				} else {
					operStack.push(ch);
				}
			} else {// 如果是数则入数栈
				// 1.处理多位数时，不能发现一个数就直接入栈
				// 2.在处理数时，需要扫描至下一个符号为止
				// 3.因此我们需要定义一个字符串用于拼接
				// numStack.push(ch - 48);
				keepNum += ch;
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				} else {
					if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
						numStack.push(Integer.parseInt(keepNum));
						// keepnum 清空！！！
						keepNum = "";
					}
				}
			}
			// index + 1, 并判断是否扫描到了expression 的最后
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		while (true) {
			// 如果符号栈为空，则计算到最后的结果，数栈中只有一个数字为最后的结果
			if (operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			numStack.push(res);
		}
		int res2 = numStack.pop();
		System.out.printf("表达式%s = %d", expression, res2);
	}

}

//create a stack
class ArrayStack2 {
	private int maxSize;
	private int[] stack;
	private int top = -1;

	public ArrayStack2(int maxsize) {
		this.maxSize = maxsize;
		stack = new int[maxsize];
	}

	// 栈满
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// 栈空
	public boolean isEmpty() {
		return top == -1;
	}

	// push
	public void push(int value) {
		if (isFull()) {
			System.out.println("stack is full!");
			return;
		}
		top++;
		stack[top] = value;
	}

	// pop
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("stack is empty!");
		}
		int value = stack[top];
		top--;
		return value;
	}

	// show
	public void list() {
		if (isEmpty()) {
			System.out.println("stack is empty!");
			return;
		}
		// print from the top
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d] = %d\n", stack[i]);
		}
	}

	// 返回当前栈顶的值，但是不出栈
	public int peek() {
		return stack[top];
	}

	// 返回运算符的优先级,假定返回的数字越大，则优先级越高
	public int piority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else if (oper == '(' || oper == ')') {
			return 2;
		} else {
			return -1;
		}
	}

	// 判断是不是一个运算符
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/' || val == '(' || val == ')';
	}

	public int cal(int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1; // 用后弹出来的值减去先弹出来的值
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1; // 用后弹出来的值除以先弹出来的值
			break;
		default:
			break;
		}
		return res;
	}
}
