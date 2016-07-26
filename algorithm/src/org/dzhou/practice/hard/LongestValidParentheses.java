package org.dzhou.practice.hard;

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
 *         看到题的第一感觉觉得应该用dynamic programming
 */
public class LongestValidParentheses {

	public class Solution {

		public int longestValidParentheses(String s) {

			int max = 0;

			int left = 0;
			int right = 0;

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ')') {
					right++;
					if (right > left) {
						right = 0;
						left = 0;
					} else {
						max = Math.max(max, right);
					}
				} else if (s.charAt(i) == '(') {
					left++;
				}
			}

			return max * 2;
		}

	}

}
