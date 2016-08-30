package org.dzhou.research.algorithm.sort;

public class KadaneAlgorithm {

	public static class KadaneResult {
		public int max;
		public int left;
		public int right;

		KadaneResult(int max, int left, int right) {
			this.max = max;
			this.left = left;
			this.right = right;
		}

	}

	public static KadaneResult maxSubArray(int[] array) {
		int max = Integer.MIN_VALUE, left = 0, right = 0, current = 0, leftPrevious = 0;
		for (int i = 0; i < array.length; i++) {
			if (current < 0) {
				current = 0;
				leftPrevious = i;
			}
			current += array[i];
			if (current > max) {
				left = leftPrevious;
				right = i;
				max = current;
			}
		}
		return new KadaneResult(max, left, right);
	}

}
