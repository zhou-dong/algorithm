package org.dzhou.interview.sort;

public class Merge {

	public void merge(int[] a, int[] b, int lastA, int lastB) {
		int indexA = lastA - 1;
		int indexB = lastB - 1;
		int indexMerged = lastA + lastB - 1;

		while (indexB >= 0) {
			if (indexA >= 0 && a[indexA] > b[indexB]) {
				a[indexMerged] = a[indexA];
				indexA--;
			} else {
				a[indexMerged] = a[indexB];
				indexB--;
			}
			indexMerged--;
		}
	}

}
