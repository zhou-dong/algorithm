package org.dzhou.practice.medium;

import java.util.Random;

/**
 * 398. Random Pick Index
 * 
 * Difficulty: Medium
 * 
 * Given an array of integers with possible duplicates, randomly output the
 * index of a given target number. You can assume that the given target number
 * must exist in the array.
 * 
 * Note: The array size can be very large. Solution that uses too much extra
 * space will not pass the judge.
 * 
 * Example:
 * 
 * int[] nums = new int[] {1,2,3,3,3};
 * 
 * Solution solution = new Solution(nums);
 * 
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should
 * have equal probability of returning.<br>
 * solution.pick(3);
 * 
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 * 
 * @author zhoudong
 *
 */
public class RandomPickIndex {

	public class Solution {

		private int[] nums;
		private Random random;

		public Solution(int[] nums) {
			this.nums = nums;
			this.random = new Random();
		}

		public int pick(int target) {
			int result = -1;
			int upbound = 1;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == target) {
					if (random.nextInt(upbound) == 0) {
						result = i;
					}
					upbound++;
				}
			}
			return result;
		}

	}

	// Your Solution object will be instantiated and called as such:
	// Solution obj = new Solution(nums);
	// int param_1 = obj.pick(target);
}
