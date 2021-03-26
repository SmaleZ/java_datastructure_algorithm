package com.atguigu.search;

public class InsertValueSearch {

	public static void main(String[] args) {
		int [] arr = new int[100];
		for(int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		
		int result = insertValueSearch(arr, 0, arr.length - 1, 99);
		System.out.println("result:" + result);
		
		
	}
	/**
	 * 要求数组有序
	 * @param arr
	 * @param left
	 * @param right
	 * @param findValue
	 * @return
	 */
	public static int insertValueSearch(int []arr, int left, int right, int findValue) {
		if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
			return -1;
		}
		int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
		if (findValue > arr[mid]) {
			return insertValueSearch(arr, mid + 1, right, findValue);
		}else if (findValue < arr[mid]) {
			return insertValueSearch(arr, left, mid - 1, findValue);
		}else {
			return mid;
		}
	}

}
