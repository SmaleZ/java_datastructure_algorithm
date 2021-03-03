package com.atguigu.sort;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int array[] = { 3, 9, -1, 10, -2 };
		//测试冒泡排序的速度，8w个数据
		int [] arr = new int[80000];
		for(int i = 0; i<80000; i++) {
			arr[i]  = (int)(Math.random() * 80000);
		}
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String date1str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是：" + date1str);
		
		bubbleSort(arr);
		
		Date data2 = new java.util.Date();
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:mm:ss"); 
		String date2str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是：" + date2str);
	}

	public static void bubbleSort(int[] arr) {
		//冒泡排序，时间复杂度为O（n^2）
		int temp = 0;
		boolean flag = false; // 标识变量，表示是否进行过交换，冒泡排序的简单优化
		for (int i = 1; i < arr.length; i++) {
			// 第n趟，将最大的数排在最后
			for (int j = 0; j < arr.length - i; j++) {
				//交换相邻的俩项
				if (arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			//System.out.println("第" + i + "躺排序的数组");
			//System.out.println(Arrays.toString(arr));

			if (!flag) {// 表示这一趟没有交换
				break;
			} else {
				flag = false;
			}
		}
	}

}
