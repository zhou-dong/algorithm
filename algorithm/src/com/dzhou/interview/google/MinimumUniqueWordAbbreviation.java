package com.dzhou.interview.google;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 411. Minimum Unique Word Abbreviation
 * 
 * Difficulty: Hard
 * 
 * A string such as "word" contains the following abbreviations:
 * 
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1",
 * "w1r1", "1o2", "2r1", "3d", "w3", "4"] Given a target string and a set of
 * strings in a dictionary, find an abbreviation of this target string with the
 * smallest possible length such that it does not conflict with abbreviations of
 * the strings in the dictionary.
 * 
 * Each number or letter in the abbreviation is considered length = 1. For
 * example, the abbreviation "a32bc" has length = 4.
 * 
 * Note: In the case of multiple answers as shown in the second example below,
 * you may return any one of them. Assume length of target string = m, and
 * dictionary size = n. You may assume that m ≤ 21, n ≤ 1000, and log2(n) + m ≤
 * 20. Examples: "apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with
 * "blade")
 * 
 * "apple", ["plain", "amber", "blade"] -> "1p3" (other valid answers include
 * "ap3", "a3e", "2p2", "3le", "3l1"). Hide Company Tags
 * 
 * @author zhoudong
 *
 */
public class MinimumUniqueWordAbbreviation {

	public String minAbbreviation(String target, String[] dictionary) {
		Set<String> sameLengths = sameLengthWords(dictionary, target);
		if (sameLengths.size() == 0)
			return Integer.toString(target.length());
		PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		createWordAbbreviations(target, heap);
		while (!heap.isEmpty()) {
			String abbr = heap.poll();
			if (isValid(abbr, sameLengths)) {
				return abbr;
			}
		}
		return target;
	}

	private boolean isValid(String abbr, Set<String> sameLengths) {
		for (String word : sameLengths) {
			if (validWordAbbreviation(word, abbr)) {
				return false;
			}
		}
		return true;
	}

	private boolean validWordAbbreviation(String word, String abbr) {
		int i = 0, j = 0;
		while (i < word.length() && j < abbr.length()) {
			if (Character.isDigit(abbr.charAt(j))) {
				if ((abbr.charAt(j) - '0') == 0)
					return false;
				int size = 0;
				while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
					size = size * 10 + (abbr.charAt(j) - '0');
					j++;
				}
				i += size;
			} else {
				if (word.charAt(i) != abbr.charAt(j)) {
					return false;
				}
				i++;
				j++;
			}
		}
		return i == word.length() && j == abbr.length();
	}

	private void createWordAbbreviations(String word, PriorityQueue<String> heap) {
		backtrack(word, heap, 0, new int[word.length()]);
	}

	private void backtrack(String word, PriorityQueue<String> heap, int start, int[] pattern) {
		heap.offer(decode(pattern, word));
		for (int i = start; i < word.length(); i++) {
			pattern[i] = 1;
			backtrack(word, heap, i + 1, pattern);
			pattern[i] = 0;
		}
	}

	private String decode(int[] pattern, String word) {
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

	private Set<String> sameLengthWords(String[] dictionary, String target) {
		Set<String> result = new HashSet<>();
		for (String word : dictionary) {
			if (target.length() == word.length()) {
				result.add(word);
			}
		}
		return result;
	}

}
