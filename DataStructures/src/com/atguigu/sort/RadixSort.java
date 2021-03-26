package com.atguigu.sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int arr[] = { 53, 3, 542, 748, 14, 214 };
		radixSort(arr);
	}

	public static void radixSort(int[] arr) {
		// 第1轮

		// 定义一个二维数组，每个桶表示一个一维数组
		// 为了防止放入数的时候数据溢出，则每个一维数组桶的大小定为arr.length
		// 这里可以看出桶排序是使用空间换时间的经典算法
		int[][] bucket = new int[10][arr.length];

		// 为了记录每个桶中实际放了多少个数据, 我们定义一个额外的一维数组来记录各个桶的每次放入的数据个数
		int[] buckerElementCounts = new int[10];

		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int maxLength = (max + "").length();

		for (int i = 0, n=1; i < maxLength; i++, n*=10) {
			// 第1轮
			for (int j = 0; j < arr.length; j++) {
				int digitOfElement = arr[j] / n % 10;
				bucket[digitOfElement][buckerElementCounts[digitOfElement]] = arr[j];

				buckerElementCounts[digitOfElement]++;

			}
			// 桶中数据放回原数组
			int index = 0;
			for (int k = 0; k < bucket.length; k++) {
				if (buckerElementCounts[k] != 0) {
					for (int l = 0; l < buckerElementCounts[k]; l++) {
						arr[index++] = bucket[k][l];
					}
				}
				// 每一輪放回去以後要把之前記錄每個桶實際放了多少個數據的數組清零
				buckerElementCounts[k] = 0;
			}
			System.out.println("第"+ (i+1)+"轮的排序结果为：" + Arrays.toString(arr));
		}

//		// 第1轮
//		for (int i = 0; i < arr.length; i++) {
//			int digitOfElement = arr[i] / 1 % 10;
//			bucket[digitOfElement][buckerElementCounts[digitOfElement]] = arr[i];
//
//			buckerElementCounts[digitOfElement]++;
//
//		}
//		// 桶中数据放回原数组
//		int index = 0;
//		for (int k = 0; k < bucket.length; k++) {
//			if (buckerElementCounts[k] != 0) {
//				for (int l = 0; l < buckerElementCounts[k]; l++) {
//					arr[index++] = bucket[k][l];
//				}
//			}
//			// 每一輪放回去以後要把之前記錄每個桶實際放了多少個數據的數組清零
//			buckerElementCounts[k] = 0;
//		}
//
//		// 第2轮
//		for (int i = 0; i < arr.length; i++) {
//			int digitOfElement = arr[i] / 10 % 10;
//			bucket[digitOfElement][buckerElementCounts[digitOfElement]] = arr[i];
//
//			buckerElementCounts[digitOfElement]++;
//
//		}
//		// 桶中数据放回原数组
//		index = 0;
//		for (int k = 0; k < bucket.length; k++) {
//			if (buckerElementCounts[k] != 0) {
//				for (int l = 0; l < buckerElementCounts[k]; l++) {
//					arr[index++] = bucket[k][l];
//				}
//			}
//			// 每一輪放回去以後要把之前記錄每個桶實際放了多少個數據的數組清零
//			buckerElementCounts[k] = 0;
//		}
//
//		// 第3轮
//		for (int i = 0; i < arr.length; i++) {
//			int digitOfElement = arr[i] / 100 % 10;
//			bucket[digitOfElement][buckerElementCounts[digitOfElement]] = arr[i];
//
//			buckerElementCounts[digitOfElement]++;
//
//		}
//		// 桶中数据放回原数组
//		index = 0;
//		for (int k = 0; k < bucket.length; k++) {
//			if (buckerElementCounts[k] != 0) {
//				for (int l = 0; l < buckerElementCounts[k]; l++) {
//					arr[index++] = bucket[k][l];
//				}
//			}
//			// 每一輪放回去以後要把之前記錄每個桶實際放了多少個數據的數組清零
//			buckerElementCounts[k] = 0;
//		}

	}
}
