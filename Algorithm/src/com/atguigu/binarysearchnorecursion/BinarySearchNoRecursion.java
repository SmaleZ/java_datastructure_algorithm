package com.atguigu.binarysearchnorecursion;

public class BinarySearchNoRecursion {

	public static void main(String[] args) {
		int []arr = {1, 3, 8, 10, 67, 100};
		int indedex = binarySearch(arr, 1);
		System.out.println("index=" + indedex);
	}
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length -1 ;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == target) {
				return mid;
			}else if (arr[mid] > target) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return -1;
	}

}
