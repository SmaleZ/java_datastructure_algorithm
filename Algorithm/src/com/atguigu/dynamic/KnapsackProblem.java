package com.atguigu.dynamic;

public class KnapsackProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = { 0, 1, 4, 3 };
		int[] val = { 0, 1500, 3000, 2000 };
		int m = 4;
		int n = val.length;

		// 为了记录放入商品的情况，我们定义一个二维数组
		int[][] path = new int[n][m + 1];

		// 二维数组,表示前i个物品装入容量为j的背包能得出的最大价值
		int[][] v = new int[n][m + 1];

		// 第一行和第一列均为零
		for (int i = 0; i < v.length; i++) {
			v[i][0] = 0;
		}

		for (int i = 0; i < v[0].length; i++) {
			v[0][i] = 0;
		}

		for (int i = 1; i < v.length; i++) {// 从第二行开始
			for (int j = 1; j < v[0].length; j++) {// 从第二列开始
				if (w[i] > j) {
					v[i][j] = v[i - 1][j];
				} else {
					// v[i][j] = Math.max(v[i - 1][j], val[i] + v[i - 1][j - w[i]]);
					// 为了记录商品放入背包的情况，我们需要条件语句去替换
					if (v[i - 1][j] < val[i] + v[i - 1][j - w[i]]) {
						v[i][j] = val[i] + v[i - 1][j - w[i]];
						// 把当前的情况记录到path
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
//		// 遍历path, 这样会把所有的放入情况都得到，我们需要最后的放入
//		for (int i = 0; i < path.length; i++) {
//			for (int j = 0; j < path[0].length; j++) {
//				if (path[i][j] == 1) {
//					System.out.printf("第%d个商品放入背包\n", i);
//				}
//			}
//		}
		int i = path.length-1; // 最大行下标
		int j = path[0].length - 1;//最大列下标
		while (i > 0 && j > 0) {
			if (path[i][j] == 1) {
				System.out.printf("第%d个商品放入背包\n", i);
				j -= w[i]; //剩余重量
			}
			i --;
		}
		
	}

}
