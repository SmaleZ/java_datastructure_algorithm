package com.atguigu.tree;

public class ArrBinaryTreeDemo {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
		
		System.out.println("ǰ�����");
		arrBinaryTree.preOrder();
		System.out.println("�������");
		arrBinaryTree.infixOrder();
		System.out.println("�������");
		arrBinaryTree.postOrder();
	}

}

class ArrBinaryTree {
	// ˳��洢��������Ҳ���� �ѣ� ����ж�������

	private int[] arr;

	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}

	// ���ر�������
	public void preOrder() {
		this.preOrder(0);
	}
	
	public void infixOrder() {
		this.infixOrder(0);
	}
	
	public void postOrder() {
		this.postOrder(0);
	}

	// ǰ�����
	public void preOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ��");
		}
		System.out.println(arr[index]);
		// ����ݹ�
		if ((index * 2 + 1) < arr.length) {
			preOrder(index * 2 + 1);
		}
		// ���ҵݹ�
		if ((index * 2 + 2) < arr.length) {
			preOrder(index * 2 + 2);
		}

	}

	// �������
	public void infixOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ��");
		}
		// ����ݹ�
		if ((index * 2 + 1) < arr.length) {
			infixOrder(index * 2 + 1);
		}
		System.out.println(arr[index]);

		// ���ҵݹ�
		if ((index * 2 + 2) < arr.length) {
			infixOrder(index * 2 + 2);
		}

	}
	
	// �������
	public void postOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ��");
		}
		// ����ݹ�
		if ((index * 2 + 1) < arr.length) {
			postOrder(index * 2 + 1);
		}
		

		// ���ҵݹ�
		if ((index * 2 + 2) < arr.length) {
			postOrder(index * 2 + 2);
		}
		
		System.out.println(arr[index]);

	}
}
