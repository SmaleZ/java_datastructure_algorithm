package com.atguigu.linkedlist;

/*
 * ���õ�����������Լɪ������
 */
public class Josephu {

	public static void main(String[] args) {
		// ����
		CircleSingleLinedList circleSingleLinedList = new CircleSingleLinedList();
		circleSingleLinedList.addBoy(5);
		circleSingleLinedList.showBoy();

		circleSingleLinedList.countBoy(1, 2, 5);
	}

}

//����һ�����εĵ�������
class CircleSingleLinedList {
	// ������һ��first �ڵ㣬��ǰû�б��
	private Boy first = new Boy(-1);

	// ���С���ڵ㣬����һ�����ε�����
	public void addBoy(int nums) {
		// nums test
		if (nums < 1) {
			System.out.println("nums ��ֵ����ȷ");
			return;
		}
		Boy curBoy = null; // ����ָ��
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
		// �ж������Ƿ�Ϊ��
		if (first == null) {
			System.out.println("����Ϊ�գ�û���κ�С��");
		}
		Boy curBoy = first;
		while (true) {
			System.out.printf("С���ı�� %d \n", curBoy.getNo());
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}

	}

	/**
	 * 
	 * @param startNo  ��ʼ������С���ı��
	 * @param countNum �����ĸ���
	 * @param nums     �ܹ��м���С��
	 */
	// �����û������룬�����С����Ȧ��˳��
	public void countBoy(int startNo, int countNum, int nums) {
		// У��
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("����������������������");
			return;
		}
		// ����ǰ�Ƚ�first �ƶ��� ��ʼ������С���ڵ���
		for (int j = 0; j < startNo - 1; j++) {
			first = first.getNext();
		}
		Boy helpBoy = first;
		// ��helper ָ���ƶ���first �ĺ�һ��λ�ã���Ϊ�ǵ��������Ҫɾ��ĳ���ڵ㣬��Ҫ������ָ��ָ������ڵ�ǰ��һ��λ��
		while (true) {
			if (helpBoy.getNext() == first) {
				break;
			}
			helpBoy = helpBoy.getNext();
		}
		// ��first ��helper ͬʱ�ƶ� countNum -1 �Σ�Ȼ���Ȧ
		while (true) {
			if (helpBoy == first) {
				break;
			}
			// �� helper �� first ͬʱ�ƶ� countNum - 1
			for (int j = 0; j < countNum - 1; j++) {
				first = first.getNext();
				helpBoy = helpBoy.getNext();
			}
			System.out.printf("С�� %d ��Ȧ\n ", first.getNo());
			first = first.getNext();
			helpBoy.setNext(first);
		}
		System.out.printf("�������Ȧ�е�С���ı��Ϊ %d \n", first.getNo());
	}

}

//����һ��boy�࣬��ʾһ���ڵ�
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
