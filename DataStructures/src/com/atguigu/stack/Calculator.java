package com.atguigu.stack;

public class Calculator {//����׺���ʽ����

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
		String keepNum = "";// ����ƴ�Ӷ�λ��
		while (true) {
			// ���εõ�expression ��ÿһ���ַ�
			ch = expression.substring(index, index + 1).charAt(0);
			// �ж�ch ��ʲôȻ�������Ӧ�Ĵ���
			if (operStack.isOper(ch)) {
				if (!operStack.isEmpty()) {
					int peek = operStack.peek();
					if ((operStack.piority(ch) <= operStack.piority(peek)) && (peek != '(')) {
						// ��ջ��Ϊ������ʱ��ֱ�Ӱѵ�ǰ����ѹ��ջ��
						oper = operStack.pop();
						if (oper == ')') {
							while (true) {
								oper = operStack.pop();
								if (oper == '(') {//������������ʱ�������ڵ��������
									break;
								}
								num1 = numStack.pop();
								num2 = numStack.pop();
								res = numStack.cal(num1, num2, oper);
								numStack.push(res);
							}
							// operStack.push(ch);
							index--;// �������������ֵ ��index��--��++���Ӷ����ֲ��䣬����ɨ�赱ǰ����
						} else {
							num1 = numStack.pop();
							num2 = numStack.pop();
							res = numStack.cal(num1, num2, oper);
							// ����������ջ
							numStack.push(res);
							// ��ch��������ջ
							operStack.push(ch);
						}
					} else {
						operStack.push(ch);
					}
				} else {
					operStack.push(ch);
				}
			} else {// �������������ջ
				// 1.�����λ��ʱ�����ܷ���һ������ֱ����ջ
				// 2.�ڴ�����ʱ����Ҫɨ������һ������Ϊֹ
				// 3.���������Ҫ����һ���ַ�������ƴ��
				// numStack.push(ch - 48);
				keepNum += ch;
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				} else {
					if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
						numStack.push(Integer.parseInt(keepNum));
						// keepnum ��գ�����
						keepNum = "";
					}
				}
			}
			// index + 1, ���ж��Ƿ�ɨ�赽��expression �����
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		while (true) {
			// �������ջΪ�գ�����㵽���Ľ������ջ��ֻ��һ������Ϊ���Ľ��
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
		System.out.printf("���ʽ%s = %d", expression, res2);
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

	// ջ��
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// ջ��
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

	// ���ص�ǰջ����ֵ�����ǲ���ջ
	public int peek() {
		return stack[top];
	}

	// ��������������ȼ�,�ٶ����ص�����Խ�������ȼ�Խ��
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

	// �ж��ǲ���һ�������
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
			res = num2 - num1; // �ú󵯳�����ֵ��ȥ�ȵ�������ֵ
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1; // �ú󵯳�����ֵ�����ȵ�������ֵ
			break;
		default:
			break;
		}
		return res;
	}
}
