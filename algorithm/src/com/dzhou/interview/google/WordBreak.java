package com.dzhou.interview.google;

import java.util.Set;

/**
 * 139. Word Break
 * 
 * Difficulty: Medium
 * 
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given
 * 
 * s = "leetcode",
 * 
 * dict = ["leet", "code"].
 * 
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author zhoudong
 *
 */
public class WordBreak {

	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int k = 1; k <= s.length(); k++) {
			for (int i = 0; i + k <= s.length(); i++) {
				if (wordDict.contains(s.substring(i, i + k))) {
					dp[i][i + k - 1] = true;
				} else {
					for (int j = 0; j < k; j++) {
						if (dp[i][j] && dp[j + 1][i + k - 1]) {
							dp[i][i + k - 1] = true;
							break;
						}
					}
				}
			}
		}
		return dp[0][dp[0].length - 1];
	}

}
