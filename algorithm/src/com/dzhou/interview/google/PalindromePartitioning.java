package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * 
 * Difficulty: Medium
 * 
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * 
 * Return
 * 
 * [ <br>
 * --["aa","b"], <br>
 * --["a","a","b"] <br>
 * ] <br>
 * 
 * @author zhoudong
 *
 */
public class PalindromePartitioning {

	public class Backtracking_Solution {

		public List<List<String>> partition(String s) {
			if (s == null || s.length() == 0)
				return Collections.emptyList();
			List<List<String>> result = new ArrayList<>();
			dfs(result, new ArrayList<>(), s, 0);
			return result;
		}

		private void dfs(List<List<String>> result, List<String> item, String str, int start) {
			if (start == str.length()) {
				result.add(new ArrayList<String>(item));
				return;
			}
			for (int i = start + 1; i <= str.length(); i++) {
				String prefix = str.substring(start, i);
				if (!isPalindrome(prefix)) {
					continue;
				}
				item.add(prefix);
				dfs(result, item, str, i);
				item.remove(item.size() - 1);
			}
		}

		private boolean isPalindrome(String str) {
			for (int low = 0, high = str.length() - 1; low < high; low++, high--) {
				if (str.charAt(low) != str.charAt(high)) {
					return false;
				}
			}
			return true;
		}
	}

	public class DynamicProgramming_Solution {

		public List<List<String>> partition(String s) {
			boolean[][] dpTable = createDpTable(s);
			if (s == null || s.length() == 0)
				return Collections.emptyList();
			List<List<String>> result = new ArrayList<>();
			dfs(dpTable, result, new ArrayList<>(), 0, s);
			return result;
		}

		private void dfs(boolean[][] dpTable, List<List<String>> result, List<String> item, int start, String str) {
			if (start == dpTable.length) {
				result.add(new ArrayList<>(item));
				return;
			}
			for (int i = start; i < dpTable.length; i++) {
				if (!dpTable[start][i]) {
					continue;
				}
				item.add(str.substring(start, i + 1));
				dfs(dpTable, result, item, i + 1, str);
				item.remove(item.size() - 1);
			}
		}

		private boolean[][] createDpTable(String str) {
			boolean[][] dpTable = new boolean[str.length()][str.length()];
			for (int i = 0; i < str.length(); i++) {
				dpTable[i][i] = true;
			}
			for (int i = 0; i < str.length() - 1; i++) {
				if (str.charAt(i) == str.charAt(i + 1)) {
					dpTable[i][i + 1] = true;
				}
			}
			for (int k = 2; k < str.length(); k++) {
				for (int start = 0; start + k < str.length(); start++) {
					if (str.charAt(start) != str.charAt(start + k)) {
						continue;
					}
					if (dpTable[start + 1][start + k - 1]) {
						dpTable[start][start + k] = true;
					}
				}
			}
			return dpTable;
		}
	}

}
