package com.atguigu.tree;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int arr[] = {4, 6, 8, 5, 9, 11, -1, 100};
		
		heapSort(arr);
	}
	
	public static void heapSort(int arr[]) {
		System.out.println("������");
		int temp = 0;
		//���������й���һ����
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			//��һ����Ҷ�ӽڵ��� arr.length / 2 -1 ��
			adjustHeap(arr, i, arr.length);
		}
		//adjustHeap(arr, 0, arr.length);
		//ѭ�����Ѷ�Ԫ����ĩβԪ�ؽ����������ײ������鳤�ȼ�һ���������¹�����
		for (int j = arr.length - 1; j > 0; j--) {
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr, 0, j);
		}
		
		System.out.println("����="+ Arrays.toString(arr));
		
	}
	
	//��һ�����飬������һ���󶥶�
	/**
	 * func������iΪ�±�ķ�Ҷ�ӽڵ����ڵ���������Ϊ�󶥶�
	 * @param arr ������������
	 * @param i	  ��ʾ��Ҷ�ӽڵ������
	 * @param length ��ʾ�Զ��ٸ�Ԫ�ؼ�������
	 */
	public  static void adjustHeap(int arr[], int i, int length) {
		
		int temp = arr[i];
		
		for(int k = i * 2 + 1; k < length; k = k * 2 + 1) {
			if (k+1 < length && arr[k]<arr[k+1]) {
				k++;
			}
			if (arr[k] > temp) {
				arr[i] = arr[k];
				i = k;
			}else {
				break;
			}
		}
		arr[i] = temp;
	}

}
