package com.atguigu.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HuffmanTree {

	public static void main(String[] args) {
		int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
		Node root = createHuffmanTree(arr);
		
		//测试
		root.preOrder();
		
	}
	
	public static void preOrder(Node root) {
		if (root != null) {
			root.preOrder();
		}else {
			System.out.println("是空树");
		}
	}

	public static Node createHuffmanTree(int arr[]) {
		// 遍历 arr 数组，将arr的每个元素构成一个node，将node 放在ArrayList 中
		List<Node> nodes = new ArrayList<Node>();
		for (int value : arr) {
			nodes.add(new Node(value));
		}

		//
		while (nodes.size() > 1) {
			Collections.sort(nodes);

			System.out.println("nodes=" + nodes);

			// 取出权值最小的两科二叉树
			//
			Node left = nodes.get(0);
			Node right = nodes.get(1);

			Node parent = new Node(left.value + right.value);
			parent.left = left;
			parent.right = right;

			// 从ArrayList删除处理过的二叉树
			nodes.remove(left);
			nodes.remove(right);
			// 将新的parent加入
			nodes.add(parent);
		}
		
		return nodes.get(0);

	}

}

//创建结点类
//为了让对象 支持排序collections集合排序，这里需要实现一个comparable 的方法
class Node implements Comparable<Node> {
	int value;
	Node left;
	Node right;
	
	// 前序遍历
	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}
	
	public Node(int value) {
		this.value = value;
	}

	public int compareTo(Node o) {
		// 表示从小到大的排序
		return this.value - o.value;
	}

	@Override
	public String toString() {

		return "Node [value=" + value + "]";
	}
}