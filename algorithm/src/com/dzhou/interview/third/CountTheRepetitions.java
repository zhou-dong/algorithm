package com.dzhou.interview.third;

/**
 * 466. Count The Repetitions
 * 
 * Difficulty: Hard
 * 
 * Define S = [s,n] as the string S which consists of n connected strings s. For
 * example, ["abc", 3] ="abcabcabc".
 * 
 * On the other hand, we define that string s1 can be obtained from string s2 if
 * we can remove some characters from s2 such that it becomes s1. For example,
 * “abc” can be obtained from “abdbec” based on our definition, but it can not
 * be obtained from “acbbe”.
 * 
 * You are given two non-empty strings s1 and s2 (each at most 100 characters
 * long) and two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106. Now consider the
 * strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer
 * M such that [S2,M] can be obtained from S1.
 * 
 * Example:
 * 
 * Input: s1="acb", n1=4 s2="ab", n2=2
 * 
 * Return: 2
 * 
 * @author zhoudong
 *
 */
public class CountTheRepetitions {

	static class Solution1 {
		public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
			char[] arr1 = repeat(s1, n1);
			char[] arr2 = repeat(s2, n2);
			if (arr1.length < arr2.length) {
				return 0;
			}
			int count = 0, y = 0;
			for (int x = 0; x < arr1.length; x++) {
				if (arr1[x] == arr2[y]) {
					y++;
				}
				if (y == arr2.length) {
					y = 0;
					count++;
				}
			}
			return count;
		}

		private char[] repeat(String s, int n) {
			char[] array = new char[s.length() * n];
			for (int i = 0; i < array.length; i++)
				array[i] = s.charAt(i % s.length());
			return array;
		}
	}

	public static void main(String[] args) {
		String s1 = "acb", s2 = "ab";
		int n1 = 4, n2 = 2;
		int count = new CountTheRepetitions.Solution1().getMaxRepetitions(s1, n1, s2, n2);
		System.out.println(count);
	}

}
