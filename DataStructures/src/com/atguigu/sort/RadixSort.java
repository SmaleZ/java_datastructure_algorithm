package com.atguigu.sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int arr[] = { 53, 3, 542, 748, 14, 214 };
		radixSort(arr);
	}

	public static void radixSort(int[] arr) {
		// ��1��

		// ����һ����ά���飬ÿ��Ͱ��ʾһ��һά����
		// Ϊ�˷�ֹ��������ʱ�������������ÿ��һά����Ͱ�Ĵ�С��Ϊarr.length
		// ������Կ���Ͱ������ʹ�ÿռ任ʱ��ľ����㷨
		int[][] bucket = new int[10][arr.length];

		// Ϊ�˼�¼ÿ��Ͱ��ʵ�ʷ��˶��ٸ�����, ���Ƕ���һ�������һά��������¼����Ͱ��ÿ�η�������ݸ���
		int[] buckerElementCounts = new int[10];

		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int maxLength = (max + "").length();

		for (int i = 0, n=1; i < maxLength; i++, n*=10) {
			// ��1��
			for (int j = 0; j < arr.length; j++) {
				int digitOfElement = arr[j] / n % 10;
				bucket[digitOfElement][buckerElementCounts[digitOfElement]] = arr[j];

				buckerElementCounts[digitOfElement]++;

			}
			// Ͱ�����ݷŻ�ԭ����
			int index = 0;
			for (int k = 0; k < bucket.length; k++) {
				if (buckerElementCounts[k] != 0) {
					for (int l = 0; l < buckerElementCounts[k]; l++) {
						arr[index++] = bucket[k][l];
					}
				}
				// ÿһ݆�Ż�ȥ����Ҫ��֮ǰӛ�ÿ��Ͱ���H���˶��ق������Ĕ��M����
				buckerElementCounts[k] = 0;
			}
			System.out.println("��"+ (i+1)+"�ֵ�������Ϊ��" + Arrays.toString(arr));
		}

//		// ��1��
//		for (int i = 0; i < arr.length; i++) {
//			int digitOfElement = arr[i] / 1 % 10;
//			bucket[digitOfElement][buckerElementCounts[digitOfElement]] = arr[i];
//
//			buckerElementCounts[digitOfElement]++;
//
//		}
//		// Ͱ�����ݷŻ�ԭ����
//		int index = 0;
//		for (int k = 0; k < bucket.length; k++) {
//			if (buckerElementCounts[k] != 0) {
//				for (int l = 0; l < buckerElementCounts[k]; l++) {
//					arr[index++] = bucket[k][l];
//				}
//			}
//			// ÿһ݆�Ż�ȥ����Ҫ��֮ǰӛ�ÿ��Ͱ���H���˶��ق������Ĕ��M����
//			buckerElementCounts[k] = 0;
//		}
//
//		// ��2��
//		for (int i = 0; i < arr.length; i++) {
//			int digitOfElement = arr[i] / 10 % 10;
//			bucket[digitOfElement][buckerElementCounts[digitOfElement]] = arr[i];
//
//			buckerElementCounts[digitOfElement]++;
//
//		}
//		// Ͱ�����ݷŻ�ԭ����
//		index = 0;
//		for (int k = 0; k < bucket.length; k++) {
//			if (buckerElementCounts[k] != 0) {
//				for (int l = 0; l < buckerElementCounts[k]; l++) {
//					arr[index++] = bucket[k][l];
//				}
//			}
//			// ÿһ݆�Ż�ȥ����Ҫ��֮ǰӛ�ÿ��Ͱ���H���˶��ق������Ĕ��M����
//			buckerElementCounts[k] = 0;
//		}
//
//		// ��3��
//		for (int i = 0; i < arr.length; i++) {
//			int digitOfElement = arr[i] / 100 % 10;
//			bucket[digitOfElement][buckerElementCounts[digitOfElement]] = arr[i];
//
//			buckerElementCounts[digitOfElement]++;
//
//		}
//		// Ͱ�����ݷŻ�ԭ����
//		index = 0;
//		for (int k = 0; k < bucket.length; k++) {
//			if (buckerElementCounts[k] != 0) {
//				for (int l = 0; l < buckerElementCounts[k]; l++) {
//					arr[index++] = bucket[k][l];
//				}
//			}
//			// ÿһ݆�Ż�ȥ����Ҫ��֮ǰӛ�ÿ��Ͱ���H���˶��ق������Ĕ��M����
//			buckerElementCounts[k] = 0;
//		}

	}
}
