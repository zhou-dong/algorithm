package org.dzhou.research.cci.sort;

public class MergeSort {

	void mergesort(int[] array) {
		mergesort(array, new int[array.length], 0, array.length - 1);
	}

	void mergesort(int[] array, int[] helper, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(array, helper, low, middle);
			mergesort(array, helper, middle + 1, high);
			merge(array, helper, low, middle, high);
		}
	}

	void merge(int[] array, int[] helper, int low, int middle, int high) {
		// copy all elements from array to helper
		for (int i = low; i <= high; i++) {
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
		// copy the rest of the left side of the array into the target array.
		int remaining = middle - helperLeft;
		for (int i = 0; i < remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
		// copy the rest of the right side of the array into the target array.
		remaining = helperRight - middle;
		for (int i = 0; i < remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}

}
