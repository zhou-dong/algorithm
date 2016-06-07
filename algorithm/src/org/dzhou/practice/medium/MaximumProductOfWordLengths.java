package org.dzhou.practice.medium;

import java.util.Arrays;

/**
 * Given a string array words, find the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. You may
 * assume that each word will contain only lower case letters. If no such two
 * words exist, return 0.
 * 
 * Example 1:<br>
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]<br>
 * Return 16<br>
 * The two words can be "abcw", "xtfn".<br>
 * 
 * Example 2:<br>
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]<br>
 * Return 4<br>
 * The two words can be "ab", "cd".<br>
 * 
 * Example 3:<br>
 * Given ["a", "aa", "aaa", "aaaa"]<br>
 * Return 0<br>
 * No such pair of words.<br>
 * 
 * @author zhoudong
 *
 */
public class MaximumProductOfWordLengths {

	public int maxProduct(String[] words) {
		if (words == null || words.length <= 1) {
			return 0;
		}

		int[] processedWords = new int[words.length];
		Arrays.fill(processedWords, 0);
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				processedWords[i] |= (1 << words[i].charAt(j) - 'a');
			}
		}

		int maxProduct = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((processedWords[i] & processedWords[j]) != 0) {
					continue;
				}
				if (words[i].length() * words[j].length() > maxProduct) {
					maxProduct = words[i].length() * words[j].length();
				}
			}
		}
		return maxProduct;
	}

}
