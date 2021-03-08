package com.atguigu.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2, -2 };
		int temp[] = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, temp);
		System.out.println("排序后的数组:" + Arrays.toString(arr));
	}

	// divide and conquer
	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid, temp);
			mergeSort(arr, mid + 1, right, temp);
			merge(arr, left, right, mid, temp);
		}
	}

	// 合并的方法
	/**
	 * @param arr   原始的数组
	 * @param left  左边有序数组的第一个下标
	 * @param right 右边有序数组的第一个下标
	 * @param temp  临时数组
	 */
	public static void merge(int[] arr, int left, int right, int mid, int[] temp) {
		int i = left;
		int j = mid + 1;
		int t = 0; // 临时数组的索引
		// 第一步: 比较左右俩边数组中的元素，将其中较小的放在临时数组
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				i += 1;
				t += 1;
			} else {
				temp[t] = arr[j];
				j += 1;
				t += 1;
			}
		}
		// 第二步: 将左右有序数组的剩余元素放在临时数组
		while (i <= mid) {
			temp[t] = arr[i];
			i += 1;
			t += 1;
		}
		while (j <= right) {
			temp[t] = arr[j];
			j += 1;
			t += 1;
		}
		// 第三步: 将临时数组的值拷贝到原始数组
		t = 0;
		int tempLeft = left;
		while (tempLeft <= right) {
			arr[tempLeft] = temp[t];
			tempLeft += 1;
			t += 1;
		}
	}
}
