package com.atguigu.stack;

import java.util.Scanner;

public class LinkedListStackDemo {

	public static void main(String[] args) {
		// Test
		LinkedListStack stack = new LinkedListStack(4); 
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
				stack.printStack();
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

class LinkedListStack {
	private int maxSize;
	private LinkedList listStack;
	private Node top;
	private int currSize;

	public LinkedListStack(int maxsize) {
		this.maxSize = maxsize;
		this.currSize = 0;
		this.listStack = new LinkedList();
		this.top = this.listStack.head;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getCurrSize() {
		return currSize;
	}

	public void setCurrSize(int currSize) {
		this.currSize = currSize;
	}

	// 栈满
	public boolean isFull() {
		return currSize == maxSize;
	}

	// 栈空
	public boolean isEmpty() {
		return currSize == 0;
	}

	// push
	public void push(int value) {
		if (isFull()) {
			System.out.println("stack is full!");
			return;
		}
		Node newNode = new Node(value);
		listStack.add(newNode);
		currSize++;
		top = top.next;
	}

	// pop
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("stack is empty!");
		}
		int value = top.value;
		top.pre.next = null;
		top = top.pre;
		currSize--;
		
		return value;
	}

	// show
	public void printStack() {
		if (isEmpty()) {
			System.out.println("stack is empty!");
			return;
		}
		Node tempNode = top;
		while (true) {
			if (top == listStack.head) {
				break;
			}
			System.out.printf("from top to bottom the value of listStack = %d\n", top.value);
			top = top.pre;
		}
		top = tempNode;
	}
}

class LinkedList {
	public Node head = new Node(0);

	// add node to linked list
	public void add(Node newNode) {
		// 1. find the tail of list
		// 2. point the next to the new node
		// 3. need a temp node to traverse
		Node tempHeroNode = head;
		while (true) {
			if (tempHeroNode.next == null) {
				break;
			}
			tempHeroNode = tempHeroNode.next;
		}
		tempHeroNode.next = newNode;
		newNode.pre = tempHeroNode;
	}

	// show the list
	public void printFromHead() {
		if (head.next == null) {
			System.out.println("list is empty!");
			return;
		}
		Node tempHeroNode = head.next;
		while (true) {
			if (tempHeroNode == null) {
				break;
			}
			System.out.println(tempHeroNode);
			tempHeroNode = tempHeroNode.next;
		}
	}
}

class Node {
	public int value;
	public Node next;
	public Node pre;

	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

}
