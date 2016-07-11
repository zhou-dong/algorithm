package org.dzhou.research.other.analyze;

public class Other {

	void reverse(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			swap(array, i, array.length - 1 - i);
		}
	}

	void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
}
