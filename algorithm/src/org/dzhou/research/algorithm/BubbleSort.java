package org.dzhou.research.algorithm;

public class BubbleSort {

	public static void sort(int[] input) {
		for (int i = input.length - 1; i > 0; i--)
			for (int j = 0; j < i; j++)
				if (input[j] > input[j + 1])
					swapNext(input, j);
	}

	private static void swapNext(int input[], int i) {
		swap(input, i, i + 1);
	}

	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	public static void main(String[] args) {
		int[] input = { 8, 7, 15, 9, 5, 4, 6, 3, 5, 1, 6, 2, 0 };
		sort(input);
		for (int i : input)
			System.out.println(i);
	}

}
