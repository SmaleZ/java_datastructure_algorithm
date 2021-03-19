package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
	//ð������ı���
	public static void main(String[] args) {
		int[] arr1 = {-9, -9, -9, -9, -9, -9};
		int[] arr = new int[800000];
		for (int i = 0; i < 800000; i++) {
			arr[i] = (int) (Math.random() * 800000);
		}
//		Date data1 = new Date();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String date1str = simpleDateFormat.format(data1);
//		System.out.println("����ǰ��ʱ���ǣ�" + date1str);
		
		quickSort(arr1, 0, arr1.length-1);
		
//		Date data2 = new java.util.Date();
//		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:mm:ss");
//		String date2str = simpleDateFormat.format(data2);
//		System.out.println("����ǰ��ʱ���ǣ�" + date2str);
//		
		System.out.println("arr=" + Arrays.toString(arr1));
	}
	public static void quickSort(int[] arr, int left, int right) {
		int l = left;
		int r = right;
		int pivot = arr[(left + right) / 2];
		int temp = 0;
		while (l < r) {
			while (arr[l] < pivot) {
				l+=1;
			}
			while (arr[r] > pivot) {
				r-=1;
			}
			if (l >= r) {
				//�������־��ߵ�Ԫ��ȫ��С�ڱ�־���ұߵ�Ԫ��ȫ�����ڱ�־
				break;
			}
			if (l < r) {
				temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
			}
			if (arr[l] == pivot) {
				l++;
			}
			if (arr[r] == pivot) {
				r--;
			}
		}
		if (l == r) {
			l++;
			r--;
		}
		if (left < r) {
			quickSort(arr, left, r);
		}
		if (l < right) {
			quickSort(arr, l, right);
		}	
	}

}
