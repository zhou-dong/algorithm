package org.dzhou.interview.arrays;

/**
 * Given a string, write a function to check if it is a permutation of a
 * palindrome. A palindrome is a word or phase that is the some forwards and
 * backwards. A palindrome is a rearrangement of letters. The palindrome does
 * not need to be limited to just dictionary words.
 * 
 * @author DONG ZHOU
 *
 *         If there is no odd or one odd element that will be palindrome of
 *         permutation.
 */
public class PalindromePermutation {

	public static boolean isPermutationOfPalindrome(String phrase) {
		int[] table = buildCharFrequencyTable(phrase);
		return isMaxOneOdd(table);
	}

	private static boolean isMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for (int count : table) {
			if (count % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}

	public static int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int['z' - 'a' + 1];
		char[] chars = phrase.toCharArray();
		for (char c : chars) {
			int number = getCharNumber(c);
			if (number != -1)
				table[number]++;
		}
		return table;
	}

	public static int getCharNumber(char c) {
		if (c >= 'a' && c <= 'z')
			return c - 'a';
		if (c >= 'A' && c <= 'Z')
			return c - 'A';
		return -1;

	}

	public static void main(String[] args) {
		boolean test = isPermutationOfPalindrome("taco a catA");
		System.out.println(test);
	}
}
