package com.atguigu.stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		// test
		// create an arraystack
		ArrayStack stack = new ArrayStack(4);
		String key = "";
		boolean loop = true; // control menue
		Scanner scanner = new Scanner(System.in);
		while (loop) {
			System.out.println("show: 表示显示栈");
			System.out.println("exit: 表示退出");
			System.out.println("push: 表示添加数据到栈");
			System.out.println("pop: 表示从栈中取出数据");
			System.out.println("请输入你的选择");
			key = scanner.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("请输入一个数");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("出栈的数据是:%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
	}
}

//定义一个 用数组模拟的栈
class ArrayStack {
	private int maxSize;
	private int[] stack;
	private int top = -1;

	public ArrayStack(int maxsize) {
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
}