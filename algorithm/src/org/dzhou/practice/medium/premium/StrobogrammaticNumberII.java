package org.dzhou.practice.medium.premium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Find all strobogrammatic numbers that are of length = n.
 * 
 * For example, Given n = 2, return ["11","69","88","96"].
 * 
 * Hint:
 * 
 * Try to use recursion and notice that it should recurse with n - 2 instead of
 * n - 1.
 * 
 * @author zhoudong
 *
 *         相当于 permutation palindrome: <br>
 *         1. 先生成前半部分的全排列 <br>
 *         2. 根据前半部分，生成后半部分 <br>
 * 
 *         注意： <br>
 *         1. ‘0’不可以排在首位 <br>
 *         2. ‘6’对应‘9’；‘9’对应‘6’ <br>
 */
public class StrobogrammaticNumberII {

	public class Solution {

		public List<String> findStrobogrammatic(int n) {
			if (n < 1)
				return Collections.emptyList();
			if (n == 1)
				return Arrays.asList(new String[] { "0", "1", "8" });
			Set<String> halfs = new HashSet<>();
			createHalfSet(halfs, new StringBuilder(), n / 2);
			return (n % 2 == 0) ? evenResult(halfs) : oddResult(halfs);
		}

		private List<String> evenResult(Set<String> halfs) {
			List<String> result = new ArrayList<>();
			for (String half : halfs) {
				result.add(creatEven(half));
			}
			return result;
		}

		private List<String> oddResult(Set<String> halfs) {
			List<String> result = new ArrayList<>();
			for (String half : halfs) {
				result.addAll(createOdds(half));
			}
			return result;
		}

		char[] whole = { '0', '1', '8', '6', '9' };

		private void createHalfSet(Set<String> set, StringBuilder item, int n) {
			if (item.length() == n) {
				set.add(item.toString());
				return;
			}
			for (int i = 0; i < whole.length; i++) {
				if (whole[i] == '0' && item.length() == 0)
					continue;
				createHalfSet(set, item.append(whole[i]), n);
				item.deleteCharAt(item.length() - 1);
			}
		}

		private List<String> createOdds(String s) {
			List<String> result = new ArrayList<>();
			char[] target = appendHalf(s, s.length() * 2 + 1);
			for (char c : new char[] { '0', '1', '8' })
				result.add(insertAt(target, s.length(), c));
			return result;
		}

		private String insertAt(char[] target, int index, char middle) {
			target[index] = middle;
			return new String(target);
		}

		private String creatEven(String s) {
			return new String(appendHalf(s, s.length() * 2));
		}

		private char[] appendHalf(String s, int charSize) {
			char[] result = new char[charSize];
			for (int i = 0; i < s.length(); i++) {
				result[i] = s.charAt(i);
				result[charSize - 1 - i] = getStrobogrammatic(s.charAt(i));
			}
			return result;
		}

		private char getStrobogrammatic(char c) {
			return c == '6' ? '9' : c == '9' ? '6' : c;
		}

	}

}
