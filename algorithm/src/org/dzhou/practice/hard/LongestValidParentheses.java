package org.dzhou.practice.hard;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * @author zhoudong
 *
 */
public class LongestValidParentheses {

	public class Solution {

		public int longestValidParentheses(String s) {
			if (s == null || s.length() == 0)
				return 0;
			int max = 0, start = -1;
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					stack.push(i);
				} else {
					if (stack.isEmpty()) {
						start = i;
					} else {
						stack.pop();
						if (stack.isEmpty()) {
							max = Math.max(max, i - start);
						} else {
							max = Math.max(max, i - stack.peek());
						}
					}
				}
			}
			return max;
		}

	}

}
