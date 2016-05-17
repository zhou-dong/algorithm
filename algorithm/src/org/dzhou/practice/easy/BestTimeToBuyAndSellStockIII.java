package org.dzhou.practice.easy;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note:<br>
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 * 
 * @author zhoudong
 *
 */
public class BestTimeToBuyAndSellStockIII {

	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;

		int[] preProfit = new int[prices.length];
		int[] postProfit = new int[prices.length];

		int curMin = prices[0];
		for (int i = 1; i < prices.length; i++) {
			curMin = Math.min(curMin, prices[i]);
			preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin);
		}

		int curMax = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			curMax = Math.max(curMax, prices[i]);
			postProfit[i] = Math.max(postProfit[i + 1], curMax - prices[i]);
		}

		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			maxProfit = Math.max(maxProfit, preProfit[i] + postProfit[i]);
		}

		return maxProfit;
	}

}
