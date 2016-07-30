package org.dzhou.practice.hard;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author zhoudong
 *
 */
public class WordBreak {

	public class Solution {

		public boolean wordBreak(String s, Set<String> wordDict) {
			if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
				return false;
			boolean[] dp = new boolean[s.length()];
			for (int i = 0; i < dp.length; i++) {
				if (wordDict.contains(s.substring(0, i + 1))) {
					dp[i] = true;
					continue;
				}
				for (int j = 0; j <= i; j++) {
					if (dp[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
						dp[i] = true;
						break;
					}
				}
			}
			return dp[dp.length - 1];
		}

	}

}
