package com.atguigu.queue;

import java.util.Scanner;

public class CircleArrayDemo {

	public static void main(String[] args) {
		// 测试数组模拟环形队列
		CircleArray queue = new CircleArray(4); // 设置为4 有效空间为3
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
	private int front; // queue head 指向队列的第一个元素 初始值为0
	private int rear; // queue tail 指向队列最后一个元素的后一个位置，因为希望空出一个位置，初始值也是0
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
		// 这里需要分析出 front是指向队列的第一个元素
		// 1.先保存front对应的数据
		// 2、将front后移
		// 3、将零食变量取模
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
		// 从front 开始遍历
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}

	
	/**
	 * @return  求出当前队列有效数据的个数
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