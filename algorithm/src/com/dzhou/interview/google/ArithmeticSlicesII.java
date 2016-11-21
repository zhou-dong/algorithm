package com.dzhou.interview.google;

/**
 * 446. Arithmetic Slices II - Subsequence
 * 
 * Difficulty: Hard
 * 
 * A sequence of numbers is called arithmetic if it consists of at least three
 * elements and if the difference between any two consecutive elements is the
 * same.
 * 
 * For example, these are arithmetic sequences:
 * 
 * 1, 3, 5, 7, 9
 * 
 * 7, 7, 7, 7
 * 
 * 3, -1, -5, -9
 * 
 * The following sequence is not arithmetic.
 * 
 * 1, 1, 2, 5, 7
 *
 * A zero-indexed array A consisting of N numbers is given. A subsequence slice
 * of that array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0
 * < P1 < ... < Pk < N.
 * 
 * A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the
 * sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic. In particular, this
 * means that k ≥ 2.
 * 
 * The function should return the number of arithmetic subsequence slices in the
 * array A.
 * 
 * The input contains N integers. Every integer is in the range of -231 and
 * 231-1 and 0 ≤ N ≤ 1000. The output is guaranteed to be less than 231-1.
 * 
 * Example:
 * 
 * Input: [2, 4, 6, 8, 10]
 * 
 * Output: 7
 * 
 * Explanation: All arithmetic subsequence slices are:
 * 
 * [2,4,6] [4,6,8] [6,8,10] [2,4,6,8] [4,6,8,10] [2,4,6,8,10] [2,6,10]
 * 
 * @author zhoudong
 *
 */
public class ArithmeticSlicesII {

	public int numberOfArithmeticSlices(int[] nums) {
		int sum = 0, count = 2;
		for (int i = 0; i < nums.length - 2; i++) {
			if (isArithmeticUnit(nums, i)) {
				count++;
			} else {
				sum += totalCount(count);
				count = 2;
			}
		}
		sum += totalCount(count);
		return sum;
	}

	private boolean isArithmeticUnit(int[] nums, int start) {
		if (start + 3 > nums.length)
			return false;
		return nums[start + 1] - nums[start] == nums[start + 2] - nums[start + 1];
	}

	private int totalCount(int num) {
		int total = 0;
		while (num > 2) {
			total += count(num);
			num -= 2;
		}
		return total;
	}

	private int count(int num) {
		if (num < 3)
			return 0;
		int[] dp = new int[num + 1];
		for (int i = 0; i < 3; i++) {
			dp[i] = 0;
		}
		for (int i = 3; i < num + 1; i++) {
			dp[i] = (i - 2) + dp[i - 1];
		}
		return dp[num];
	}

}
