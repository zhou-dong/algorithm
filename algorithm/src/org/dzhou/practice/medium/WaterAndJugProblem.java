package org.dzhou.practice.medium;

/**
 * You are given two jugs with capacities x and y litres. There is an infinite
 * amount of water supply available. You need to determine whether it is
 * possible to measure exactly z litres using these two jugs.
 * 
 * If z liters of water is measurable, you must have z liters of water contained
 * within one or both buckets by the end.
 * 
 * Operations allowed:
 * 
 * 1.Fill any of the jugs completely with water.
 * 
 * 2.Empty any of the jugs.
 * 
 * 3.Pour water from one jug into another till the other jug is completely full
 * or the first jug itself is empty. Example 1: (From the famous "Die Hard"
 * example)
 * 
 * Input: x = 3, y = 5, z = 4 Output: True Example 2:
 * 
 * Input: x = 2, y = 6, z = 5 Output: False
 * 
 * @author zhoudong
 *
 *         reference: https://www.hrwhisper.me/leetcode-water-jug-problem/
 *
 *         题意: 给定两个杯子，它们分别能装x和y升水，求它们是否能恰好测量出z升的水。
 * 
 *         求最大公约数GCD（Greatest Common Divisor)。
 * 
 *         https://zh.wikipedia.org/wiki/%E8%B2%9D%E7%A5%96%E7%AD%89%E5%BC%8F
 */
public class WaterAndJugProblem {

	public class Solution {

		public boolean canMeasureWater(int x, int y, int z) {
			return x + y == z || (x + y > z) && z % gcd(x, y) == 0;
		}

		// Greatest Common Divisor
		private int gcd(int a, int b) {
			return b == 0 ? a : gcd(b, a % b);
		}

	}

}
