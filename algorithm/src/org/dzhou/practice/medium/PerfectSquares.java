package org.dzhou.practice.medium;

import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example,<br>
 * given n = 12, return 3 because 12 = 4 + 4 + 4;<br>
 * given n = 13, return 2 because 13 = 4 + 9.
 * 
 * @author zhoudong
 *
 *         reference: https://segmentfault.com/a/1190000003768736
 *
 *         四平方和定理 （英语：Lagrange's four-square theorem）
 *         说明每个正整数均可表示为4个整数的平方和。它是费马多边形数定理和华林问题的特例。
 * 
 *         dynamic programming
 */

public class PerfectSquares {

	public class Solution {

		// dynamic programming solution
		public int numSquares(int n) {

			int[] dp = new int[n + 1];

			// 将所有非平方数的结果置最大，保证之后比较的时候不被选中
			Arrays.fill(dp, Integer.MAX_VALUE);

			// 将所有平方数的结果置1
			for (int i = 0; i * i <= n; i++) {
				dp[i * i] = 1;
			}

			// 从小到大找任意数a
			for (int i = 0; i <= n; i++) {
				// 从小到大找平方数 b*b
				for (int j = 0; i + j * j <= n; j++) {
					// 因为a+b*b可能本身就是平方数，所以我们要取两个中较小的
					dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
				}
			}

			return dp[n];
		}

	}

}
