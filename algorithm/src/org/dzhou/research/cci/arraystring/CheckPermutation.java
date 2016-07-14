package org.dzhou.research.cci.arraystring;

/**
 * Given to strings, write a method to decide if one is a permutation of the
 * other.
 * 
 * Solutions
 * 
 * 0. Sort two strings then compare.<br>
 * 1. Count every character appear time in each string.
 * 
 * @author zhoudong
 *
 */
public class CheckPermutation {

	// time complexity O(N)
	public class Solution1 {
		boolean permutation(String s, String t) {
			if (s.length() != t.length())
				return false;

			int[] letters = new int[128]; // Assumption
			for (char c : s.toCharArray()) {
				letters[c]++;
			}

			for (char c : t.toCharArray()) {
				if (--letters[c] < 0)
					return false;
			}
			return true;
		}
	}

	// Sort and compare: time complexity O(N*log(N))
	public class Solution {
		boolean permutation(String s, String t) {
			if (s.length() != t.length())
				return false;
			return sort(s).equals(sort(t));
		}

		private String sort(String str) {
			return new String(sortChars(str));
		}

		private char[] sortChars(String str) {
			char[] sorted = str.toCharArray();
			java.util.Arrays.sort(sorted);
			return sorted;
		}
	}

}
