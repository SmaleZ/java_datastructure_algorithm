package com.atguigu.sort;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		int arr[] = { 3, 9, -1, 10, -2 };
		selectSort(arr);
		
	}
	public static void selectSort(int[] arr) {
		//ѡ������ʱ�临�Ӷ�ΪO��n^2��
		//boolean flag = false; // ��ʶ��������ʾ�Ƿ���й�������ð������ļ��Ż�
		for (int i = 0; i < arr.length-1; i++) {
			// ����length-1��
			int min = arr[i];
			int minIdex = i;
			for (int j = i+1; j < arr.length; j++) {
				//�ҵ���ǰ��Сֵ,����̨
				if (arr[j] < min) {
					min = arr[j];
					minIdex = j;
				}
			}
			if (minIdex!=i) {
				arr[minIdex] = arr[i];
				arr[i] =  min;
			}
			
			System.out.println("��" + (i+1) + "�����������");
			System.out.println(Arrays.toString(arr));

//			if (!flag) {// ��ʾ��һ��û�н���
//				break;
//			} else {
//				flag = false;
//			}
		}
	}

}
