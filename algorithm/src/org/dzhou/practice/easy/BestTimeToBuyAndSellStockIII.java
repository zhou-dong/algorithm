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
		int[] postProfilt = new int[prices.length];

		int curMin = 0;
		for (int i = 1; i < prices.length; i++) {
			curMin = Math.min(curMin, prices[i]);
			preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin);
		}

		int curMax = 0;
		int maxProfit = 0;

		return maxProfit;
	}

}
