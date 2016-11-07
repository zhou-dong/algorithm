package com.dzhou.interview.google;

/**
 * 367. Valid Perfect Square
 * 
 * Difficulty: Medium
 * 
 * Given a positive integer num, write a function which returns True if num is a
 * perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:
 * 
 * Input: 16 Returns: True
 * 
 * Example 2:
 * 
 * Input: 14 Returns: False
 * 
 * @author zhoudong
 *
 */
public class ValidPerfectSquare {

	// Time Limit Exceeded
	class Brute_Force_Solution {
		public boolean isPerfectSquare(int num) {
			for (int i = 1; i <= num; i++) {
				if (i * i == num) {
					return true;
				}
			}
			return false;
		}
	}

	// Time Limit Exceeded
	class Binary_Search_Solution {
		public boolean isPerfectSquare(int num) {
			int left = 0, right = num;
			while (left <= right) {
				int mid = (left + right) / 2;
				double square = mid * mid;
				if (square == num) {
					return true;
				}
				if (square > num) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
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
	class Math_Solution {
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
