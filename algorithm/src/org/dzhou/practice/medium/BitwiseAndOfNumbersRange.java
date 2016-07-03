package org.dzhou.practice.medium;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 * 
 * @author zhoudong
 *
 *         给定范围[m, n]，其中 0 <= m <= n <= 2147483647，返回范围内所有整数的按位与，包括边界。
 * 
 *         例如，给定范围[5, 7], 你应该返回4。
 * 
 *         bin decimal<br>
 *         101 5<br>
 *         110 6<br>
 *         111 7<br>
 *         -----<br>
 *         100 4<br>
 */
public class BitwiseAndOfNumbersRange {

	public class Solution {

		public int rangeBitwiseAnd(int m, int n) {
			int x = 0;
			while (m != n) {
				m >>= 1;
				n >>= 1;
				x++;
			}
			return m << x;
		}

	}

}
