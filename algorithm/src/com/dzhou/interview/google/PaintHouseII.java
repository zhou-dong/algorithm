package com.dzhou.interview.google;

/**
 * 265. Paint House II
 * 
 * Difficulty: Hard
 * 
 * There are a row of n houses, each house can be painted with one of the k
 * colors. The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the
 * same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * k cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color 0; costs[1][2] is the cost of painting house 1 with color 2, and so
 * on... Find the minimum cost to paint all houses.
 * 
 * @author zhoudong
 *
 */
public class PaintHouseII {

	public int minCostII(int[][] costs) {
		if (costs == null || costs.length == 0 || costs[0].length == 0)
			return 0;
		for (int i = 1; i < costs.length; i++) {
			int[] prev = costs[i - 1];
			int[] curr = costs[i];
			for (int j = 0; j < curr.length; j++) {
				int min = Integer.MAX_VALUE;
				for (int z = 0; z < prev.length; z++) {
					if (z == j)
						continue;
					min = Math.min(min, prev[z]);
				}
				curr[j] += min;
			}
		}
		return min(costs[costs.length - 1]);
	}

	private int min(int[] nums) {
		int min = Integer.MAX_VALUE;
		for (int num : nums)
			min = Math.min(min, num);
		return min;
	}

}
