package org.dzhou.practice.hard;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * 
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using
 * 1 cut.
 * 
 * @author zhoudong
 *
 *         我们可以把这个问题转换成动态规划(dynamic programming)的问题
 */
public class PalindromePartitioningII {

	public class Solution {

		public int minCut(String s) {
			if (s == null || s.length() == 0)
				return 0;

			// 初始化cuts里面的值为最坏情况的值
			int len = s.length();
			int cuts[] = new int[len + 1];
			for (int i = 0; i < len; i++)
				cuts[i] = len - i;

			boolean[][] matrix = new boolean[len][len];

			// dynamic programming 过程
			for (int i = len - 1; i >= 0; --i) {
				for (int j = i; j < len; ++j) {
					if ((s.charAt(i) == s.charAt(j) && (j - i < 2))
							|| (s.charAt(i) == s.charAt(j) && matrix[i + 1][j - 1])) {
						matrix[i][j] = true;
						cuts[i] = getMinValue(cuts[i], cuts[j + 1] + 1);
					}
				}
			}
			return cuts[0] - 1;
		}

		private int getMinValue(int a, int b) {
			return a > b ? b : a;
		}
	}

}
