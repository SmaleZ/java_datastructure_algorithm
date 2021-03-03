package com.atguigu.sort;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		int arr[] = { 3, 9, -1, 10, -2 };
		selectSort(arr);
		
	}
	public static void selectSort(int[] arr) {
		//选择排序，时间复杂度为O（n^2）
		//boolean flag = false; // 标识变量，表示是否进行过交换，冒泡排序的简单优化
		for (int i = 0; i < arr.length-1; i++) {
			// 共有length-1轮
			int min = arr[i];
			int minIdex = i;
			for (int j = i+1; j < arr.length; j++) {
				//找到当前最小值,打擂台
				if (arr[j] < min) {
					min = arr[j];
					minIdex = j;
				}
			}
			if (minIdex!=i) {
				arr[minIdex] = arr[i];
				arr[i] =  min;
			}
			
			System.out.println("第" + (i+1) + "躺排序的数组");
			System.out.println(Arrays.toString(arr));

//			if (!flag) {// 表示这一趟没有交换
//				break;
//			} else {
//				flag = false;
//			}
		}
	}

}
