package org.dzhou.practice.easy.premium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, determine if a permutation of the string could form a
 * palindrome.
 * 
 * For example,
 * 
 * "code" -> False, "aab" -> True, "carerac" -> True.
 * 
 * Hint:
 * 
 * 1. Consider the palindromes of odd vs even length. What difference do you
 * notice? <br>
 * 2. Count the frequency of each character. <br>
 * 3. If each character occurs even number of times, then it must be a
 * palindrome. How about character which occurs odd number of times?
 * 
 * @author zhoudong
 *
 */
public class PalindromePermutation {

	public class Solution {
		public boolean canPermutePalindrome(String s) {
			Map<Character, Integer> map = new HashMap<>();
			for (char c : s.toCharArray()) {
				if (!map.containsKey(c)) {
					map.put(c, 1);
				} else {
					map.put(c, map.get(c) + 1);
				}
			}
			int oddCount = 0;
			for (int time : map.values()) {
				if (time % 2 != 0) {
					if (oddCount == 0)
						oddCount++;
					else
						return false;
				}
			}
			return true;
		}
	}

}
