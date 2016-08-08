package org.dzhou.practice.easy;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 * 
 * After you sell your stock, you cannot buy stock on next day. (ie, cool down 1
 * day)
 * 
 * @author zhoudong
 *
 *         reference:
 * 
 *         https://www.hrwhisper.me/leetcode-best-time-to-buy-and-sell-stock-
 *         with-cooldown/
 * 
 *         状态转移方程:
 * 
 *         buy[i] = max(buy[i-1] , sell[i-2] – prices[i])
 * 
 *         sell[i] = max(sell[i-1], buy[i-1] + prices[i])
 */
public class BestTimeToBuyAndSellStockWithCooldown {

	public class Solution {

		public int maxProfit(int[] prices) {

			if (prices == null || prices.length < 2)
				return 0;

			int[] buy = new int[prices.length];
			int[] sell = new int[prices.length];

			buy[0] = -prices[0];
			buy[1] = Math.max(-prices[0], -prices[1]);
			sell[1] = Math.max(0, prices[1] - prices[0]);

			for (int i = 2; i < prices.length; i++) {
				buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
				sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
			}

			return sell[prices.length - 1];
		}

	}

}
