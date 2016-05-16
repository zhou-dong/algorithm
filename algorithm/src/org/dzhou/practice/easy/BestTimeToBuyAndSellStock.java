package org.dzhou.practice.easy;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * @author zhoudong
 *
 */
public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;
		int curMin = prices[0];
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			curMin = Math.min(curMin, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - curMin);
		}
		return maxProfit;
	}

}
