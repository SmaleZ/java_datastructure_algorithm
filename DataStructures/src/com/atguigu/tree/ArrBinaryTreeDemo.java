package com.atguigu.tree;

public class ArrBinaryTreeDemo {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
		
		System.out.println("前序遍历");
		arrBinaryTree.preOrder();
		System.out.println("中序遍历");
		arrBinaryTree.infixOrder();
		System.out.println("后序遍历");
		arrBinaryTree.postOrder();
	}

}

class ArrBinaryTree {
	// 顺序存储二叉树，也即是 堆， 其具有堆序性质

	private int[] arr;

	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}

	// 重载遍历方法
	public void preOrder() {
		this.preOrder(0);
	}
	
	public void infixOrder() {
		this.infixOrder(0);
	}
	
	public void postOrder() {
		this.postOrder(0);
	}

	// 前序遍历
	public void preOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空");
		}
		System.out.println(arr[index]);
		// 向左递归
		if ((index * 2 + 1) < arr.length) {
			preOrder(index * 2 + 1);
		}
		// 向右递归
		if ((index * 2 + 2) < arr.length) {
			preOrder(index * 2 + 2);
		}

	}

	// 中序遍历
	public void infixOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空");
		}
		// 向左递归
		if ((index * 2 + 1) < arr.length) {
			infixOrder(index * 2 + 1);
		}
		System.out.println(arr[index]);

		// 向右递归
		if ((index * 2 + 2) < arr.length) {
			infixOrder(index * 2 + 2);
		}

	}
	
	// 后序遍历
	public void postOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空");
		}
		// 向左递归
		if ((index * 2 + 1) < arr.length) {
			postOrder(index * 2 + 1);
		}
		

		// 向右递归
		if ((index * 2 + 2) < arr.length) {
			postOrder(index * 2 + 2);
		}
		
		System.out.println(arr[index]);

	}
}
