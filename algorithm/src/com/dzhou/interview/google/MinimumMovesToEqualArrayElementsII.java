package com.dzhou.interview.google;

import java.util.Arrays;

/**
 * 462. Minimum Moves to Equal Array Elements II
 * 
 * Total Accepted: 1042
 * 
 * Total Submissions: 2406
 * 
 * Difficulty: Medium
 * 
 * Given a non-empty integer array, find the minimum number of moves required to
 * make all array elements equal, where a move is incrementing a selected
 * element by 1 or decrementing a selected element by 1.
 * 
 * You may assume the array's length is at most 10,000.
 * 
 * Example:
 * 
 * Input: [1,2,3]
 * 
 * Output: 2
 * 
 * Explanation: Only two moves are needed (remember each move increments or
 * decrements one element):
 * 
 * [1,2,3] => [2,2,3] => [2,2,2]
 * 
 * @author zhoudong
 *
 */
public class MinimumMovesToEqualArrayElementsII {

	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int midIndex = nums.length / 2;
		if (nums.length % 2 == 1) {
			return moves(nums, nums[midIndex]);
		}
		return Math.min(moves(nums, nums[midIndex]), moves(nums, nums[midIndex - 1]));
	}

	private int moves(int[] nums, int y) {
		int sum = 0;
		for (int num : nums)
			sum += Math.abs(num - y);
		return sum;
	}

}
