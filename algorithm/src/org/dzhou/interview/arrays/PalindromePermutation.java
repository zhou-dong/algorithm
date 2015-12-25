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

	private static int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int['z' - 'a' + 1];
		char[] chars = phrase.toCharArray();
		for (char c : chars) {
			int number = getCharNumber(c);
			if (number != -1)
				table[number]++;
		}
		return table;
	}

	private static int getCharNumber(char c) {
		if (c >= 'a' && c <= 'z')
			return c - 'a';
		if (c >= 'A' && c <= 'Z')
			return c - 'A';
		return -1;

	}

	public static boolean isPermutationOfPalindrome2(String phrase) {
		int oddCount = 0;
		char[] chars = phrase.toCharArray();
		int[] table = new int['z' - 'a' + 1];
		for (char c : chars) {
			int num = getCharNumber(c);
			if (num == -1)
				continue;
			table[num]++;
			if (table[num] % 2 == 1)
				oddCount++;
			else
				oddCount--;
		}
		return oddCount <= 1;
	}

	public static void main(String[] args) {
		String phrase = "taco a catAb";
		System.out.println(isPermutationOfPalindrome(phrase));
		System.out.println(isPermutationOfPalindrome2(phrase));
	}

}
