package org.dzhou.research.algorithm.sort;

import org.dzhou.research.algorithm.sort.KadaneAlgorithm.KadaneResult;

/**
 * @author zhoudong
 * 
 *         https://www.youtube.com/watch?v=yCQN096CwWM
 */
public class MaximumSumRectangularSubmatrixInMatrix {

	public class Result {
		public int sum;
		public int up;
		public int down;
		public int left;
		public int right;

		public Result(int sum, int up, int down, int left, int right) {
			this.sum = sum;
			this.up = up;
			this.down = down;
			this.left = left;
			this.right = right;
		}
	}

	public Result maximumSumRectangular(int[][] matrix) {
		int up = 0, down = 0, left = 0, right = 0, max = Integer.MIN_VALUE;
		for (int slow = 0; slow < matrix[0].length; slow++) {
			int[] dp = new int[matrix.length];
			for (int fast = slow; fast < matrix[0].length; fast++) {
				dp = add(dp, copyCol(matrix, fast));
				KadaneResult kr = KadaneAlgorithm.maxSubArray(dp);
				if (kr.max > max) {
					up = kr.left;
					down = kr.right;
					left = slow;
					right = fast;
					max = kr.max;
				}
			}
		}
		return new Result(max, up, down, left, right);
	}

	private int[] add(int[] x, int[] y) {
		for (int i = 0; i < x.length; i++)
			x[i] += y[i];
		return x;
	}

	private int[] copyCol(int[][] matrix, int col) {
		int[] dp = new int[matrix.length];
		for (int row = 0; row < matrix.length; row++)
			dp[row] = matrix[row][col];
		return dp;
	}

}
