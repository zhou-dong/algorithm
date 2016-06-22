package org.dzhou.practice.medium;

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

			if (s == null || s.length() == 0)
				return true;

			boolean[] dp = new boolean[s.length() + 1];
			dp[0] = true;

			for (int i = 0; i < s.length(); i++) {

				StringBuilder str = new StringBuilder(s.substring(0, i + 1));
				for (int j = 0; j <= i; j++) {
					if (dp[j] && wordDict.contains(str.toString())) {
						dp[i + 1] = true;
						break;
					}
					str.deleteCharAt(0);
				}

			}

			return dp[s.length()];
		}

	}

}
