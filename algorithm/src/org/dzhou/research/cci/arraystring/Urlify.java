package org.dzhou.research.cci.arraystring;

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume
 * that the String has sufficient space at the end to hold the additional
 * characters, and that you are given the "true" length of the string.
 *
 * 重点是: 从后往前构建新的string.
 * 
 * @author zhoudong
 *
 */
public class Urlify {

	public class Solution {

		void replaceSpaces(char[] str, int length) {
			int newLength = length + spaceCount(str) * 2;
			str[newLength] = '\0';
			for (int i = length - 1; i >= 0; i--) {
				if (str[i] != ' ') {
					str[--newLength] = str[i];
				} else {
					str[--newLength] = '0';
					str[--newLength] = '2';
					str[--newLength] = '%';
				}
			}
		}

		private int spaceCount(char[] str) {
			int count = 0;
			for (char c : str) {
				if (c == ' ')
					count++;
			}
			return count;
		}

	}

}
