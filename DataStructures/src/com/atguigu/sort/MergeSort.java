package com.atguigu.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2, -2 };
		int temp[] = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, temp);
		System.out.println("����������:" + Arrays.toString(arr));
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

	// �ϲ��ķ���
	/**
	 * @param arr   ԭʼ������
	 * @param left  �����������ĵ�һ���±�
	 * @param right �ұ���������ĵ�һ���±�
	 * @param temp  ��ʱ����
	 */
	public static void merge(int[] arr, int left, int right, int mid, int[] temp) {
		int i = left;
		int j = mid + 1;
		int t = 0; // ��ʱ���������
		// ��һ��: �Ƚ��������������е�Ԫ�أ������н�С�ķ�����ʱ����
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
		// �ڶ���: ���������������ʣ��Ԫ�ط�����ʱ����
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
		// ������: ����ʱ�����ֵ������ԭʼ����
		t = 0;
		int tempLeft = left;
		while (tempLeft <= right) {
			arr[tempLeft] = temp[t];
			tempLeft += 1;
			t += 1;
		}
	}
}
