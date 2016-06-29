package org.dzhou.practice.medium;

/**
 * Given a positive integer num, write a function which returns True if num is a
 * perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:<br>
 * Input: 16, Returns: True
 * 
 * Example 2:<br>
 * Input: 14, Returns: False
 * 
 * @author zhoudong
 *
 *         reference: http://www.cnblogs.com/grandyang/p/5619296.html
 */
public class ValidPerfectSquare {

	// 比如一个数字49，我们先对其除以2，得到24，发现24的平方大于49，
	// 那么再对24除以2，得到12，发现12的平方还是大于49，再对12除以2，得到6，发现6的平方小于49，
	// 于是遍历6到12中的所有数，看有没有平方等于49的，有就返回true，没有就返回false
	public class Solution {

		public boolean isPerfectSquare(int num) {
			if (num == 1)
				return true;
			if (num < 4)
				return false;
			long x = num / 2, s = x * x;
			while (s > num) {
				x /= 2;
				s = x * x;
			}
			for (int i = (int) x; i <= 2 * x; i++) {
				if (i * i == num)
					return true;
			}
			return false;
		}

	}

	// 从1搜索到num/2，看有没有平方正好等于num的数
	public class Solution1 {

		public boolean isPerfectSquare(int num) {
			if (num == 1)
				return true;
			if (num < 4)
				return false;
			for (int i = 1; i <= num / 2; i++) {
				if (i * i == num)
					return true;
			}
			return false;
		}

	}

	// 二分查找法
	public class Solution2 {

		public boolean isPerfectSquare(int num) {
			int left = 0, right = num;
			while (left <= right) {
				int mid = (left + right) / 2;
				int s = mid * mid;
				if (s == num)
					return true;
				if (s < num)
					left = mid + 1;
				else
					right = mid - 1;
			}
			return false;
		}

	}

	/**
	 * 纯数学解法了，完全平方数是一系列奇数之和，例如：
	 * 
	 * 1 = 1<br>
	 * 4 = 1 + 3<br>
	 * 9 = 1 + 3 + 5<br>
	 * 16 = 1 + 3 + 5 + 7<br>
	 * 25 = 1 + 3 + 5 + 7 + 9<br>
	 * 36 = 1 + 3 + 5 + 7 + 9 + 11<br>
	 * ....<br>
	 * 1+3+...+(2n-1) = (2n-1 + 1)n/2 = n*n<br>
	 */
	public class Solution3 {

		public boolean isPerfectSquare(int num) {
			int i = 1;
			while (num > 0) {
				num -= i;
				i += 2;
			}
			return num == 0;
		}

	}

}
