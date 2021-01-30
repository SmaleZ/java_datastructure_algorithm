package com.atguigu.sparsearray;

import java.io.*;
import java.util.*;

public class SparseArray {

	public static void main(String[] args) throws IOException {
		// ����һ��ԭʼ�Ķ�ά���� 11* 11
		// 0:��ʾû�����ӣ�2��ʾ���ӣ�2��ʾ����
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		// output the origin array
		for (int[] row : chessArr1) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}

		int sparseArr[][] = new int[sum + 1][3];
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;

		int count = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr1[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr1[i][j];
				}
			}
		}
		System.out.println();
		System.out.println("�õ���ϡ������Ϊ��");
		for (int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
		}
		System.out.println();
		// write the sparse array into .txt file in csv format
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < 3; j++) {
				builder.append(sparseArr[i][j] + "");
				if (j < sparseArr.length - 1) {
					builder.append(",");
				}
			}
			builder.append("\n");
		}
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("./" + "sparse.txt", false));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.write(builder.toString());
		writer.close();

		// read from sparse.txt;
		int[][] sparseRead = new int[sparseArr.length][3];
		BufferedReader reader = new BufferedReader(new FileReader("sparse.txt"));
		String line = "";
		int row = 0;
		while ((line = reader.readLine()) != null) {
			String[] cols = line.split(",");
			int col = 0;
			for (String c : cols) {
				sparseRead[row][col] = Integer.parseInt(c);
				col++;
			}
			row++;
		}
		reader.close();
		// print the sparse array from file
		System.out.println("���ļ��еõ���ϡ������Ϊ��");
		for (int[] r : sparseRead) {
			for (int data : r) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		// ��ϡ�蔵�M�֏ͳ�ԭʼ
		int chessArr2[][] = new int[sparseRead[0][0]][sparseRead[0][1]];
		for (int i = 1; i < sparseRead.length; i++) {
			chessArr2[sparseRead[i][0]][sparseRead[i][1]] = sparseRead[i][2];
		}

		System.out.println("�õ���߀ԭ��ϡ������Ϊ��");
		for (int[] row1 : chessArr1) {
			for (int data : row1) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

	}

}
