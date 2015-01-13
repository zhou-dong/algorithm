package org.dzhou.research.algorithm;

public class QuickSort {

	private static void sort(int[] input) {
		int pivot = input[0];
		int i = 1;
		int j = input.length - 1;
		while (i != j) {
			if (input[j] > pivot)
				j--;
			if (input[i] < pivot)
				i++;
		}
		swap(input, i, j);
	}

	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	public static void main(String args[]) {
		int[] input = { 3, 7, 8, 5, 2, 1, 9, 5, 4 };
		sort(input);
		print(input);
	}

	private static void print(int[] input) {
		for (int i : input)
			System.out.println(i);
	}

}