package org.dzhou.practice.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author zhoudong
 *
 *         reference: http://blog.csdn.net/foreverling/article/details/51424643
 * 
 *         1.对于空字符串，如果数组中有回文字符串，则将空字符串与回文字符串进行组合。<br>
 *         2.对于非空字符串，将其进行拆分，如果其中一段为回文，并且数组中可以找到另一段的逆序字符串，则说明可以组合为回文。 <br>
 *         例如：”sssll” = “ss” + “sll”，而且数组中存在”lls”，因此组合”lls”和”sssll”。
 */
public class PalindromePairs {

	public class Solution {

		public List<List<Integer>> palindromePairs(String[] words) {
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < words.length; i++) {
				map.put(words[i], i);
			}

			List<Integer> palindromeWords = findPalindromeWords(words);
			List<List<Integer>> result = new ArrayList<>();
			for (int i = 0; i < words.length; i++) {
				if (words[i].length() == 0) {
					for (int j : palindromeWords) {
						addItem(result, i, j);
					}
				}

				for (int j = 0; j < words[i].length(); j++) {
					String front = words[i].substring(0, j);
					String back = words[i].substring(j, words[i].length());
					String rfront = reverse(front);
					String rback = reverse(back);
					if (isPalindrome(front) && map.containsKey(rback)) {
						addItem(result, map.get(rback), i);
					}
					if (isPalindrome(back) && map.containsKey(rfront)) {
						addItem(result, i, map.get(rfront));
					}
				}
			}
			return result;
		}

		private List<Integer> findPalindromeWords(String[] words) {
			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < words.length; i++) {
				if (isPalindrome(words[i])) {
					result.add(i);
				}
			}
			return result;
		}

		private void addItem(List<List<Integer>> result, int i, int j) {
			if (i != j) {
				result.add(createItem(i, j));
			}
		}

		private List<Integer> createItem(int i, int j) {
			List<Integer> item = new ArrayList<>();
			item.add(i);
			item.add(j);
			return item;
		}

		private String reverse(String word) {
			return new StringBuilder(word).reverse().toString();
		}

		private boolean isPalindrome(String word) {
			for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
				if (word.charAt(i) != word.charAt(j)) {
					return false;
				}
			}
			return true;
		}

	}
}
