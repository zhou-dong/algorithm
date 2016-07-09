package org.dzhou.practice.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * all shortest transformation sequence(s) from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the word list For example,
 * 
 * Given:<br>
 * 
 * beginWord = "hit"<br>
 * endWord = "cog"<br>
 * wordList = ["hot","dot","dog","lot","log"]<br>
 * 
 * Return<br>
 * --[<br>
 * ----["hit","hot","dot","dog","cog"],<br>
 * ----["hit","hot","lot","log","cog"]<br>
 * --]<br>
 * 
 * Note:<br>
 * 
 * All words have the same length.<br>
 * All words contain only lowercase alphabetic characters.<br>
 * 
 * @author zhoudong
 *
 */
public class WordLadderII {

	public class Solution {

		public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

			return null;
		}

	}

	// Time Limit Exceeded
	public class Solution1 {

		public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
			List<List<String>> result = new ArrayList<>();
			List<String> item = new ArrayList<>();
			item.add(beginWord);
			Set<String> set = new HashSet<>();
			set.add(beginWord);
			helper(result, item, endWord, wordList, set);
			return trim(result);
		}

		private void helper(List<List<String>> result, List<String> item, String endWord, Set<String> wordList,
				Set<String> set) {
			String last = item.get(item.size() - 1);
			if (last.equals(endWord)) {
				result.add(new ArrayList<>(item));
				return;
			}
			for (String word : wordList) {
				if (set.contains(word))
					continue;
				if (isOneEditDistance(last, word)) {
					item.add(word);
					set.add(word);
					helper(result, item, endWord, wordList, set);
					item.remove(item.size() - 1);
					set.remove(word);
				}
			}
		}

		private boolean isOneEditDistance(String beginWord, String endWord) {
			int count = 0;
			for (int i = 0; i < beginWord.length(); i++) {
				if (beginWord.charAt(i) == endWord.charAt(i))
					continue;
				if (++count > 1)
					return false;
			}
			return count == 1;
		}

		private List<List<String>> trim(List<List<String>> result) {
			Map<Integer, List<Integer>> map = new HashMap<>();
			for (int i = 0; i < result.size(); i++) {
				List<String> item = result.get(i);
				if (!map.containsKey(item.size())) {
					map.put(item.size(), new ArrayList<>());
				}
				map.get(item.size()).add(i);
			}
			List<List<String>> trimed = new ArrayList<>();
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				if (!map.containsKey(i))
					continue;
				for (int index : map.get(i)) {
					trimed.add(result.get(index));
				}
				return trimed;
			}
			return trimed;
		}

	}

}
