package org.dzhou.practice.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
		public List<List<String>> findLadders(String start, String end, Set<String> dict) {
			List<List<String>> ladders = new ArrayList<List<String>>();
			Map<String, List<String>> map = new HashMap<String, List<String>>();
			Map<String, Integer> distance = new HashMap<String, Integer>();
			dict.add(start);
			dict.add(end);
			bfs(map, distance, start, end, dict);
			dfs(ladders, new ArrayList<String>(), end, start, distance, map);
			return ladders;
		}

		void dfs(List<List<String>> ladders, List<String> path, String crt, String start, Map<String, Integer> distance,
				Map<String, List<String>> map) {
			path.add(crt);
			if (crt.equals(start)) {
				Collections.reverse(path);
				ladders.add(new ArrayList<String>(path));
				Collections.reverse(path);
			} else {
				for (String next : map.get(crt)) {
					if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
						dfs(ladders, path, next, start, distance, map);
					}
				}
			}
			path.remove(path.size() - 1);
		}

		void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end,
				Set<String> dict) {
			Queue<String> q = new LinkedList<String>();
			q.offer(start);
			distance.put(start, 0);
			for (String s : dict) {
				map.put(s, new ArrayList<String>());
			}
			while (!q.isEmpty()) {
				String crt = q.poll();
				List<String> nextList = expand(crt, dict);
				for (String next : nextList) {
					map.get(next).add(crt);
					if (!distance.containsKey(next)) {
						distance.put(next, distance.get(crt) + 1);
						q.offer(next);
					}
				}
			}
		}

		List<String> expand(String crt, Set<String> dict) {
			List<String> expansion = new ArrayList<String>();
			for (int i = 0; i < crt.length(); i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					if (ch != crt.charAt(i)) {
						String expanded = crt.substring(0, i) + ch + crt.substring(i + 1);
						if (dict.contains(expanded)) {
							expansion.add(expanded);
						}
					}
				}
			}
			return expansion;
		}
	}

	// Time Limit Exceeded
	public class Solution1 {

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
	public class Solution2 {

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
