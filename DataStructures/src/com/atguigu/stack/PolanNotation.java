package com.atguigu.stack;

import java.util.ArrayList;

import java.util.List;
import java.util.Stack;

public class PolanNotation {

	public static void main(String[] args) {

		// 将中缀表达式转换成后缀表达式
		// 1. 1+((2+3)*4)-5 => 1 2 3 + 4 * + 5 -
		// 2. 因为直接对字符串扫描不方便， 因此先将字符串转成中缀表达式形式对应的list
		// 3. 将得到的中缀表达式对于的List 转化为 后缀表达式对应的List

		String expressionString = "1+((2+3)*4)-5";
		List<String> infixExpressionList = toInfixExpressionList(expressionString);
		System.out.println(infixExpressionList);
		System.out.println("后缀表达式对应的list" + parseSuffixExpressionList(infixExpressionList));
		System.out.printf("expression=%d", calculate(parseSuffixExpressionList(infixExpressionList)));
		// 先定义一个逆波兰表达式
		// (3+4) * 5 -6 => 3 4 + 5 * 6 -
		// 为了方便，逆波兰表达式的数字和符号使用空格隔开
		String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
		// 先将 表达式放在 arraylist里
		// 将arraylist 传递给一个方法，配合栈完成计算
//		List<String> list = getListString(suffixExpression);
//		int res = calculate(list);
//		System.out.println("计算的结果是=" + res);
	}

	// 将得到的中缀表达式转化为后缀表达式
	public static List<String> parseSuffixExpressionList(List<String> ls) {
		Stack<String> s1 = new Stack<String>();
		// 因为S2 在转化过程中没有pop操作，而且要逆序输出，因此直接用arrayList<string>s2;
		List<String> s2 = new ArrayList<String>();
		for (String itemString : ls) {
			// 如果是一个数则加入s2
			if (itemString.matches("\\d+")) {
				s2.add(itemString);
			} else if (itemString.equals("(")) {
				s1.push(itemString);
			} else if (itemString.equals(")")) {
				// 如果是右括号，则一次将s1的运算符弹出并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
				while (!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();// 将剩下的小括号 弹出，从而消除小括号
			} else {
				// 当item的优先级小于或等于栈顶的优先级，将s1栈顶的运算符弹出并加入到s2中，并让item继续与s1新的栈顶运算符比较
				while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(itemString)) {
					s2.add(s1.pop());
				}
				s1.push(itemString);
			}
		}
		while (s1.size() != 0) {
			s2.add(s1.pop());
		}
		return s2; // 因为是存放在list中的，因此按顺序输出即可
	}

	// 将中缀表达式转成对应的list
	public static List<String> toInfixExpressionList(String s) {
		// Define a list
		List<String> ls = new ArrayList<String>();
		int i = 0;// 用于遍历中缀表达式字符串
		String string;// 对多位数进行拼接
		char c;
		do {
			// 如果c是一个非数字，加入ls
			if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
				ls.add("" + c);
				i++;
			} else {// 如果是一个数，需要考虑多位数
				string = "";
				while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
					string += c;
					i++;
				}
				ls.add(string);
			}
		} while (i < s.length());
		return ls;
	}

	// 将一个逆波兰表达式，以此将数据和运算符放入到 arraylist 中
	public static List<String> getListString(String suffixExpression) {
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for (String ele : split) {
			list.add(ele);
		}
		return list;
	}

	// 完成对逆波兰表达式的计算
	public static int calculate(List<String> ls) {
		// 创建一个栈
		Stack<String> stack = new Stack<String>();
		for (String itemString : ls) {
			if (itemString.matches("\\d+")) {
				stack.push(itemString);
			} else {
				// pop 出俩个数并运算再入栈
				int num1 = Integer.parseInt(stack.pop());
				int num2 = Integer.parseInt(stack.pop());
				int res = 0;
				if (itemString.equals("+")) {
					res = num1 + num2;
				} else if (itemString.equals("-")) {
					res = num2 - num1;
				} else if (itemString.equals("*")) {
					res = num1 * num2;
				} else if (itemString.equals("/")) {
					res = num2 / num1;
				} else {
					throw new RuntimeException("运算符有误");
				}
				stack.push("" + res);
			}
		}
		// 最后留在stack是运算结果
		return Integer.parseInt(stack.pop());
	}

}

// 编写一个operation 类， 可以返回一个运算符对于的优先级
class Operation {
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;

	public static int getValue(String operation) {
		int result = 0;
		switch (operation) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;
		default:
			System.out.println("不存在该运算符");
			break;
		}
		return result;
	}
}
