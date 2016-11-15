package com.dzhou.interview.google;

/**
 * 413. Arithmetic Slices
 * 
 * Difficulty: Medium
 * 
 * Contributors: XiangyuLi926
 * 
 * A sequence of number is called arithmetic if it consists of at least three
 * elements and if the difference between any two consecutive elements is the
 * same.
 * 
 * For example, these are arithmetic sequence:
 * 
 * 1, 3, 5, 7, 9 <br>
 * 7, 7, 7, 7 <br>
 * 3, -1, -5, -9 <br>
 * 
 * The following sequence is not arithmetic.
 * 
 * 1, 1, 2, 5, 7
 * 
 * A zero-indexed array A consisting of N numbers is given. A slice of that
 * array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * 
 * A slice (P, Q) of array A is called arithmetic if the sequence: A[P], A[p +
 * 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 <
 * Q.
 * 
 * The function should return the number of arithmetic slices in the array A.
 *
 * Example:
 * 
 * A = [1, 2, 3, 4]
 * 
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3,
 * 4] itself.
 * 
 * @author zhoudong
 *
 */
public class ArithmeticSlices {

	public int numberOfArithmeticSlices(int[] nums) {
		int sum = 0, count = 2;
		for (int i = 0; i < nums.length - 2; i++) {
			if (isArithmeticUnit(nums, i)) {
				count++;
			} else {
				sum += count(count);
				count = 2;
			}
		}
		sum += count(count);
		return sum;
	}

	public boolean isArithmeticUnit(int[] nums, int start) {
		if (start + 3 > nums.length)
			return false;
		return nums[start + 1] - nums[start] == nums[start + 2] - nums[start + 1];
	}

	public int count(int num) {
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
