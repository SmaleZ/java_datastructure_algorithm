package com.atguigu.queue;

import java.util.Scanner;

public class CircleArrayDemo {

	public static void main(String[] args) {
		// ��������ģ�⻷�ζ���
		CircleArray queue = new CircleArray(4); // ����Ϊ4 ��Ч�ռ�Ϊ3
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

/**
 * @author Zili
 *
 */
class CircleArray {
	private int maxSize; // maximum storage
	private int front; // queue head ָ����еĵ�һ��Ԫ�� ��ʼֵΪ0
	private int rear; // queue tail ָ��������һ��Ԫ�صĺ�һ��λ�ã���Ϊϣ���ճ�һ��λ�ã���ʼֵҲ��0
	private int[] arr; // queue

	public CircleArray(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
	}

	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	// adding data
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("The queue is full!");
			return;
		}
		arr[rear] = n;

		rear = (rear + 1) % maxSize;
	}

	// get data from queue, pop
	public int getQueue() {
		if (isEmpty()) {
			// throw exception
			throw new RuntimeException("queue is empty, cannot get data");
		}
		// ������Ҫ������ front��ָ����еĵ�һ��Ԫ��
		// 1.�ȱ���front��Ӧ������
		// 2����front����
		// 3������ʳ����ȡģ
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	// print all the data in the queue
	public void showQueue() {
		// traverse
		if (isEmpty()) {
			System.out.println("queue is empty");
		}
		// ��front ��ʼ����
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}

	
	/**
	 * @return  �����ǰ������Ч���ݵĸ���
	 */
	public int size() {
		return (rear - front + maxSize) % maxSize;
	}

	// 
	/**
	 * 
	 * @return head data without getting
	 */
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("queue is empty");
		}
		return arr[front];
	}

}