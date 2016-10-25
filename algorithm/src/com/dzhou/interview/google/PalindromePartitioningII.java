package com.dzhou.interview.google;

/**
 * 132. Palindrome Partitioning II
 * 
 * Difficulty: Hard
 * 
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return 1 since the palindrome partitioning
 * ["aa","b"] could be produced using 1 cut.
 * 
 * @author zhoudong
 *
 */
public class PalindromePartitioningII {

	public int minCut(String s) {
		if (s == null || s.length() == 0)
			return -1;
		if (s.length() == 1)
			return 0;
		return dpHelper(s);
	}

	private int dpHelper(String s) {
		boolean[][] palindrome = createPalindromeTable(s);
		int[] cuts = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (palindrome[0][i]) {
				cuts[i] = 0;
			} else {
				int temp = s.length() - 1;
				for (int j = 1; j <= i; j++) {
					if (palindrome[j][i]) {
						temp = Math.min(temp, cuts[j - 1] + 1);
					}
				}
				cuts[i] = temp;
			}
		}
		return cuts[cuts.length - 1];
	}

	private boolean[][] createPalindromeTable(String s) {
		boolean[][] dpTable = new boolean[s.length()][s.length()];
		for (int i = 0; i < dpTable.length; i++) {
			dpTable[i][i] = true;
		}
		for (int i = 0; i < dpTable.length - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dpTable[i][i + 1] = true;
			}
		}
		for (int len = 2; len < dpTable.length; len++) {
			for (int i = 0; i + len < dpTable.length; i++) {
				if (s.charAt(i) != s.charAt(i + len)) {
					continue;
				}
				if (dpTable[i + 1][i + len - 1]) {
					dpTable[i][i + len] = true;
				}
			}
		}
		return dpTable;
	}

}
