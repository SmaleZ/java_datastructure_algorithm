package com.atguigu.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		// test
		// creat a queue
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s(show)");
			System.out.println("e(exit)");
			System.out.println("a(add)");
			System.out.println("g(get)");
			System.out.println("h(head)");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("out put one data");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				try {
					int res = queue.getQueue();
					System.out.printf("the data you got is %d\n", res);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = queue.headQueue();
					System.out.printf("the head of the queue is %d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());

				}
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("program has exited");
	}

}

//using array to make a queue
class ArrayQueue {
	private int maxSize; // maximum storage
	private int front; // queue head
	private int rear; // queue tail
	private int[] arr; // queue

	// constructor of queue
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;// pointing at head of queue
		rear = -1; // pointing at end of queue
	}

	// whether full
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	// whether empty
	public boolean isEmpty() {
		return rear == front;
	}

	// adding data
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("The queue is full!");
			return;
		}
		rear++;
		arr[rear] = n;
	}

	// get data from queue, pop
	public int getQueue() {
		if (isEmpty()) {
			// throw exception
			throw new RuntimeException("queue is empty, cannot get data");
		}
		front++;
		return arr[front];
	}

	// print all the data in the queue
	public void showQueue() {
		// traverse
		if (isEmpty()) {
			System.out.println("queue is empty");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}

	// show head data without getting
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("queue is empty");
		}
		return arr[front + 1];
	}

}