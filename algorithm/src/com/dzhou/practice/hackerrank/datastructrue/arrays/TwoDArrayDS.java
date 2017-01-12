package com.dzhou.practice.hackerrank.datastructrue.arrays;

import java.util.Scanner;

public class TwoDArrayDS {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[][] = new int[6][6];
		for (int arr_i = 0; arr_i < 6; arr_i++) {
			for (int arr_j = 0; arr_j < 6; arr_j++) {
				arr[arr_i][arr_j] = in.nextInt();
			}
		}
		in.close();
		int max = execute(arr);
		System.out.print(max);
	}

	private static int execute(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for (int row = 0; row < arr.length - 2; row++) {
			for (int col = 0; col < arr[row].length - 2; col++) {
				max = Math.max(sumSeven(arr, row, col), max);
			}
		}
		return max;
	}

	private static int sumSeven(int[][] arr, int row, int col) {
		int sum = sumThree(arr[row], col);
		sum += arr[row + 1][col + 1];
		sum += sumThree(arr[row + 2], col);
		return sum;
	}

	private static int sumThree(int[] arr, int startIndex) {
		int sum = 0, endIndex = startIndex + 3;
		for (int i = startIndex; i < endIndex; i++)
			sum += arr[i];
		return sum;
	}
}
