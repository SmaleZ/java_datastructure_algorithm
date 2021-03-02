package com.atguigu.recursion;



public class Queue8 {
	// 定义一个max表示共有多少个皇后
	int max = 8;
	// 定义一个数组array, 保存皇后放置的结果
	int[] array = new int[max];
	static int count = 0;
	public static void main(String[] args) {
		//test
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.printf("一共有%d解法", count);
		
	}
	//放置第n个皇后
	private void check(int n) {
		if(n == max) { // n=8，8个皇后已经放好, 也是递归的临界情况
			print();
			return;
		}
		for(int i = 0; i < max; i++) {
			//先把当前这个皇后n，放在改行的第1列
			array[n] = i;
			if (judge(n)) {
				check(n+1);
			}
			//如果冲突继续执行array[n] = i; 即将第n个皇后，放置在本行的后一个位置
		}
	}
	
	//查看当我们放置第n个皇后，就去检测该皇后是否和前面已经放好的皇后冲突
	/**
	 * @param n 表示第n个皇后
	 * @return
	 */
	private boolean judge(int n) {
		for(int i=0; i<n; i++) {
			if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}
	
	//print
	private void print() {
		count ++;
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
