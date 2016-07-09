package org.dzhou.practice.hard;

import java.util.ArrayList;
import java.util.Collections;
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
			Set<String> set = new HashSet<>();
			set.add(beginWord);
			List<String> item = new ArrayList<>();
			item.add(beginWord);
			Map<Integer, List<List<String>>> map = new HashMap<>();
			dfs(map, item, wordList, set, endWord);
			System.out.println(map.size());
			return getResult(map);
		}

		private List<List<String>> getResult(Map<Integer, List<List<String>>> map) {
			if (map.size() == 0)
				return Collections.emptyList();
			int key = 1;
			while (true) {
				if (map.containsKey(key))
					return map.get(key);
				key++;
			}
		}

		private void dfs(Map<Integer, List<List<String>>> map, List<String> item, Set<String> wordList, Set<String> set,
				String endWord) {
			String last = item.get(item.size() - 1);
			if (item.size() > wordList.size())
				return;
			if (last.equals(endWord)) {
				if (!map.containsKey(item.size()))
					map.put(item.size(), new ArrayList<>());
				map.get(item.size()).add(new ArrayList<>(item));
				return;
			}
			for (char c = 'a'; c <= 'z'; c++) {
				String next = getNextWord(last, wordList, set, c);
				if (next == null)
					continue;
				item.add(next);
				set.add(next);
				dfs(map, item, wordList, set, endWord);
				item.remove(item.size() - 1);
				set.remove(next);
			}
		}

		private String getNextWord(String word, Set<String> wordList, Set<String> set, char c) {
			for (int i = 0; i < word.length(); i++) {
				if (c == word.charAt(i))
					continue;
				String temp = replace(word, i, c);
				if (set.contains(temp))
					continue;
				if (wordList.contains(temp))
					return temp;
			}
			return null;
		}

		private String replace(String word, int index, char c) {
			char[] result = word.toCharArray();
			result[index] = c;
			return new String(result);
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
