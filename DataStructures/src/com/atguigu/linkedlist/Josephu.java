package com.atguigu.linkedlist;

/*
 * 利用单向环形链表解决约瑟夫问题
 */
public class Josephu {

	public static void main(String[] args) {
		// 测试
		CircleSingleLinedList circleSingleLinedList = new CircleSingleLinedList();
		circleSingleLinedList.addBoy(5);
		circleSingleLinedList.showBoy();

		circleSingleLinedList.countBoy(1, 2, 5);
	}

}

//创建一个环形的单向链表
class CircleSingleLinedList {
	// 创建以一个first 节点，当前没有编号
	private Boy first = new Boy(-1);

	// 添加小孩节点，构成一个环形的链表
	public void addBoy(int nums) {
		// nums test
		if (nums < 1) {
			System.out.println("nums 的值不正确");
			return;
		}
		Boy curBoy = null; // 辅助指针
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				first.setNext(first);
				curBoy = first;
			} else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}

	public void showBoy() {
		// 判断链表是否为空
		if (first == null) {
			System.out.println("链表为空，没有任何小孩");
		}
		Boy curBoy = first;
		while (true) {
			System.out.printf("小孩的编号 %d \n", curBoy.getNo());
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}

	}

	/**
	 * 
	 * @param startNo  开始报数的小孩的编号
	 * @param countNum 报数的个数
	 * @param nums     总共有几个小孩
	 */
	// 根据用户的输入，计算出小孩出圈的顺序
	public void countBoy(int startNo, int countNum, int nums) {
		// 校验
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("参数输入有误，请重新输入");
			return;
		}
		// 报数前先将first 移动到 开始报数的小孩节点上
		for (int j = 0; j < startNo - 1; j++) {
			first = first.getNext();
		}
		Boy helpBoy = first;
		// 将helper 指针移动到first 的后一个位置，因为是单链表，如果要删除某个节点，需要将辅助指针指在这个节点前面一个位置
		while (true) {
			if (helpBoy.getNext() == first) {
				break;
			}
			helpBoy = helpBoy.getNext();
		}
		// 让first 与helper 同时移动 countNum -1 次，然后出圈
		while (true) {
			if (helpBoy == first) {
				break;
			}
			// 让 helper 和 first 同时移动 countNum - 1
			for (int j = 0; j < countNum - 1; j++) {
				first = first.getNext();
				helpBoy = helpBoy.getNext();
			}
			System.out.printf("小孩 %d 出圈\n ", first.getNo());
			first = first.getNext();
			helpBoy.setNext(first);
		}
		System.out.printf("最后留在圈中的小孩的编号为 %d \n", first.getNo());
	}

}

//创建一个boy类，表示一个节点
class Boy {
	private int no;
	private Boy next;

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}

}
