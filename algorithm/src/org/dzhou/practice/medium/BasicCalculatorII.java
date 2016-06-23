package org.dzhou.practice.medium;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward
 * zero.
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * 
 * "3+2*2" = 7
 * 
 * " 3/2 " = 1
 * 
 * " 3+5 / 2 " = 5
 * 
 * Note: Do not use the eval built-in library function.
 * 
 * @author zhoudong
 *
 *         通常对算术表达式求值都是用栈来实现的，但是鉴于本题的情形比较简单，所以可以不用栈来实现。
 */
public class BasicCalculatorII {

	public class Solution {

		public int calculate(String s) {

			int result = 0, prev = 0, sign = 1;
			int mulDiv = -1; // 'none' = -1, '*'= 0, '/' = 1;

			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (ch == ' ')
					continue;
				else if (Character.isDigit(s.charAt(i))) {
					int num = s.charAt(i) - '0';
					while (++i < s.length() && Character.isDigit(s.charAt(i))) {
						num = num * 10 + s.charAt(i) - '0';
					}
					i--;
					if (mulDiv == 0) {
						prev *= num;
						mulDiv = -1; // reset
					} else if (mulDiv == 1) {
						prev /= num;
						mulDiv = -1; // reset
					} else {
						prev = num;
					}
				} else if (ch == '+') {
					result += sign * prev;
					sign = 1;
				} else if (ch == '-') {
					result += sign * prev;
					sign = -1;
				} else if (ch == '*') {
					mulDiv = 0;
				} else if (ch == '/') {
					mulDiv = 1;
				}
			}
			result += sign * prev;
			return result;

		}

	}

}
