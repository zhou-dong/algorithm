package org.dzhou.practice.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * 
 * Given "abcd", return "dcbabcd".
 * 
 * @author zhoudong
 *
 *         reference: https://www.youtube.com/watch?v=c4akpqTwE5g
 * 
 *         上面reference的视频，别其他的人的用文字描述的要简单多了！
 * 
 */
public class ShortestPalindrome {

	public static void main(String[] args) {
		new ShortestPalindrome().test();
	}

	void test() {
		Solution1 s = new Solution1();
		System.out.println(s.shortestPalindrome("aacecaaa"));
	}

	public class Solution1 {

		public String shortestPalindrome(String s) {
			if (s == null || s.length() == 0)
				return "";
			return null;
		}

	}

}
