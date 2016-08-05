package org.dzhou.practice.hard;

import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy.<br>
 * Children with a higher rating get more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 * 
 * @author zhoudong
 *
 *         这题刚开始的时候，理解错了。题的意思是：rate最高的，得到的candy不一定是最多的，只要比他邻居多就行了！
 * 
 *         reference: https://segmentfault.com/a/1190000003815604
 * 
 *         典型的贪心法，如果一个孩子比另一个孩子的分高，我们只多给1块糖。<br>
 *         我们可以先从左往右遍历，确保每个孩子根他左边的孩子相比，如果分高，则糖要多1个，如果分比左边低，就只给一颗。<br>
 *         然后我们再从右往左遍历，确保每个孩子跟他右边的孩子相比，如果分高则糖至少多1个。<br>
 *         这里至少多1个的意思是，我们要取当前孩子手里糖的数量， 和其右边孩子糖的数量加1，两者的较大值）。
 * 
 */
public class Candy {

	public class Solution {

		public int candy(int[] ratings) {
			if (ratings.length <= 1) {
				return ratings.length;
			}
			int[] candies = new int[ratings.length];
			candies[0] = 1;
			// 先从左往右分糖，分数较高的多拿一颗糖，分数较少的只拿一颗糖
			for (int i = 1; i < ratings.length; i++) {
				if (ratings[i] > ratings[i - 1]) {
					candies[i] = candies[i - 1] + 1;
				} else {
					candies[i] = 1;
				}
			}
			int sum = candies[candies.length - 1];
			// 再从右往左继续分糖，分数较高的确保比右边多一颗就行了
			for (int i = ratings.length - 2; i >= 0; i--) {
				if (ratings[i] > ratings[i + 1]) {
					candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
				}
				sum += candies[i];
			}
			return sum;
		}

	}

}
