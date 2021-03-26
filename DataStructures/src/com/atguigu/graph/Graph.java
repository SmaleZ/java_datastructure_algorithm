package com.atguigu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	
	private ArrayList<String> vertexList; //存储顶点集合
	private int[][] edages;
	private int numOfEdges;
	//记录某个节点是否被访问
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
		
		//显示
		//graph.showGraph();
		
		//测试深度优先遍历
		//System.out.println("深度遍历");
		//graph.dfs();
		
		System.out.println("广度遍历");
		graph.bfs();
		
	}
	
	public Graph(int n) {
		edages = new int[n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0;
		isVisited = new boolean[5];
				
	}
	//图中常用的方法
	//得到第一个邻接节点的下标w
	public int getFirstNeighbor(int index) {
		for (int j = 0; j < vertexList.size(); j++) {
			if (edages[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	
	//根据前一个邻接节点的下标,来获取下一个邻接节点
	public int getNextNeighbor(int v1, int v2) {
		for (int j = v2 + 1; j < vertexList.size(); j++) {
			if (edages[v1][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	
	//深度优先遍历算法
	private void dfs(boolean[] isVisited, int i) {
		//首先我们访问该节点，输出
		System.out.println(getValueByIndex(i) + "->");
		//将这个节点设置成已经访问
		isVisited[i] = true;
		//查找结点i的第一个邻接节点
		int w = getFirstNeighbor(i);
		while (w != -1) {
			if (!isVisited[w]) {
				dfs(isVisited, w);
			}
			//如果w已经被访问过，则需要访问下一个邻接节点
			w = getNextNeighbor(i, w);
		}
		
	}
	//重载dfs,遍历所有节点
	public void dfs() {
		//遍历所有的节点，进行dfs,回溯法
		for (int i = 0; i < vertexList.size(); i++) {
			if (!isVisited[i]) {
				dfs(isVisited, i);
			}		
		}
	}
	
	//对一个节点进行广度优先遍历的方法
	private void bfs(boolean[] isVisited, int i) {
		int u; //表示队列的头结点对应的下标
		int w; //表示邻接节点
		//节点队列，记录节点访问数据
		LinkedList queue = new LinkedList();
		//访问节点，输出节点信息
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
				//w已经被访问过,找下一个邻接节点
				w = getNextNeighbor(u, w); //体现广度优先
				
			}
		}
		
	}
	//重载bfs, 遍历所有的节点, 都进行广度优先搜索
	public void bfs() {
		for (int i = 0; i < getNumOfVertex(); i++) {
			if (!isVisited[i]) {
				bfs(isVisited, i);
			}
			
		}
	}
	//返回节点的个数
	public int getNumOfVertex() {
		return vertexList.size();
	}
	
	//显示图对应的矩阵
	public void showGraph() {
		for (int[] link : edages) {
			System.err.println(Arrays.toString(link));
		}
	}
	//返回边的数目
	public int getNumOfEdges() {
		return numOfEdges;
	}
	//返回结点i对于的数据
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}
	//返回v1和v2的权值
	public int getWeight(int v1, int v2) {
		return edages[v1][v2];
	}
	
	//插入顶点
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}
	//插入边
	public void insertEdge(int v1, int v2, int weight) {
		edages[v1][v2] = weight;
		edages[v2][v1] = weight;
		numOfEdges ++;
	}
}
