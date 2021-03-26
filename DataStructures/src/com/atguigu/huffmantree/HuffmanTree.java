package com.atguigu.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HuffmanTree {

	public static void main(String[] args) {
		int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
		Node root = createHuffmanTree(arr);
		
		//����
		root.preOrder();
		
	}
	
	public static void preOrder(Node root) {
		if (root != null) {
			root.preOrder();
		}else {
			System.out.println("�ǿ���");
		}
	}

	public static Node createHuffmanTree(int arr[]) {
		// ���� arr ���飬��arr��ÿ��Ԫ�ع���һ��node����node ����ArrayList ��
		List<Node> nodes = new ArrayList<Node>();
		for (int value : arr) {
			nodes.add(new Node(value));
		}

		//
		while (nodes.size() > 1) {
			Collections.sort(nodes);

			System.out.println("nodes=" + nodes);

			// ȡ��Ȩֵ��С�����ƶ�����
			//
			Node left = nodes.get(0);
			Node right = nodes.get(1);

			Node parent = new Node(left.value + right.value);
			parent.left = left;
			parent.right = right;

			// ��ArrayListɾ��������Ķ�����
			nodes.remove(left);
			nodes.remove(right);
			// ���µ�parent����
			nodes.add(parent);
		}
		
		return nodes.get(0);

	}

}

//���������
//Ϊ���ö��� ֧������collections��������������Ҫʵ��һ��comparable �ķ���
class Node implements Comparable<Node> {
	int value;
	Node left;
	Node right;
	
	// ǰ�����
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
		// ��ʾ��С���������
		return this.value - o.value;
	}

	@Override
	public String toString() {

		return "Node [value=" + value + "]";
	}
}