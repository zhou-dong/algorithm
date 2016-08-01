package org.dzhou.practice.hard;

import java.util.Collections;
import java.util.List;

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

			return null;
		}

		private boolean isInputValid(String s, String words[]) {
			return s != null && words != null && s.length() > 0 && words.length > 0;
		}

	}

}
