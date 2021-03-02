package com.atguigu.recursion;



public class Queue8 {
	// ����һ��max��ʾ���ж��ٸ��ʺ�
	int max = 8;
	// ����һ������array, ����ʺ���õĽ��
	int[] array = new int[max];
	static int count = 0;
	public static void main(String[] args) {
		//test
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.printf("һ����%d�ⷨ", count);
		
	}
	//���õ�n���ʺ�
	private void check(int n) {
		if(n == max) { // n=8��8���ʺ��Ѿ��ź�, Ҳ�ǵݹ���ٽ����
			print();
			return;
		}
		for(int i = 0; i < max; i++) {
			//�Ȱѵ�ǰ����ʺ�n�����ڸ��еĵ�1��
			array[n] = i;
			if (judge(n)) {
				check(n+1);
			}
			//�����ͻ����ִ��array[n] = i; ������n���ʺ󣬷����ڱ��еĺ�һ��λ��
		}
	}
	
	//�鿴�����Ƿ��õ�n���ʺ󣬾�ȥ���ûʺ��Ƿ��ǰ���Ѿ��źõĻʺ��ͻ
	/**
	 * @param n ��ʾ��n���ʺ�
	 * @return
	 */
	private boolean judge(int n) {
		for(int i=0; i<n; i++) {
			if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}
	
	//print
	private void print() {
		count ++;
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
