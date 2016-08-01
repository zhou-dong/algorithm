package org.dzhou.practice.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * For example,
 * 
 * given: s: "barfoothefoobarman" words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * @author zhoudong
 *
 */
public class SubstringWithConcatenationOfAllWords {

	public class Solution {

		public List<Integer> findSubstring(String s, String[] words) {
			if (!isInputValid(s, words))
				return Collections.emptyList();
			Map<String, Integer> wordsWithCount = wordsWithCount(words);
			return findSubstring(s, wordsWithCount, words[0].length());
		}

		private List<Integer> findSubstring(String s, Map<String, Integer> wordsWithCount, int wordLength) {
			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < s.length(); i++) {
				String str = s.substring(i);
				if (isSubString(0, wordLength, new HashMap<>(wordsWithCount), str)) {
					result.add(i);
				}
			}
			return result;
		}

		private boolean isSubString(int start, int wordLength, Map<String, Integer> words, String str) {
			while (start + wordLength <= str.length()) {
				String current = str.substring(start, start + wordLength);
				if (!words.containsKey(current))
					return false;
				if (words.get(current) == 1)
					words.remove(current);
				else
					words.put(current, words.get(current) - 1);
				if (words.size() == 0)
					return true;
				start += wordLength;
			}
			return false;
		}

		private Map<String, Integer> wordsWithCount(String[] words) {
			Map<String, Integer> map = new HashMap<>();
			for (String word : words) {
				if (map.containsKey(word))
					map.put(word, map.get(word) + 1);
				else
					map.put(word, 1);
			}
			return map;
		}

		private boolean isInputValid(String s, String words[]) {
			return s != null && words != null && s.length() > 0 && words.length > 0;
		}

	}

	private void test(String str, String[] words) {
		Solution s = new Solution();
		System.out.println(s.findSubstring(str, words));
	}

	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
		s.test("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" });
	}

	public class Solution1 {

		public List<Integer> findSubstring(String S, String[] L) {
			List<Integer> result = new ArrayList<Integer>();
			HashMap<String, Integer> toFind = new HashMap<String, Integer>();
			HashMap<String, Integer> found = new HashMap<String, Integer>();
			int m = L.length, n = L[0].length();
			for (int i = 0; i < m; i++) {
				if (!toFind.containsKey(L[i])) {
					toFind.put(L[i], 1);
				} else {
					toFind.put(L[i], toFind.get(L[i]) + 1);
				}
			}
			for (int i = 0; i <= S.length() - n * m; i++) {
				found.clear();
				int j;
				for (j = 0; j < m; j++) {
					int k = i + j * n;
					String stub = S.substring(k, k + n);
					if (!toFind.containsKey(stub))
						break;
					if (!found.containsKey(stub)) {
						found.put(stub, 1);
					} else {
						found.put(stub, found.get(stub) + 1);
					}
					if (found.get(stub) > toFind.get(stub))
						break;
				}
				if (j == m)
					result.add(i);
			}
			return result;
		}
	}

}
