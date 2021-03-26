package com.atguigu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	
	private ArrayList<String> vertexList; //�洢���㼯��
	private int[][] edages;
	private int numOfEdges;
	//��¼ĳ���ڵ��Ƿ񱻷���
	private boolean[] isVisited;
	public static void main(String[] args) {
		int n = 5;
		String vertexString[] = {"A","B","C","D","E"};
		Graph graph = new Graph(n);
		for (String vertex : vertexString) {
			graph.insertVertex(vertex);
		}
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		
		//��ʾ
		//graph.showGraph();
		
		//����������ȱ���
		//System.out.println("��ȱ���");
		//graph.dfs();
		
		System.out.println("��ȱ���");
		graph.bfs();
		
	}
	
	public Graph(int n) {
		edages = new int[n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0;
		isVisited = new boolean[5];
				
	}
	//ͼ�г��õķ���
	//�õ���һ���ڽӽڵ���±�w
	public int getFirstNeighbor(int index) {
		for (int j = 0; j < vertexList.size(); j++) {
			if (edages[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	
	//����ǰһ���ڽӽڵ���±�,����ȡ��һ���ڽӽڵ�
	public int getNextNeighbor(int v1, int v2) {
		for (int j = v2 + 1; j < vertexList.size(); j++) {
			if (edages[v1][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	
	//������ȱ����㷨
	private void dfs(boolean[] isVisited, int i) {
		//�������Ƿ��ʸýڵ㣬���
		System.out.println(getValueByIndex(i) + "->");
		//������ڵ����ó��Ѿ�����
		isVisited[i] = true;
		//���ҽ��i�ĵ�һ���ڽӽڵ�
		int w = getFirstNeighbor(i);
		while (w != -1) {
			if (!isVisited[w]) {
				dfs(isVisited, w);
			}
			//���w�Ѿ������ʹ�������Ҫ������һ���ڽӽڵ�
			w = getNextNeighbor(i, w);
		}
		
	}
	//����dfs,�������нڵ�
	public void dfs() {
		//�������еĽڵ㣬����dfs,���ݷ�
		for (int i = 0; i < vertexList.size(); i++) {
			if (!isVisited[i]) {
				dfs(isVisited, i);
			}		
		}
	}
	
	//��һ���ڵ���й�����ȱ����ķ���
	private void bfs(boolean[] isVisited, int i) {
		int u; //��ʾ���е�ͷ����Ӧ���±�
		int w; //��ʾ�ڽӽڵ�
		//�ڵ���У���¼�ڵ��������
		LinkedList queue = new LinkedList();
		//���ʽڵ㣬����ڵ���Ϣ
		System.out.print(getValueByIndex(i) + "=>");
		isVisited[i] = true;
		queue.addLast(i);
		while (!queue.isEmpty()) {
			u =(Integer)queue.removeFirst();
			w = getFirstNeighbor(u);
			while (w != -1) {
				if (!isVisited[w]) {
					System.out.print(getValueByIndex(w) + "=>");
					isVisited[w] = true;
					
					queue.addLast(w);
				}
				//w�Ѿ������ʹ�,����һ���ڽӽڵ�
				w = getNextNeighbor(u, w); //���ֹ������
				
			}
		}
		
	}
	//����bfs, �������еĽڵ�, �����й����������
	public void bfs() {
		for (int i = 0; i < getNumOfVertex(); i++) {
			if (!isVisited[i]) {
				bfs(isVisited, i);
			}
			
		}
	}
	//���ؽڵ�ĸ���
	public int getNumOfVertex() {
		return vertexList.size();
	}
	
	//��ʾͼ��Ӧ�ľ���
	public void showGraph() {
		for (int[] link : edages) {
			System.err.println(Arrays.toString(link));
		}
	}
	//���رߵ���Ŀ
	public int getNumOfEdges() {
		return numOfEdges;
	}
	//���ؽ��i���ڵ�����
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}
	//����v1��v2��Ȩֵ
	public int getWeight(int v1, int v2) {
		return edages[v1][v2];
	}
	
	//���붥��
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}
	//�����
	public void insertEdge(int v1, int v2, int weight) {
		edages[v1][v2] = weight;
		edages[v2][v1] = weight;
		numOfEdges ++;
	}
}
