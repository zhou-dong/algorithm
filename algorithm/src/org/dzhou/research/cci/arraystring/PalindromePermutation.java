package org.dzhou.research.cci.arraystring;

/**
 * Given a string, write a function to check if it is permutation of a
 * palindrome. A palindrome is a word or phase that is the same forwards and
 * backwards. A permutation is a rearrangement of letters. The palindrome does
 * not need to be limited to just dictionary words.
 * 
 * @author zhoudong
 *
 *         检查每个character出现的次数，如果每个character都出现双数次，或者只有一个character出现奇数次，
 *         那个这个string就是回文的变体。
 * 
 *         Solution: <br>
 *         1. 用array来index每个character出现的次数. <br>
 *         2. 用bit优化第一种解法。
 */
public class PalindromePermutation {

	// Solution with bit set
	public class Solution2 {
		boolean isPermutationOfPalindrome(String phrase) {
			int bitVector = createBitVector(phrase);
			return bitVector == 0 || checkExactlyOneBitSet(bitVector);
		}

		private int createBitVector(String phrase) {
			int bitVector = 0;
			for (char c : phrase.toCharArray()) {
				int x = getCharNumber(c);
				bitVector = toggle(bitVector, x);
			}
			return bitVector;
		}

		private int toggle(int bitVector, int index) {
			if (index < 0)
				return bitVector;
			int mask = 1 << index;
			if ((mask & bitVector) == 0)
				bitVector |= mask;
			else
				bitVector &= ~mask;
			return bitVector;
		}

		private boolean checkExactlyOneBitSet(int bitVector) {
			return (bitVector & (bitVector - 1)) == 0;
		}
	}

	//  优化第一个solution，在一次循环中得到结果
	public class Solution1 {
		boolean isPermutationOfPalindrome(String phrase) {
			int countOdd = 0;
			int[] table = new int['c' - 'a' + 1];
			for (char c : phrase.toCharArray()) {
				int num = getCharNumber(c);
				if (num == -1)
					continue;
				table[num]++;
				if (table[num] % 2 == 1)
					countOdd++;
				else
					countOdd--;
			}
			return countOdd <= 1;
		}

	}

	public class Solution {
		boolean isPermutationOfPalindrome(String phrase) {
			int[] table = buildCharFrequencyTable(phrase);
			return chechMaxOnOdd(table);
		}

		private boolean chechMaxOnOdd(int[] table) {
			boolean foundOdd = false;
			for (int count : table) {
				if (count % 2 == 0)
					continue;
				if (foundOdd)
					return false;
				foundOdd = true;
			}
			return true;
		}

		private int[] buildCharFrequencyTable(String phrase) {
			int[] table = new int['c' - 'a' + 1];
			for (char c : phrase.toCharArray()) {
				int num = getCharNumber(c);
				if (num != -1)
					table[num]++;
			}
			return table;
		}

	}

	int getCharNumber(char c) {
		if (c >= 'a' && c <= 'z')
			return c - 'a';
		if (c >= 'A' && c <= 'Z')
			return c - 'A';
		return -1;
	}

}
