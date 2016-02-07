package org.dzhou.interview.recursiondynamicprogramming;

import java.util.HashSet;
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

	public static void main(String[] args) {
		Parens parens = new Parens();
		System.out.println(parens.generateParens(1));
		System.out.println(parens.generateParens(2));
		System.out.println(parens.generateParens(3));
		System.out.println(parens.generateParens(4));
	}
}
