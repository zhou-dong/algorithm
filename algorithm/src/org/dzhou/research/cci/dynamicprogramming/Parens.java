package org.dzhou.research.cci.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Practice of "cracking the code interview"
 * 
 * Implement an algorithm to print all valid combinations of n pairs of
 * parentheses .
 *
 * Example <br>
 * Input:3 <br>
 * output: ()()(), ()(()), (()()), (())(), ((()))
 * 
 * @author DONG ZHOU
 *
 *         Solution A: <br>
 *         1. create () <br>
 *         2. 在()的各个位置，插入() <br>
 *         Example:() <br>
 *         ()(), (()) [(()),()()]<br>
 * 
 *         Solution B:<br>
 *         从无到有以依次构造 <br>
 */
public class Parens {

	class Solution {
		public Set<String> generateParens(int remaining) {
			Set<String> set = new HashSet<>();
			if (remaining == 0) {
				set.add("");
			} else {
				for (String str : generateParens(remaining - 1)) {
					insertParens(str, set);
				}
			}
			return set;
		}

		private void insertParens(String str, Set<String> set) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					set.add(insertInside(str, i));
				}
			}
			set.add("()" + str);
		}

		private String insertInside(String str, int leftIndex) {
			String left = str.substring(0, leftIndex + 1);
			String right = str.substring(leftIndex + 1, str.length());
			return left + "()" + right;
		}
	}

	class Solution1 {
		public List<String> generateParens(int count) {
			List<String> list = new ArrayList<>();
			addParen(list, count, count, new char[count * 2], 0);
			return list;
		}

		private void addParen(List<String> list, int leftRem, int rightRem, char[] str, int count) {
			if (leftRem < 0 || rightRem < leftRem)
				return;
			if (leftRem == 0 && rightRem == 0) {
				String s = String.copyValueOf(str);
				list.add(s);
			} else {
				if (leftRem > 0) {
					str[count] = '(';
					addParen(list, leftRem - 1, rightRem, str, count + 1);
				}
				if (rightRem > leftRem) {
					str[count] = ')';
					addParen(list, leftRem, rightRem - 1, str, count + 1);
				}
			}
		}
	}

}
