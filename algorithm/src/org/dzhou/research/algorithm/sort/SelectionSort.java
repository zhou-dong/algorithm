package org.dzhou.research.algorithm.sort;

public class SelectionSort {

	public static void sort(int[] input) {
		int index = 0;
		for (int i = 0; i < input.length - 1; i++) {
			index = i;
			for (int j = i + 1; j < input.length; j++)
				if (input[index] > input[j])
					index = j;
			if (index != i)
				swap(input, i, index);
		}
	}

	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	public static void main(String[] args) {
		int[] input = { 8, 7, 15, 9, 5, 4, 6, 3, 5, 1, 6, 2, 0 };
		sort(input);
		print(input);
	}

	private static void print(int[] input) {
		for (int i : input)
			System.out.println(i);
	}

}