package org.dzhou.practice.easy;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 * 
 * Example: Given a = 1 and b = 2, return 3.
 * 
 * @author zhoudong
 *
 */
public class SumOfTwoIntegers {

	// 异或 + 移位
	public class Solution {
		public int getSum(int a, int b) {
			while (b != 0) {
				int c = a ^ b;// 所有不需要进位的，都保持原样，需要进位的为0
				b = (a & b) << 1;// 所有需要进位的为1，其它位为0, 然后向左移动一位
				a = c;
			}
			return a;
		}
	}

}
