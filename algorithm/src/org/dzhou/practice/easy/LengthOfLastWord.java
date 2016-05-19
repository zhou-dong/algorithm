package org.dzhou.practice.easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example,
 * 
 * Given s = "Hello World",
 * 
 * return 5.
 * 
 * @author zhoudong
 *
 */
public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (count != 0 && s.charAt(i) == ' ')
				return count;
			if (s.charAt(i) != ' ')
				count++;
		}
		return count;
	}

}
