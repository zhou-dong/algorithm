package org.dzhou.practice.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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
		ArrayList<String> result = new ArrayList<String>();
		int max = 0;

		public List<String> removeInvalidParentheses(String s) {
			if (s == null)
				return result;
			dfs(s, "", 0, 0);
			if (result.size() == 0) {
				result.add("");
			}
			return result;
		}

		public void dfs(String left, String right, int countLeft, int maxLeft) {
			if (left.length() == 0) {
				if (countLeft == 0 && right.length() != 0) {
					if (maxLeft > max) {
						max = maxLeft;
					}
					if (maxLeft == max && !result.contains(right)) {
						result.add(right);
					}
				}
				return;
			}
			if (left.charAt(0) == '(') {
				dfs(left.substring(1), right + "(", countLeft + 1, maxLeft + 1);// keep
																				// (
				dfs(left.substring(1), right, countLeft, maxLeft);// drop (
			} else if (left.charAt(0) == ')') {
				if (countLeft > 0) {
					dfs(left.substring(1), right + ")", countLeft - 1, maxLeft);
				}
				dfs(left.substring(1), right, countLeft, maxLeft);
			} else {
				dfs(left.substring(1), right + String.valueOf(left.charAt(0)), countLeft, maxLeft);
			}
		}
	}

	// Time Limit Exceeded
	public class Solution1 {

		public List<String> removeInvalidParentheses(String s) {
			if (s == null || s.length() < 1) {
				List<String> result = new LinkedList<>();
				result.add("");
				return result;
			}
			return bfs(s);
		}

		private List<String> bfs(String s) {
			Set<String> result = new HashSet<>();
			Queue<String> queue = new LinkedList<>();
			queue.add(s);
			int size = 0;
			while (!queue.isEmpty()) {
				String current = queue.poll();
				if (current.length() < size) {
					continue;
				}
				if (isValid(current)) {
					result.add(current);
					size = current.length();
				} else {
					for (int i = 0; i < current.length(); i++) {
						queue.add(current.substring(0, i) + current.substring(i + 1));
					}
				}
			}
			return new ArrayList<>(result);
		}

		private boolean isValid(String s) {
			int count = 0;
			for (char c : s.toCharArray()) {
				if (c == '(') {
					count++;
				} else if (c == ')' && (--count) < 0) {
					return false;
				}
			}
			return count == 0;
		}
	}

	private void test() {
		String s = "()())()";
		System.out.println(new Solution().removeInvalidParentheses(s));
	}

	public static void main(String[] args) {
		new RemoveInvalidParentheses().test();
	}
}
