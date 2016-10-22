package com.dzhou.interview.google;

/**
 * 75. Sort Colors
 * 
 * Difficulty: Medium
 * 
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * @author zhoudong
 *
 */
public class SortColors {

	public void sortColors(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		sortRed(nums);
		sortBlue(nums);
	}

	private void sortRed(int[] nums) {
		int fast = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				continue;
			}
			if (fast <= i) {
				fast = i + 1;
			}
			while (fast < nums.length && nums[fast] != 0) {
				fast++;
			}
			if (fast == nums.length) {
				return;
			}
			swap(nums, i, fast);
		}
	}

	private void sortBlue(int[] nums) {
		int fast = nums.length - 2;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 2) {
				continue;
			}
			if (fast >= i) {
				fast = i - 1;
			}
			while (fast >= 0 && nums[fast] != 2) {
				fast--;
			}
			if (fast < 0) {
				return;
			}
			swap(nums, i, fast);
		}
	}

	private void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}

}
