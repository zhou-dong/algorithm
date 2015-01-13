package org.dzhou.research.algorithm;

public class BucketSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		swap(0, 0);
	}

	private static void swap(int i, int j) {
		if (i == j)
			return;
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static int[] array;
}
