package com.atguigu.dac;

public class Hanotower {

	public static void main(String[] args) {
		hanoTower(5, 'A', 'B', 'C');

	}
	
	//汉诺塔的移动方法
	/**
	 * 
	 * @param num 盘子的个数
	 * @param a   起始柱子
	 * @param b   中间柱子
	 * @param c	  目标柱子
	 */
	public static void hanoTower(int num, char a, char b, char c) {
		if (num == 1) {
			System.out.println("第1个盘从" + a + "->" + c);
		}else {
			//如果n>=2, 则我们总可以看作俩个盘，1.最下面的一个盘，2.上面的所有盘
			//1. 先把最上面的所有盘从a -》 b, 移动过程需要用到c
			hanoTower(num-1, a, c, b);
			//2. 把最下面的移动到从a 移动到 c
			System.out.println("第" + num + "个盘从" + a + "->" + c);
			//3. 把1.中b上的所有盘从b 移动到 c
			hanoTower(num-1, b, a, c);
		}
	}
	

}
