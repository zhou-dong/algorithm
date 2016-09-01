package org.dzhou.research.algorithm.practice;

/**
 * @author DONG ZHOU
 */
public class FindMax {

	public static class Solution {

		public int max(int[] array) {
			int max = array[0];
			for (int i = 1; i < array.length; i++) {
				if (array[i] > max)
					max = array[i];
			}
			return max;
		}

	}

	public static class Solution1 {

		public int max(int[] array) {
			int max = array[0];
			for (int i = 1; i < array.length; i++) {
				max = max(max, array[i]);
			}
			return max;
		}

		private int max(int x, int y) {
			return x > y ? x : y;
		}

	}

	public static class Solution2 {

		public int max(int[] array) {
			int max = array[0];
			for (int i = 1; i < array.length; i++)
				max = Math.max(max, array[i]);
			return max;
		}

	}

}