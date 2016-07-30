package org.dzhou.practice.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * 
 * s = "catsanddog",<br>
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * @author zhoudong
 *
 */
public class WordBreakII {

	public class Solution {

		public List<String> wordBreak(String s, Set<String> wordDict) {
			if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
				return Collections.emptyList();
			boolean[] dp = createDpArray(s, wordDict);
			return (dp[dp.length - 1] == false) ? Collections.emptyList() : createResult(dp, s);
		}

		private List<String> createResult(boolean[] dp, String s) {
			List<String> result = new ArrayList<>();
			StringBuilder item = new StringBuilder();
			int prev = 0;
			for (int i = 0; i < dp.length; i++) {
				if (dp[i] == false)
					continue;

				prev = i;
			}

			return result;

		}

		private boolean[] createDpArray(String s, Set<String> wordDict) {
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
			return dp;
		}

	}

	public static void main(String[] args) {
		String s = "abcdefg";

		System.out.println(s.substring(0, 2));
	}
}
