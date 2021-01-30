package com.atguigu.stack;

import java.util.ArrayList;

import java.util.List;
import java.util.Stack;

public class PolanNotation {

	public static void main(String[] args) {

		// ����׺���ʽת���ɺ�׺���ʽ
		// 1. 1+((2+3)*4)-5 => 1 2 3 + 4 * + 5 -
		// 2. ��Ϊֱ�Ӷ��ַ���ɨ�費���㣬 ����Ƚ��ַ���ת����׺���ʽ��ʽ��Ӧ��list
		// 3. ���õ�����׺���ʽ���ڵ�List ת��Ϊ ��׺���ʽ��Ӧ��List

		String expressionString = "1+((2+3)*4)-5";
		List<String> infixExpressionList = toInfixExpressionList(expressionString);
		System.out.println(infixExpressionList);
		System.out.println("��׺���ʽ��Ӧ��list" + parseSuffixExpressionList(infixExpressionList));
		System.out.printf("expression=%d", calculate(parseSuffixExpressionList(infixExpressionList)));
		// �ȶ���һ���沨�����ʽ
		// (3+4) * 5 -6 => 3 4 + 5 * 6 -
		// Ϊ�˷��㣬�沨�����ʽ�����ֺͷ���ʹ�ÿո����
		String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
		// �Ƚ� ���ʽ���� arraylist��
		// ��arraylist ���ݸ�һ�����������ջ��ɼ���
//		List<String> list = getListString(suffixExpression);
//		int res = calculate(list);
//		System.out.println("����Ľ����=" + res);
	}

	// ���õ�����׺���ʽת��Ϊ��׺���ʽ
	public static List<String> parseSuffixExpressionList(List<String> ls) {
		Stack<String> s1 = new Stack<String>();
		// ��ΪS2 ��ת��������û��pop����������Ҫ������������ֱ����arrayList<string>s2;
		List<String> s2 = new ArrayList<String>();
		for (String itemString : ls) {
			// �����һ���������s2
			if (itemString.matches("\\d+")) {
				s2.add(itemString);
			} else if (itemString.equals("(")) {
				s1.push(itemString);
			} else if (itemString.equals(")")) {
				// ����������ţ���һ�ν�s1�������������ѹ��s2��ֱ������������Ϊֹ����ʱ����һ�����Ŷ���
				while (!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();// ��ʣ�µ�С���� �������Ӷ�����С����
			} else {
				// ��item�����ȼ�С�ڻ����ջ�������ȼ�����s1ջ������������������뵽s2�У�����item������s1�µ�ջ��������Ƚ�
				while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(itemString)) {
					s2.add(s1.pop());
				}
				s1.push(itemString);
			}
		}
		while (s1.size() != 0) {
			s2.add(s1.pop());
		}
		return s2; // ��Ϊ�Ǵ����list�еģ���˰�˳���������
	}

	// ����׺���ʽת�ɶ�Ӧ��list
	public static List<String> toInfixExpressionList(String s) {
		// Define a list
		List<String> ls = new ArrayList<String>();
		int i = 0;// ���ڱ�����׺���ʽ�ַ���
		String string;// �Զ�λ������ƴ��
		char c;
		do {
			// ���c��һ�������֣�����ls
			if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
				ls.add("" + c);
				i++;
			} else {// �����һ��������Ҫ���Ƕ�λ��
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

	// ��һ���沨�����ʽ���Դ˽����ݺ���������뵽 arraylist ��
	public static List<String> getListString(String suffixExpression) {
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for (String ele : split) {
			list.add(ele);
		}
		return list;
	}

	// ��ɶ��沨�����ʽ�ļ���
	public static int calculate(List<String> ls) {
		// ����һ��ջ
		Stack<String> stack = new Stack<String>();
		for (String itemString : ls) {
			if (itemString.matches("\\d+")) {
				stack.push(itemString);
			} else {
				// pop ������������������ջ
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
					throw new RuntimeException("���������");
				}
				stack.push("" + res);
			}
		}
		// �������stack��������
		return Integer.parseInt(stack.pop());
	}

}

// ��дһ��operation �࣬ ���Է���һ����������ڵ����ȼ�
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
			System.out.println("�����ڸ������");
			break;
		}
		return result;
	}
}
