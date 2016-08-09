package org.dzhou.practice.easy.premium;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * For example,<br>
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * Given word1 = “coding”, word2 = “practice”, return 3. <br>
 * Given word1 = "makes", word2 = "coding", return 1.
 * 
 * Note: You may assume that word1 does not equal to word2, and word1 and word2
 * are both in the list.
 * 
 * @author zhoudong
 *
 */
public class ShortestWordDistance {

	public class Solution {
		public int shortestDistance(String[] words, String word1, String word2) {
			int index1 = -1, index2 = -1;
			int min = words.length;
			for (int i = 0; i < words.length; i++) {
				if (word1.equals(words[i]))
					index1 = i;
				else if (word2.equals(words[i]))
					index2 = i;
				if (index1 != -1 && index2 != -1)
					min = Math.min(min, Math.abs(index1 - index2));
			}
			return min;
		}
	}

	public class Solution1 {
		public int shortestDistance(String[] words, String word1, String word2) {
			int index1 = -1, index2 = -1;
			int min = words.length;
			for (int i = 0; i < words.length; i++) {
				if (word1.equals(words[i]))
					index1 = i;
				else if (word2.equals(words[i]))
					index2 = i;
				else
					continue;
				if (index1 != -1 && index2 != -1) {
					min = Math.min(min, Math.abs(index1 - index2));
					if (min == 1)
						return 1;
				}
			}
			return min;
		}
	}

	public class Solution2 {
		public int shortestDistance(String[] words, String word1, String word2) {
			Set<Integer> indices1 = new HashSet<>();
			Set<Integer> indices2 = new HashSet<>();
			for (int i = 0; i < words.length; i++) {
				if (word1.equals(words[i]))
					indices1.add(i);
				else if (word2.equals(words[i])) {
					indices2.add(i);
				}
			}

			int min = Integer.MAX_VALUE;
			for (int x : indices1) {
				for (int y : indices2) {
					int interval = Math.abs(x - y);
					if (interval == 1)
						return 1;
					min = Math.min(min, interval);
				}
			}
			return min;
		}
	}

}
