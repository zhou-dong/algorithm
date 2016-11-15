package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 320. Generalized Abbreviation
 * 
 * Difficulty: Medium
 * 
 * Write a function to generate the generalized abbreviations of a word.
 * 
 * Example: Given word = "word", return the following list (order does not
 * matter):
 * 
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1",
 * "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 
 * @author zhoudong
 *
 */
public class GeneralizedAbbreviation {

	public List<String> generateAbbreviations(String word) {
		List<int[]> patterns = new ArrayList<>();
		backtrack(word, patterns, 0, new int[word.length()]);
		return decode(patterns, word);
	}

	public void backtrack(String word, List<int[]> patterns, int start, int[] pattern) {
		patterns.add(Arrays.copyOf(pattern, pattern.length));
		for (int i = start; i < word.length(); i++) {
			pattern[i] = 1;
			backtrack(word, patterns, i + 1, pattern);
			pattern[i] = 0;
		}
	}

	private List<String> decode(List<int[]> patterns, String word) {
		List<String> result = new ArrayList<>();
		for (int[] pattern : patterns)
			result.add(decode(pattern, word));
		return result;
	}

	public String decode(int[] pattern, String word) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < pattern.length; i++) {
			if (pattern[i] == 0) {
				if (count != 0) {
					sb.append(count);
					count = 0;
				}
				sb.append(word.charAt(i));
			} else {
				count++;
			}
		}
		if (count != 0)
			sb.append(count);
		return sb.toString();
	}

}
