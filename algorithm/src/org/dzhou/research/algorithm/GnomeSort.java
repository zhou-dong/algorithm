package org.dzhou.research.algorithm;

public class GnomeSort {

	public static void main(String[] args) {

	}

	static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	static void print(int[] input) {
		for (int i : input)
			System.out.println(i);
	}

}