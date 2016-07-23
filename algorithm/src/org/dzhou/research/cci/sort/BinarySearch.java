package org.dzhou.research.cci.sort;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class BinarySearch {

	int binarySearch(int[] a, int x) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				return mid;
			} else if (a[mid] < x) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1; // error
	}

	int binarySearch(int[] a, int x, int low, int high) {
		if (low > high)
			return -1; // error
		int mid = (low + high) / 2;
		if (a[mid] == x) {
			return mid;
		} else if (a[mid] < x) {
			return binarySearch(a, x, mid + 1, high);
		} else {
			return binarySearch(a, x, low, mid - 1);
		}
	}

}
