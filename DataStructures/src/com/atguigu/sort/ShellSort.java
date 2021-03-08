package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
	//��������ı���
	public static void main(String[] args) {
		int[] arr1 = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };

		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 800000);
		}
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ���ǣ�" + date1str);

		shellSort2(arr);

		Date data2 = new java.util.Date();
		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:mm:ss");
		String date2str = simpleDateFormat.format(data2);
		System.out.println("����ǰ��ʱ���ǣ�" + date2str);
		
		//shellSort2(arr1);
	}

	public static void shellSort(int[] arr) {

		int temp = 0;
		int count = 0;
		// ϣ������ĵ�һ������
		// �������ȱ��ֳ���5��
//		for (int i = 5; i < arr.length; i++) {
//			// ���������е�����Ԫ�أ�����Ϊ��
//			for (int j = i - 5; j >= 0; j -= 5) {
//				if (arr[j] > arr[j + 5]) {
//					temp = arr[j];
//					arr[j] = arr[j + 5];
//					arr[j + 5] = temp;
//				}
//			}
//		}

		// ϣ������ĵڶ�������
		// ���ݱ��ֳ���2��
//				for (int i = 2; i < arr.length; i++) {
//					// ���������е�����Ԫ�أ�����Ϊ2
//					for (int j = i - 2; j >= 0; j -= 2) {
//						if (arr[j] > arr[j + 2]) {
//							temp = arr[j];
//							arr[j] = arr[j + 2];
//							arr[j + 2] = temp;
//						}
//					}
//				}

		// ϣ������ĵ�3������
		// �������ȱ��ֳ���1��
//				for (int i = 1; i < arr.length; i++) {
//					// ���������е�����Ԫ�أ�����Ϊ1
//					for (int j = i - 1; j >= 0; j -= 1) {
//						if (arr[j] > arr[j + 1]) {
//							temp = arr[j];
//							arr[j] = arr[j + 1];
//							arr[j + 1] = temp;
//						}
//					}
//				}

		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				// ���������е�����Ԫ�أ�����Ϊgap
				for (int j = i - gap; j >= 0; j -= gap) {
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
			// System.out.println("ϣ�������" + (++count) + "��=" + Arrays.toString(arr));
		}

	}

	// �Խ���ʽ��ϣ����������Ż�
	public static void shellSort2(int [] arr) {
		int count = 0;
		//����gap, ������С����
		for(int gap = arr.length / 2; gap > 0; gap /= 2) {
			//�ӵ� gap��Ԫ�أ�����������ڵ������ֱ�Ӳ�������
			for(int i = gap; i < arr.length; i++) {
				int insertIndex = i;
				int insertValue = arr[i];
				while(insertIndex-gap >=0 && insertValue < arr[insertIndex - gap]) {
					arr[insertIndex] = arr[insertIndex - gap];
					insertIndex -= gap;
				}
				arr[insertIndex] = insertValue;
			}
			//System.out.println("ϣ�������" + (++count) + "��=" + Arrays.toString(arr));
		}
	}

}
