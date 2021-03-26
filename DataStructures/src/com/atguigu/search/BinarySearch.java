package com.atguigu.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = {1, 8, 10, 89, 1000, 1234};
		int arr1[] = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1234};
 		int index = binarySearch(arr, 0, arr.length -1 , 5);
		List<Integer> resIndex = binarySearch1(arr1, 0, arr1.length -1, 1000);
		System.out.println("result is:" + index);
		System.out.println("result list is:" + resIndex);
	}
	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		if (left > right) {
			return -1;
		}
		
		int mid = (left + right) / 2;
		if (arr[mid] < findVal) {
			return  binarySearch(arr, mid + 1, right, findVal);
		}else if (arr[mid] > findVal) {
			return binarySearch(arr, left, mid - 1, findVal);
		}else {
			return mid;
		}
	}
	
	public static ArrayList<Integer> binarySearch1(int[] arr, int left, int right, int findVal) {
		if (left > right) {
			return new ArrayList<Integer>();
		}
		
		int mid = (left + right) / 2;
		if (arr[mid] < findVal) {
			return  binarySearch1(arr, mid + 1, right, findVal);
		}else if (arr[mid] > findVal) {
			return binarySearch1(arr, left, mid - 1, findVal);
		}else {
			/**
			 * 将所有要找到值的下标都返回
			 * 在已找到的下标 向左向右扫描
			 */
			ArrayList<Integer> resIndexList = new ArrayList<Integer>();
			int temp = mid - 1;
			while (true) {
				if (temp < 0 || arr[temp] != findVal) {
					break;
				}
				resIndexList.add(temp);
				temp -= 1;
			}
			
			resIndexList.add(mid);
			
			temp = mid + 1;
			while (true) {
				if (temp > arr.length - 1 || arr[temp] != findVal) {
					break;
				}
				resIndexList.add(temp);
				temp += 1;
			}
			
			return resIndexList;
		}
	}
}
