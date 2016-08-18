package org.dzhou.practice.medium.premium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now you
 * are given the list of words and your method will be called repeatedly many
 * times with different parameters. How would you optimize it?
 * 
 * Design a class which receives a list of words in the constructor, and
 * implements a method that takes two words word1 and word2 and return the
 * shortest distance between these two words in the list.
 * 
 * For example, Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Given word1 = “coding”, word2 = “practice”, return 3. <br>
 * Given word1 = "makes", word2 = "coding", return 1.
 * 
 * Note: You may assume that word1 does not equal to word2, and word1 and word2
 * are both in the list.
 * 
 * Hide Company Tags
 * 
 * @author zhoudong
 */
public class ShortestWordDistanceII {

	// Time Limit Exceeded
	public class WordDistance {

		private Map<String, List<Integer>> words;

		public WordDistance(String[] words) {
			this.words = new HashMap<>();
			fill(words);
		}

		private void fill(String[] words) {
			for (int i = 0; i < words.length; i++) {
				addToMap(words[i], i);
			}
		}

		private void addToMap(String word, int position) {
			if (!words.containsKey(word))
				words.put(word, new ArrayList<>());
			words.get(word).add(position);
		}

		public int shortest(String word1, String word2) {
			return findShortest(word1, word2);
		}

		public int findShortest(String word1, String word2) {
			int min = Integer.MAX_VALUE;
			List<Integer> posA = words.get(word1);
			List<Integer> posB = words.get(word2);
			for (int a : posA) {
				for (int b : posB) {
					min = Math.min(min, Math.abs(a - b));
				}
			}
			return min;
		}
	}

	// Your WordDistance object will be instantiated and called as such:
	// WordDistance wordDistance = new WordDistance(words);
	// wordDistance.shortest("word1", "word2");
	// wordDistance.shortest("anotherWord1", "anotherWord2");
}
