package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the word list For example,
 * 
 * Given:
 * 
 * beginWord = "hit"
 * 
 * endWord = "cog"
 * 
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 
 * return its length 5.
 * 
 * Note:
 * 
 * Return 0 if there is no such transformation sequence.
 * 
 * All words have the same length.
 * 
 * All words contain only lowercase alphabetic characters.
 * 
 * @author zhoudong
 *
 */
public class WordLadder {

	public class Solution {

		public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
			if (wordList == null)
				return 0;
			if (beginWord.equals(endWord))
				return 1;

			wordList.add(beginWord);
			wordList.add(endWord);

			return bfs(beginWord, endWord, wordList);
		}

		private int bfs(String beginWord, String endWord, Set<String> wordList) {

			Set<String> set = new HashSet<>();
			set.add(beginWord);
			Queue<String> queue = new LinkedList<>();
			queue.add(beginWord);

			int result = 0;
			while (!queue.isEmpty()) {
				result++;
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					String word = queue.poll();
					if (word.equals(endWord))
						return result;
					for (String str : getNextWords(word, wordList)) {
						if (!set.contains(str)) {
							set.add(str);
							queue.add(str);
						}
					}
				}
			}

			return 0;
		}

		private ArrayList<String> getNextWords(String word, Set<String> dict) {
			ArrayList<String> nextWords = new ArrayList<String>();
			for (char c = 'a'; c <= 'z'; c++) {
				for (int i = 0; i < word.length(); i++) {
					if (c == word.charAt(i)) {
						continue;
					}
					String nextWord = replace(word, i, c);
					if (dict.contains(nextWord)) {
						nextWords.add(nextWord);
					}
				}
			}
			return nextWords;
		}

		private String replace(String s, int index, char c) {
			char[] chars = s.toCharArray();
			chars[index] = c;
			return new String(chars);
		}

		@Deprecated
		List<String> getNextWords1(String word, Set<String> wordList) {
			List<String> result = new ArrayList<>();
			for (String str : wordList) {
				if (oneEditDistance(word, str))
					result.add(str);
			}
			return result;
		}

		private boolean oneEditDistance(String x, String y) {
			if (x.length() != y.length())
				return false;
			int distance = 0;
			for (int i = 0; i < x.length(); i++) {
				if (x.charAt(i) != y.charAt(i))
					distance++;
				if (distance > 1)
					return false;
			}
			return distance == 1;
		}

	}

}
