package org.dzhou.practice.hard;

/**
 * Given an integer n, count the total number of digit 1 appearing in all
 * non-negative integers less than or equal to n.
 * 
 * For example: Given n = 13, Return 6, because digit 1 occurred in the
 * following numbers: 1, 10, 11, 12, 13.
 * 
 * Hint:
 * 
 * Beware of overflow.
 * 
 * @author zhoudong
 *
 *         reference:
 * 
 *         http://blog.csdn.net/xudli/article/details/46798619
 * 
 *         http://www.cnblogs.com/grandyang/p/4629032.html
 * 
 *         intuitive: 每10个数, 有一个个位是1, 每100个数, 有10个十位是1, 每1000个数, 有100个百位是1.
 *         做一个循环, 每次计算单个位上1得总个数(个位,十位, 百位).
 */
public class NumberOfDigitOne {

	public class Solution {
		public int countDigitOne(int n) {
			int ones = 0;
			for (long m = 1; m <= n; m *= 10) {
				long a = n / m, b = n % m;
				ones += (a + 8) / 10 * m;
				if (a % 10 == 1)
					ones += b + 1;
			}
			return ones;
		}
	}
}
