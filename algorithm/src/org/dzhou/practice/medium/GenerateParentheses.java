package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * @author zhoudong
 *
 */
public class GenerateParentheses {

	public class Solution {

		public List<String> generateParenthesis(int n) {
			if (n < 1)
				return Collections.emptyList();
			List<String> result = new ArrayList<String>();
			dfs(result, new String(), n, n);
			return result;
		}

		public void dfs(List<String> result, String item, int left, int right) {
			if (left > right)// deal with ")("
				return;
			if (left == 0 && right == 0) {
				result.add(item.toString());
				return;
			}
			if (left > 0)
				dfs(result, item + '(', left - 1, right);
			if (right > 0)
				dfs(result, item + ')', left, right - 1);
		}

	}

}
