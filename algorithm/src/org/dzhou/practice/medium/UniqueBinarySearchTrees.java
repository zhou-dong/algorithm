package org.dzhou.practice.medium;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1...n?
 * 
 * For example, Given n = 3, there are a total of 5 unique BST's.
 * 
 * @author zhoudong
 *
 *         以i为根节点的树，其左子树由[0, i-1]构成， 其右子树由[i+1, n]构成。
 */
public class UniqueBinarySearchTrees {

	public class Solution {

		public int numTrees(int n) {
			if (n <= 0)
				return 0;

			int[] dp = new int[n + 1];
			dp[0] = 1;
			dp[1] = 1;

			for (int i = 2; i <= n; i++) {
				for (int j = 0; j < i; j++) {
					dp[i] += dp[j] * dp[i - j - 1];
				}
			}

			return dp[n];
		}

	}

}
