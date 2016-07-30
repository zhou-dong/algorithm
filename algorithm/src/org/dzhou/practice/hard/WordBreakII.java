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
 * dict = ["cat", "cats", "and", "sand", "dog"].<br>
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
			if (!hasSolution(s, wordDict))
				return Collections.emptyList();
			List<String> result = new ArrayList<>();
			dfs(s, wordDict, result, new StringBuilder(), 0);
			return result;
		}

		private void dfs(String s, Set<String> wordDict, List<String> result, StringBuilder item, int start) {
			if (start == s.length()) {
				result.add(new String(item));
				return;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = start; i < s.length(); i++) {
				sb.append(s.charAt(i));
				if (!wordDict.contains(sb.toString()))
					continue;
				int itemLength = item.length();
				if (itemLength > 0)
					item.append(" ");
				dfs(s, wordDict, result, item.append(sb), i + 1);
				item.delete(itemLength, item.length());
			}
		}

		private boolean hasSolution(String s, Set<String> wordDict) {
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
