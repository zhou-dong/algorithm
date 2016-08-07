package org.dzhou.practice.medium;

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
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1
 * day)
 * 
 * Example:<br>
 * prices = [1, 2, 3, 0, 2] <br>
 * maxProfit = 3 <br>
 * transactions = [buy, sell, cooldown, buy, sell]<br>
 * 
 * @author zhoudong
 *
 * 
 *         设sell[i] 卖出操作的最大利润。它需要考虑的是，第i天是否卖出。（手上有stock在第i天所能获得的最大利润）
 * 
 *         buy[i] 买进操作的最大利润。它需要考虑的是，第i天是否买进。（手上没有stock在第i天所能获得的最大利润）
 * 
 *         所以，显然有状态转移方程
 * 
 *         buy[i] = max(buy[i-1] , sell[i-2] – prices[i]) //
 *         休息一天在买入，所以是sell[i-2]在状态转移
 * 
 *         sell[i] = max(sell[i-1], buy[i-1] + prices[i])
 * 
 *         最后显然有sell[n-1] > buy[n-1] 所以我们返回sell[n-1]
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
