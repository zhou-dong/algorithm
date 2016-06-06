package org.dzhou.practice.medium;

/**
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 * 
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 =
 * 3 + 3 + 4).
 * 
 * Note: you may assume that n is not less than 2.
 * 
 * Hint:
 * 
 * 1. There is a simple O(n) solution to this problem.
 * 
 * 2. You may check the breaking results of n ranging from 7 to 10 to discover
 * the regularities.
 * 
 * @author zhoudong
 *
 */
public class IntegerBreak {

	public class Solution {

		public int integerBreak(int n) {
			if (n == 2)
				return 1;
			if (n == 3)
				return 2;
			int result = 1;
			while (n > 2) {
				result *= 3;
				n -= 3;
			}
			if (n == 1)
				return (result / 3) * 4;// 余1，把其中的一个3加1变为4再相乘
			if (n == 2)
				return result * 2; // 余2,则可直接把2与res相乘
			return result;
		}

	}

	public class Solution1 {

		public int integerBreak(int n) {
			int size = n > 7 ? (n + 1) : 8;
			int[] dp = new int[size];
			dp[0] = 0;
			dp[1] = 0;
			dp[2] = 1;
			dp[3] = 2;
			dp[4] = 4;
			dp[5] = 6;
			dp[6] = 9;
			dp[7] = 12;
			for (int i = 8; i < size; i++)
				dp[i] = Math.max(2 * dp[i - 2], 3 * dp[i - 3]);
			return dp[n];
		}

	}

}
