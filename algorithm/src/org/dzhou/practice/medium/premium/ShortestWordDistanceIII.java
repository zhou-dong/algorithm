package org.dzhou.practice.medium.premium;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now
 * word1 could be the same as word2.
 * 
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * word1 and word2 may be the same and they represent two individual words in
 * the list.
 * 
 * For example, <br>
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * Given word1 = “makes”, word2 = “coding”, return 1. <br>
 * Given word1 = "makes", word2 = "makes", return 3. <br>
 * 
 * Note: You may assume word1 and word2 are both in the list.
 * 
 * @author zhoudong
 *
 */
public class ShortestWordDistanceIII {

	public class Solution {

		public int shortestWordDistance(String[] words, String word1, String word2) {
			int index1 = -1, index2 = -1;
			int min = words.length;
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				if (word1.equals(word2)) {
					if (!word.equals(word1))
						continue;
					if (index1 < index2)
						index1 = i;
					else
						index2 = i;
				} else {
					if (word.equals(word1))
						index1 = i;
					else if (word.equals(word2))
						index2 = i;
				}
				if (index1 != -1 && index2 != -1) {
					min = Math.min(min, Math.abs(index1 - index2));
				}
			}
			return min;
		}

	}

	public class Solution1 {

		public int shortestWordDistance(String[] words, String word1, String word2) {
			if (word1.equals(word2))
				return sameWord(words, word1);
			else
				return differentWords(words, word1, word2);
		}

		private int differentWords(String[] words, String word1, String word2) {
			int index1 = -1, index2 = -1;
			int min = words.length;
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				if (word.equals(word1))
					index1 = i;
				else if (word.equals(word2))
					index2 = i;
				else
					continue;
				min = updateMin(min, index1, index2);
			}
			return min;

		}

		private int sameWord(String[] words, String word) {
			int index1 = -1, index2 = -1;
			int min = words.length;
			for (int i = 0; i < words.length; i++) {
				if (!word.equals(words[i]))
					continue;
				if (index1 > index2)
					index2 = i;
				else
					index1 = i;
				min = updateMin(min, index1, index2);
			}
			return min;
		}

		private int updateMin(int min, int index1, int index2) {
			if (index1 == -1 || index2 == -1)
				return min;
			return min(min, index1, index2);
		}

		private int min(int min, int index1, int index2) {
			return Math.min(min, Math.abs(index1 - index2));
		}
	}
}
