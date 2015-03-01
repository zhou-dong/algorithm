package org.dzhou.research.algorithm.sort;

/**
 * @author DONG ZHOU
 */
public class InsertionSort {

	public static void sort(int[] input) {
		for (int i = 1; i < input.length; i++)
			swap(input, i, locate(input, i));
	}

	private static int locate(int[] input, int i) {
		for (int result = i; result > 0; result--)
			if (input[result - 1] <= input[i])
				return result;
		return 0;
	}

	private static void swap(int[] input, int from, int to) {
		if (from == to)
			return;
		int temp = input[from];
		for (int i = from; i >= to; i--)
			if (i != to)
				input[i] = input[i - 1];
			else
				input[to] = temp;
	}

	public static void main(String args[]) {
		int[] input = { 6, 5, 3, 7, 8, 1, 2, 4 };
		sort(input);
		print(input);
	}

	private static void print(int[] input) {
		for (int i : input)
			System.out.println(i);
	}

}