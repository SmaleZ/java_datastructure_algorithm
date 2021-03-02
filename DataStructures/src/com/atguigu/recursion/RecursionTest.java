package com.atguigu.recursion;

public class RecursionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void test(int n) {
		if (n > 2) {
			test(n - 1);
		}
		System.out.println("n=" + n);
	}

}
