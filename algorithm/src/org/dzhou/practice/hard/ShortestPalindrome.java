package org.dzhou.practice.hard;

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

	public class Solution {

		public String shortestPalindrome(String s) {

			String reverse = new StringBuilder(s).reverse().toString();

			String join = s + "#" + reverse;

			int[] position = new int[join.length()];

			for (int i = 0; i < join.length(); i++) {

			}

			return reverse.substring(0, position[position.length - 1]) + s;
		}

		private void kmp() {

		}
	}

}
