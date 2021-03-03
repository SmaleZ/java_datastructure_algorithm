package com.atguigu.sort;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		int arr[] = { 3, 9, -1, 10, -2 };
		insertSort(arr);
	}
	//插入排序
	public static void insertSort(int[] arr) {
		for(int i=1; i <= arr.length-1;i++) {
			//共需要执行length-1轮
			int insertValue = arr[i];
			int insertIndex = i-1;
			while (insertIndex>=0 && insertValue < arr[insertIndex]) {
				arr[insertIndex+1] = arr[insertIndex];
				insertIndex--;
			}
			if (insertIndex+1!=i) {//小优化，即如果待插入元素已经大于前面有序表的最后一个元素，不需要执行插入
				arr[insertIndex+1] = insertValue;
			}
			
			System.out.println("第" + i + "躺排序的数组");
			System.out.println(Arrays.toString(arr));
		}
	}
}
