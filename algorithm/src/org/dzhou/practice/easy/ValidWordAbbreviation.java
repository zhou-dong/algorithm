package org.dzhou.practice.easy;

/**
 * 408. Valid Word Abbreviation
 * 
 * Difficulty: Easy
 * 
 * Given a non-empty string s and an abbreviation abbr, return whether the
 * string matches with the given abbreviation.
 * 
 * A string such as "word" contains only the following valid abbreviations:
 * 
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1",
 * "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 
 * Notice that only the above abbreviations are valid abbreviations of the
 * string "word". Any other string is not a valid abbreviation of "word".
 * 
 * Note: Assume s contains only lowercase letters and abbr contains only
 * lowercase letters and digits.
 * 
 * Example 1: Given s = "internationalization", abbr = "i12iz4n":
 * 
 * Return true. Example 2: Given s = "apple", abbr = "a2e":
 * 
 * Return false.
 * 
 * @author zhoudong
 *
 */
public class ValidWordAbbreviation {

	public boolean validWordAbbreviation(String word, String abbr) {
		int i = 0, j = 0;
		while (i < abbr.length() && j < word.length()) {
			if (Character.isDigit(abbr.charAt(i))) {
				if ((abbr.charAt(i) - '0') == 0)
					return false;
				int size = 0;
				while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
					size = size * 10 + (abbr.charAt(i) - '0');
					i++;
				}
				j += size;
			} else {
				if (abbr.charAt(i) != word.charAt(j)) {
					return false;
				}
				i++;
				j++;
			}
		}
		return i == abbr.length() && j == word.length();
	}

}
