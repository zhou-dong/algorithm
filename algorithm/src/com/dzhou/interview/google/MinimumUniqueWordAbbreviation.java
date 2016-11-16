package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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

	class Abbreviation {
		int[] pattern;
		int size;
		int value;
		String word;

		Abbreviation(String word, int[] pattern) {
			this.pattern = pattern;
			this.size = pattern.length;
			this.value = value();
			this.word = word;
		}

		private int value() {
			int result = 0;
			for (int i = 0; i < size; i++)
				result = result * 10 + pattern[i];
			return result;
		}

		private int length() {
			int result = 0, count = 0;
			for (int i = 0; i < pattern.length; i++) {
				if (pattern[i] == 0) {
					result++;
					if (count > 0) {
						result++;
						count = 0;
					}
				} else {
					count++;
				}
			}
			return result;
		}

		@Override
		public int hashCode() {
			return Objects.hash(value);
		}

		@Override
		public boolean equals(Object other) {
			if (this == other)
				return true;
			if (!(other instanceof Abbreviation))
				return false;
			return this.value == ((Abbreviation) other).value;
		}

		@Override
		public String toString() {
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

	public String minAbbreviation(String target, String[] dictionary) {
		Set<String> sameLengths = sameLengthWords(dictionary, target);
		if (sameLengths.size() == 0)
			return target.length() + "";
		List<Abbreviation> abbreviations = createWordAbbreviations(target);
		List<Abbreviation> sameAbbreviations = findSameAbbreviations(sameLengths, target);
		return abbreviations.get(minIndex(abbreviations, sameAbbreviations)).toString();
	}

	private List<Abbreviation> createWordAbbreviations(String word) {
		List<int[]> patterns = new ArrayList<>();
		backtrack(word, patterns, 0, new int[word.length()]);
		return decode(patterns, word);
	}

	private void backtrack(String word, List<int[]> patterns, int start, int[] pattern) {
		patterns.add(Arrays.copyOf(pattern, pattern.length));
		for (int i = start; i < word.length(); i++) {
			pattern[i] = 1;
			backtrack(word, patterns, i + 1, pattern);
			pattern[i] = 0;
		}
	}

	private List<Abbreviation> decode(List<int[]> patterns, String word) {
		List<Abbreviation> result = new ArrayList<>();
		for (int[] pattern : patterns)
			result.add(new Abbreviation(word, pattern));
		return result;
	}

	private List<Abbreviation> findSameAbbreviations(Set<String> sameLengths, String target) {
		List<Abbreviation> result = new ArrayList<>();
		int[] pattern = new int[target.length()];
		Arrays.fill(pattern, 1);
		result.add(new Abbreviation(target, pattern));
		for (String word : sameLengths) {
			List<int[]> items = new ArrayList<>();
			sameAbbreviations(findSameAbbreviation(target, word), items, 0);
			for (int[] item : items) {
				result.add(new Abbreviation(word, item));
			}
		}
		return result;
	}

	private int[] findSameAbbreviation(String target, String word) {
		int[] pattern = new int[target.length()];
		for (int i = 0; i < pattern.length; i++) {
			if (target.charAt(i) == word.charAt(i)) {
				pattern[i] = 0;
			} else {
				pattern[i] = 1;
			}
		}
		return pattern;
	}

	private int minIndex(List<Abbreviation> abbreviations, List<Abbreviation> sameAbbreviations) {
		int index = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < abbreviations.size(); i++) {
			Abbreviation abbreviation = abbreviations.get(i);
			if (sameAbbreviations.contains(abbreviation)) {
				continue;
			}
			if (min > abbreviation.length()) {
				min = abbreviation.length();
				index = i;
			}
		}
		return index;
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

	private static void sameAbbreviations(int[] pattern, List<int[]> result, int start) {
		result.add(Arrays.copyOf(pattern, pattern.length));
		for (int i = start; i < pattern.length; i++) {
			if (pattern[i] == 1) {
				continue;
			}
			pattern[i] = 1;
			sameAbbreviations(pattern, result, i + 1);
			pattern[i] = 0;
		}
	}

}
