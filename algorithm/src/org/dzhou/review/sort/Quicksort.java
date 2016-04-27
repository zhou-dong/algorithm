package org.dzhou.review.sort;

/**
 * @author DONG ZHOU
 */
public class Quicksort<T extends Comparable<T>> {

	private static <T extends Comparable<T>> int split(T[] array, int lowIndex, int highIndex) {
		int left = lowIndex + 1;
		int right = highIndex;
		T pivot = array[lowIndex];
		while (true) {
			while (left <= right) {
				if (array[left].compareTo(pivot) < 0)
					left++;
				else
					break;
			}
			while (right > left) {
				if (array[right].compareTo(pivot) > 0)
					break;
				else
					right--;
			}
			if (left >= right)
				break;
			sway(array, left, right);
			left++;
			right--;
		}
		// swap pivot with left-1 position
		sway(array, lowIndex, left - 1);
		return left - 1;
	}

	private static <T extends Comparable<T>> void sort(T[] array, int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			int splitPoint = split(array, lowIndex, highIndex);
			sort(array, lowIndex, splitPoint - 1);
			sort(array, splitPoint + 1, highIndex);
		}
	}

	public static <T extends Comparable<T>> void sort(T[] array) {
		if (array.length < 2)
			return;
		sort(array, 0, array.length - 1);
	}

	private static <T extends Comparable<T>> void sway(T[] array, int x, int y) {
		if (x == y)
			return;
		T temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

}