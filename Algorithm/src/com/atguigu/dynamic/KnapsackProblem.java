package com.atguigu.dynamic;

public class KnapsackProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = { 0, 1, 4, 3 };
		int[] val = { 0, 1500, 3000, 2000 };
		int m = 4;
		int n = val.length;

		// Ϊ�˼�¼������Ʒ����������Ƕ���һ����ά����
		int[][] path = new int[n][m + 1];

		// ��ά����,��ʾǰi����Ʒװ������Ϊj�ı����ܵó�������ֵ
		int[][] v = new int[n][m + 1];

		// ��һ�к͵�һ�о�Ϊ��
		for (int i = 0; i < v.length; i++) {
			v[i][0] = 0;
		}

		for (int i = 0; i < v[0].length; i++) {
			v[0][i] = 0;
		}

		for (int i = 1; i < v.length; i++) {// �ӵڶ��п�ʼ
			for (int j = 1; j < v[0].length; j++) {// �ӵڶ��п�ʼ
				if (w[i] > j) {
					v[i][j] = v[i - 1][j];
				} else {
					// v[i][j] = Math.max(v[i - 1][j], val[i] + v[i - 1][j - w[i]]);
					// Ϊ�˼�¼��Ʒ���뱳���������������Ҫ�������ȥ�滻
					if (v[i - 1][j] < val[i] + v[i - 1][j - w[i]]) {
						v[i][j] = val[i] + v[i - 1][j - w[i]];
						// �ѵ�ǰ�������¼��path
						path[i][j] = 1;
					} else {
						v[i][j] = v[i - 1][j];
					}
				}
			}

		}

		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[0].length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
//		// ����path, ����������еķ���������õ���������Ҫ���ķ���
//		for (int i = 0; i < path.length; i++) {
//			for (int j = 0; j < path[0].length; j++) {
//				if (path[i][j] == 1) {
//					System.out.printf("��%d����Ʒ���뱳��\n", i);
//				}
//			}
//		}
		int i = path.length-1; // ������±�
		int j = path[0].length - 1;//������±�
		while (i > 0 && j > 0) {
			if (path[i][j] == 1) {
				System.out.printf("��%d����Ʒ���뱳��\n", i);
				j -= w[i]; //ʣ������
			}
			i --;
		}
		
	}

}
