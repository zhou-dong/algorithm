package org.dzhou.practice.medium;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhoudong
 */
public class ShuffleAnArray {

	public class Solution {
		int[] original;
		Random random;

		public Solution(int[] nums) {
			original = nums;
			random = new Random();
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			return Arrays.copyOf(original, original.length);
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
			int[] shuffled = Arrays.copyOf(original, original.length);
			int length = shuffled.length;
			for (int i = 0; i < length; i++)
				swap(shuffled, i, i + random.nextInt(length - i));
			return shuffled;
		}

		private void swap(int[] array, int x, int y) {
			if (x != y) {
				int temp = array[x];
				array[x] = array[y];
				array[y] = temp;
			}
		}
	}

	// Your Solution object will be instantiated and called as such:
	// Solution obj = new Solution(nums);
	// int[] param_1 = obj.reset();
	// int[] param_2 = obj.shuffle();
}
