package org.dzhou.practice.hard;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * @author zhoudong
 *
 */
public class BestTimeToBuyAndSellStockIV {

	public class Solution {

		public int maxProfit(int k, int[] prices) {
			if (prices == null || prices.length < 2)
				return 0;
			if (k >= prices.length - 1)
				return maxProfitForEveryday(prices);

			int[][] local = new int[prices.length][k + 1];
			int[][] global = new int[prices.length][k + 1];

			for (int i = 1; i < prices.length; i++) {
				int diff = prices[i] - prices[i - 1];
				for (int j = 1; j <= k; j++) {
					local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j] + diff);
					global[i][j] = Math.max(local[i][j], global[i - 1][j]);
				}
			}

			return global[prices.length - 1][k];
		}

		private int maxProfitForEveryday(int[] prices) {
			int profit = 0;
			for (int i = 1; i < prices.length; i++) {
				int diff = prices[i] - prices[i - 1];
				if (diff > 0) {
					profit += diff;
				}
			}
			return profit;
		}

	}

}
