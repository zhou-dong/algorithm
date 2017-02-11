package com.dzhou.interview.third;

/**
 * 503. Next Greater Element II
 * 
 * Given a circular array (the next element of the last element is the first
 * element of the array), print the Next Greater Number for every element. The
 * Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, output -1 for this
 * number.
 * 
 * Example 1: Input: [1,2,1] Output: [2,-1,2]
 * 
 * Explanation: The first 1's next greater number is 2;
 * 
 * The number 2 can't find next greater number;
 * 
 * The second 1's next greater number needs to search circularly, which is also
 * 2.
 * 
 * Note: The length of given array won't exceed 10000.
 * 
 * @author zhoudong
 *
 */
public class NextGreaterElementII {

	public int[] nextGreaterElements(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		int max = max(nums);
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num == max) {
				result[i] = -1;
				continue;
			}
			for (int j = i + 1; j < nums.length + i; j++) {
				int index = j >= nums.length ? j % nums.length : j;
				if (nums[index] > num) {
					result[i] = nums[index];
					break;
				}
			}
		}
		return result;
	}

	private int max(int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}
		return max;
	}

}
