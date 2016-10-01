package com.dzhou.interview.twitter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/game-of-thrones
 * 
 * @author zhoudong
 *
 */
public class GameOfThrones {

	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		String inputString = myScan.nextLine();
		String ans = inputString;
		System.out.println(ans);
		myScan.close();
	}

	public static class HashTable_Solution {

		public boolean isPalindrome(String anagram) {
			Map<Character, Integer> map = new HashMap<>();
			for (char c : anagram.toCharArray()) {
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}
			int mark = 0;
			for (int count : map.values()) {
				if (count % 2 == 1) {
					if (mark == 1)
						return false;
					mark++;
				}
			}
			return true;
		}

	}

	public static class Bit_Solution {

		public boolean isPalindrome(String anagram) {
			int bit = 0;
			for (char c : anagram.toCharArray()) {
				int index = c - 'a';
				if (isOne(bit, index)) {
					bit = oneToZero(bit, index);
				} else {
					bit = zeroToOne(bit, index);
				}
			}
			return bit == 0 || onlyOneBitIsOne(bit);
		}

		private int zeroToOne(int bit, int index) {
			int mask = 1 << index;
			return bit | mask;
		}

		private int oneToZero(int bit, int index) {
			int mask = 1 << index;
			return ~mask & bit;
		}

		private boolean isOne(int bit, int index) {
			int mask = 1 << index;
			return (bit & mask) != 0;
		}

		private boolean onlyOneBitIsOne(int bit) {
			return (bit & (bit - 1)) == 0;
		}

	}

}
