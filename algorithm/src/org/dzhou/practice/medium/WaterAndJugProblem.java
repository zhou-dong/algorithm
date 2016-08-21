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
 *         题目可以表示为如下等式: <br>
 *         mx + ny = z <br>
 *         若m,n>0说明往里面加水，若m,n <0则说明清空
 * 
 *         可以参考 ： http://www.math.tamu.edu/~dallen/hollywood/diehard/diehard.htm
 * 
 *         本题中，若mx + ny = z 有解，则一定有z为GCD(x,y) 的整数倍，否则无解。
 * 
 *         且需要满足条件 x + y >=z
 */
public class WaterAndJugProblem {

	public class Solution {

		public boolean canMeasureWater(int x, int y, int z) {
			return x + y == z || (x + y > z) && z % gcd(x, y) == 0;
		}

		private int gcd(int a, int b) {
			return b == 0 ? a : gcd(b, a % b);
		}

	}

}
