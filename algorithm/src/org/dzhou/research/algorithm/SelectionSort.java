package org.dzhou.research.algorithm;

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

	public static void sortFromBack(int[] input) {
		int index = 0;
		for (int i = input.length - 1; i > 0; i--) {
			index = i;
			for (int j = 0; j < i; j++)
				if (input[index] < input[j])
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
		switch (1) {
		case 0:
			sort(input);
			break;
		case 1:
			sortFromBack(input);
			break;
		default:
			System.out.println("No this option, r u kidding?");
			return;
		}
		print(input);
	}

	private static void print(int[] input) {
		for (int i : input)
			System.out.println(i);
	}

}