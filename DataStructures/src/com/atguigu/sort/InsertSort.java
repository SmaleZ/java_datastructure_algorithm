package com.atguigu.sort;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		int arr[] = { 3, 9, -1, 10, -2 };
		insertSort(arr);
	}
	//��������
	public static void insertSort(int[] arr) {
		for(int i=1; i <= arr.length-1;i++) {
			//����Ҫִ��length-1��
			int insertValue = arr[i];
			int insertIndex = i-1;
			while (insertIndex>=0 && insertValue < arr[insertIndex]) {
				arr[insertIndex+1] = arr[insertIndex];
				insertIndex--;
			}
			if (insertIndex+1!=i) {//С�Ż��������������Ԫ���Ѿ�����ǰ�����������һ��Ԫ�أ�����Ҫִ�в���
				arr[insertIndex+1] = insertValue;
			}
			
			System.out.println("��" + i + "�����������");
			System.out.println(Arrays.toString(arr));
		}
	}
}
