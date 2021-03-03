package com.atguigu.sort;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int array[] = { 3, 9, -1, 10, -2 };
		//����ð��������ٶȣ�8w������
		int [] arr = new int[80000];
		for(int i = 0; i<80000; i++) {
			arr[i]  = (int)(Math.random() * 80000);
		}
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String date1str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ���ǣ�" + date1str);
		
		bubbleSort(arr);
		
		Date data2 = new java.util.Date();
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:mm:ss"); 
		String date2str = simpleDateFormat.format(data2);
		System.out.println("����ǰ��ʱ���ǣ�" + date2str);
	}

	public static void bubbleSort(int[] arr) {
		//ð������ʱ�临�Ӷ�ΪO��n^2��
		int temp = 0;
		boolean flag = false; // ��ʶ��������ʾ�Ƿ���й�������ð������ļ��Ż�
		for (int i = 1; i < arr.length; i++) {
			// ��n�ˣ����������������
			for (int j = 0; j < arr.length - i; j++) {
				//�������ڵ�����
				if (arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			//System.out.println("��" + i + "�����������");
			//System.out.println(Arrays.toString(arr));

			if (!flag) {// ��ʾ��һ��û�н���
				break;
			} else {
				flag = false;
			}
		}
	}

}
