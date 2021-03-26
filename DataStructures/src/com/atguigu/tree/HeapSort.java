package com.atguigu.tree;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int arr[] = {4, 6, 8, 5, 9, 11, -1, 100};
		
		heapSort(arr);
	}
	
	public static void heapSort(int arr[]) {
		System.out.println("堆排序");
		int temp = 0;
		//将无序序列构成一个堆
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			//第一个非叶子节点在 arr.length / 2 -1 处
			adjustHeap(arr, i, arr.length);
		}
		//adjustHeap(arr, 0, arr.length);
		//循环将堆顶元素与末尾元素交换（沉到底部，数组长度减一），并重新构建堆
		for (int j = arr.length - 1; j > 0; j--) {
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr, 0, j);
		}
		
		System.out.println("数组="+ Arrays.toString(arr));
		
	}
	
	//将一个数组，调整成一个大顶堆
	/**
	 * func：将以i为下标的非叶子节点所在的子树调整为大顶堆
	 * @param arr 待调整的数组
	 * @param i	  表示非叶子节点的索引
	 * @param length 表示对多少个元素继续调整
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
