package com.dzhou.interview.third;

import java.util.Arrays;

/**
 * 473. Matchsticks to Square
 * 
 * Remember the story of Little Match Girl? By now, you know exactly what
 * matchsticks the little match girl has, please find out a way you can make one
 * square by using up all those matchsticks. You should not break any stick, but
 * you can link them up, and each matchstick must be used exactly one time.
 * 
 * Your input will be several matchsticks the girl has, represented with their
 * stick length. Your output will either be true or false, to represent whether
 * you could make one square using all the matchsticks the little match girl
 * has.
 * 
 * Example 1: Input: [1,1,2,2,2] Output: true
 * 
 * Explanation: You can form a square with length 2, one side of the square came
 * two sticks with length 1.
 * 
 * Example 2: Input: [3,3,3,3,4] Output: false
 * 
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * 
 * Note:
 * 
 * The length sum of the given matchsticks is in the range of 0 to 10^9.
 * 
 * The length of the given matchstick array will not exceed 15.
 * 
 * @author zhoudong
 *
 */
public class MatchsticksToSquare {

	public boolean makesquare(int[] nums) {
		if (nums == null || nums.length < 4)
			return false;
		int sum = sum(nums);
		if (sum % 4 != 0)
			return false;
		Arrays.sort(nums);
		reverse(nums);
		return dfs(nums, new int[4], 0, sum / 4);
	}

	private boolean dfs(int[] nums, int[] sides, int index, int target) {
		if (index == nums.length) {
			return equal(sides, target);
		}

		for (int i = 0; i < 4; i++) {
			if (sides[i] + nums[index] > target)
				continue;
			sides[i] += nums[index];
			if (dfs(nums, sides, index + 1, target))
				return true;
			sides[i] -= nums[index];
		}

		return false;
	}

	private boolean equal(int[] sides, int target) {
		for (int side : sides) {
			if (side != target) {
				return false;
			}
		}
		return true;
	}

	private int sum(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		return sum;
	}

	private void reverse(int[] nums) {
		for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
			swap(nums, i, j);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
