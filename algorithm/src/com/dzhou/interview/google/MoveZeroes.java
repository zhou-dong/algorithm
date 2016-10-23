package com.dzhou.interview.google;

/**
 * 283. Move Zeroes
 * 
 * Difficulty: Easy
 * 
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 * 
 * Note:
 * 
 * You must do this in-place without making a copy of the array.
 * 
 * Minimize the total number of operations.
 * 
 * @author zhoudong
 *
 */
public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		int fast = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				continue;
			}
			if (fast <= i) {
				fast = i + 1;
			}
			while (fast < nums.length && nums[fast] == 0) {
				fast++;
			}
			if (fast == nums.length)
				return;
			swap(nums, i, fast);
		}
	}

	private void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}

}
