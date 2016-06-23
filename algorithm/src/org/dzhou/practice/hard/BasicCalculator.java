package org.dzhou.practice.hard;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces .
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * 
 * "1 + 1" = 2
 * 
 * " 2-1 + 2 " = 3
 * 
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * 
 * @author zhoudong
 *
 */
public class BasicCalculator {

	public class Solution {

		public int calculate(String s) {

			// // store the signs for the '('
			Stack<Integer> stk = new Stack<Integer>();
			stk.push(1);

			int result = 0, sign = 1;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '+') {
					sign = 1;
				} else if (c == '-') {
					sign = -1;
				} else if (c == '(') {
					stk.push(sign * stk.peek());
					sign = 1;
				} else if (c == ')') {
					stk.pop();
				} else if (Character.isDigit(c)) {
					int num = 0;
					while (i < s.length() && Character.isDigit(s.charAt(i))) {
						num = num * 10 + (s.charAt(i) - '0');
						i++;
					}
					i--;
					result += num * sign * stk.peek();
				}
			}
			return result;
		}

	}

}
