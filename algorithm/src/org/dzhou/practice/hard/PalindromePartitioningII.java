package org.dzhou.practice.hard;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * 
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using
 * 1 cut.
 * 
 * @author zhoudong
 *
 *         用两次动态规划: <br>
 *         第一次：create palindrome table <br>
 *         第二次：count minimal cuts for each length
 */
public class PalindromePartitioningII {

	public int minCut(String s) {
		if (s == null || s.length() == 0)
			return -1;
		if (s.length() == 1)
			return 0;
		int[] cutsTable = createCutsDpTable(s, createPalindromeDpTable(s));
		return cutsTable[cutsTable.length - 1];
	}

	private int[] createCutsDpTable(String s, boolean[][] palindromeDpTable) {
		int[] cuts = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (palindromeDpTable[0][i]) {
				cuts[i] = 0;
			} else {
				int temp = s.length() - 1;
				for (int j = 1; j <= i; j++) {
					if (palindromeDpTable[j][i]) {
						temp = Math.min(temp, cuts[j - 1] + 1);
					}
				}
				cuts[i] = temp;
			}
		}
		return cuts;
	}

	private boolean[][] createPalindromeDpTable(String s) {
		boolean[][] dpTable = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			dpTable[i][i] = true;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dpTable[i][i + 1] = true;
			}
		}
		for (int len = 2; len < s.length(); len++) {
			for (int i = 0; i + len < s.length(); i++) {
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
