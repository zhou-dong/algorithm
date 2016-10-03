package org.dzhou.practice.easy;

/**
 * 397. Integer Replacement
 * 
 * Difficulty: Easy
 * 
 * Given a positive integer n and you can do operations as follow:
 * 
 * If n is even, replace n with n/2.
 * 
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * 
 * What is the minimum number of replacements needed for n to become 1?
 * 
 * Example 1:
 * 
 * Input: 8
 * 
 * Output: 3
 * 
 * Explanation: 8 -> 4 -> 2 -> 1
 * 
 * Example 2:
 * 
 * Input: 7
 * 
 * Output: 4
 * 
 * Explanation:
 * 
 * 7 -> 8 -> 4 -> 2 -> 1 or 7 -> 6 -> 3 -> 2 -> 1
 * 
 * @author zhoudong
 *
 *         当n为偶数时，下一次迭代n的取值确定为n / 2；
 * 
 *         当n为奇数时，下一次迭代n的取值n + 1或者n - 1，由其二进制表示中的最低两位数决定：
 * 
 *         若n的最低两位数为01，则令n = n - 1
 * 
 *         否则，若n的最低两位数为11，则令n = n + 1
 * 
 *         这样处理是为了使n的二进制表式中1的数目尽可能少，从而减少迭代次数
 * 
 *         需要注意的是，当n = 3时，不满足上述判定条件，需要单独处理。
 */
public class IntegerReplacement {

	public int integerReplacement(int n) {
		int count = 0;
		while (n != 1) {
			if ((n & 1) == 0) { // n为偶数
				n >>>= 1;
			} else if (n == 3 || ((n >>> 1) & 1) == 0) {
				--n;
			} else {
				++n;
			}
			++count;
		}
		return count;
	}

}
