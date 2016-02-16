package org.dzhou.interview.sort;

public class SearcBinary {

	public static int binarysearch(int[] array, int x) {
		int low = 0;
		int high = array.length - 1;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (array[mid] < x) {
				low = mid + 1;
			} else if (array[mid] > x) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static int binarysearchRecurisve(int[] array, int x) {
		return binarysearchRecurisve(array, x, 0, array.length - 1);
	}

	static int binarysearchRecurisve(int[] array, int x, int low, int high) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (array[mid] < x) {
			return binarysearchRecurisve(array, x, mid + 1, high);
		} else if (array[mid] > x) {
			return binarysearchRecurisve(array, x, low, mid - 1);
		} else {
			return mid;
		}
	}

}
