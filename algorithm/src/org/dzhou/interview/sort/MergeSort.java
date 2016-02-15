package org.dzhou.interview.sort;

public class MergeSort {

	public void mergesort(int array[], int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(array, low, middle);
			mergesort(array, middle + 1, high);
			merge(array, low, middle, high);
		}
	}

	void merge(int[] array, int low, int middle, int high) {
		int[] helper = new int[array.length];
		for (int i = low; i < high; i++) {
			helper[i] = array[i];
		}
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else {
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		int remaining = middle - helperLeft;
		for (int i = 0; i < remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}

}
