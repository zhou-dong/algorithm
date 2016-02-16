package org.dzhou.interview.sort;

public class QuickSort {

	public static void sort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}

	static void quicksort(int[] array, int left, int right) {
		int index = partition(array, left, right);
		if (left < index - 1) {
			quicksort(array, left, index - 1);
		}
		if (index < right) {
			quicksort(array, index, right);
		}
	}

	static int partition(int[] array, int left, int right) {
		int pivot = array[(left + right) / 2];
		while (left <= right) {
			// 找出左边应被放到右边的元素
			while (array[left] < pivot)
				left++;
			// 找出右边应被放到左边的元素
			while (array[right] > pivot)
				right--;
			// 交换元素，同时调整左右索引值
			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	static void swap(int array[], int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
