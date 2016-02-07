package org.dzhou.interview.recursiondynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class Parens {

	public Set<String> generateParens(int remaining) {
		Set<String> set = new HashSet<>();
		if (remaining == 0) {
			set.add("");
		} else {
			Set<String> prev = generateParens(remaining - 1);
			for (String str : prev) {
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '(') {
						String s = insertInside(str, i);
						set.add(s);
					}
				}
				set.add("()" + str);
			}
		}
		return set;
	}

	private String insertInside(String str, int leftIndex) {
		String left = str.substring(0, leftIndex + 1);
		String right = str.substring(leftIndex + 1, str.length());
		return left + "()" + right;
	}

	void addParen(List<String> list, int leftRem, int rightRem, char[] str, int count) {
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

	public List<String> generateParens2(int count) {
		char[] str = new char[count * 2];
		List<String> list = new ArrayList<>();
		addParen(list, count, count, str, 0);
		return list;
	}

	public static void main(String[] args) {
		Parens parens = new Parens();
		System.out.println(parens.generateParens(1));
		System.out.println(parens.generateParens(2));
		System.out.println(parens.generateParens(3));
		System.out.println();
		System.out.println(parens.generateParens2(1));
		System.out.println(parens.generateParens2(2));
		System.out.println(parens.generateParens2(3));
	}
}
