package com.dzhou.interview.third;

/**
 * 520. Detect Capital
 * 
 * Given a word, you need to judge whether the usage of capitals in it is right
 * or not.
 * 
 * We define the usage of capitals in a word to be right when one of the
 * following cases holds:
 * 
 * All letters in this word are capitals, like "USA".
 * 
 * All letters in this word are not capitals, like "leetcode".
 * 
 * Only the first letter in this word is capital if it has more than one letter,
 * like "Google".
 * 
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * 
 * Example 1: Input: "USA" Output: True
 * 
 * Example 2: Input: "FlaG" Output: False
 * 
 * @author zhoudong
 *
 */
public class DetectCapital {

	public boolean detectCapitalUse(String word) {
		return isUpperCase(word) || isLowerCase(word) || isFirstUpperOtherLowerCase(word);
	}

	private boolean isUpperCase(String word) {
		return word.equals(word.toUpperCase());
	}

	private boolean isLowerCase(String word) {
		return word.equals(word.toLowerCase());
	}

	private boolean isFirstUpperOtherLowerCase(String word) {
		return Character.isUpperCase(word.charAt(0)) && word.substring(1).equals(word.substring(1).toLowerCase());
	}

}
