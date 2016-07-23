package org.dzhou.again.wordbreak;

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

			boolean[] dp = new boolean[s.length() + 1];

			for (int i = 0; i < s.length(); i++) {
				// s.substring(0, i+1) 在dictionary里面
				if (wordDict.contains(s.substring(0, i + 1))) {
					dp[i + 1] = true;
					continue;
				}

				for (int j = 1; j <= i; j++) {
					// dp[j] == true 并且 s.substring(j, i+1)在dictionary里面
					if (dp[j] && wordDict.contains(s.substring(j, i + 1))) {
						dp[i + 1] = true;
						break;
					}
				}
			}

			return dp[s.length()];
		}

	}

}
