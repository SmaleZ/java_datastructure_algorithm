package com.atguigu.dac;

public class Hanotower {

	public static void main(String[] args) {
		hanoTower(5, 'A', 'B', 'C');

	}
	
	//��ŵ�����ƶ�����
	/**
	 * 
	 * @param num ���ӵĸ���
	 * @param a   ��ʼ����
	 * @param b   �м�����
	 * @param c	  Ŀ������
	 */
	public static void hanoTower(int num, char a, char b, char c) {
		if (num == 1) {
			System.out.println("��1���̴�" + a + "->" + c);
		}else {
			//���n>=2, �������ܿ��Կ��������̣�1.�������һ���̣�2.�����������
			//1. �Ȱ�������������̴�a -�� b, �ƶ�������Ҫ�õ�c
			hanoTower(num-1, a, c, b);
			//2. ����������ƶ�����a �ƶ��� c
			System.out.println("��" + num + "���̴�" + a + "->" + c);
			//3. ��1.��b�ϵ������̴�b �ƶ��� c
			hanoTower(num-1, b, a, c);
		}
	}
	

}
