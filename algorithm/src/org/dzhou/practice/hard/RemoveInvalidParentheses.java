package org.dzhou.practice.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Remove the minimum number of invalid parentheses in order to make the input
 * string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses (and).
 * 
 * Examples: <br>
 * "()())()" -> ["()()()", "(())()"] <br>
 * "(a)())()" -> ["(a)()()", "(a())()"] <br>
 * ")(" -> [""] <br>
 * 
 * @author zhoudong
 *
 */
public class RemoveInvalidParentheses {

	public class Solution {
		public List<String> removeInvalidParentheses(String s) {
			return s == "" ? Collections.emptyList() : bfs(s);
		}

		private List<String> bfs(String s) {
			List<String> result = new ArrayList<>();

			return result;
		}

		private boolean isValidParentheses(String s) {
			int count = 0;
			for (char c : s.toCharArray()) {
				if (c == '(') {
					count++;
				} else if (c == ')') {
					if (count == 0)
						return false;
					count--;
				}
			}
			return count == 0;
		}
	}

}
