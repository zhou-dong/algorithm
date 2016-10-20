package com.dzhou.interview.google;

import java.util.Stack;

/**
 * 394. Decode String
 * 
 * Difficulty: Medium
 * 
 * Given an encoded string, return it's decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * 
 * s = "3[a2[c]]", return "accaccacc".
 * 
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * @author zhoudong
 *
 */
public class DecodeString {

	class Solution {
		public String decodeString(String s) {
			Stack<String> items = new Stack<>();
			Stack<Integer> counts = new Stack<>();
			StringBuilder item = new StringBuilder();
			int count = 0;
			for (char ch : s.toCharArray()) {
				if (Character.isDigit(ch)) {
					count = count * 10 + (ch - '0');
					if (item.length() != 0) {
						items.add(item.toString());
						item = new StringBuilder();
					}
				} else if (ch == '[') {
					counts.add(count);
					count = 0;
				} else if (ch == ']') {
					String prev = items.isEmpty() ? "" : items.pop();
					StringBuilder temp = new StringBuilder(prev);
					int size = counts.pop();
					for (int i = 0; i < size; i++) {
						temp.append(item);
					}
					item = temp;
				} else {
					item.append(ch);
				}
			}
			return item.toString();
		}
	}

	class Solution1 {
		public String decodeString(String s) {
			StringBuilder item = new StringBuilder();
			Stack<String> items = new Stack<>();
			Stack<Integer> counts = new Stack<>();

			int index = 0;
			while (index < s.length()) {
				char ch = s.charAt(index);
				if (Character.isDigit(ch)) {
					int count = 0;
					while (Character.isDigit(s.charAt(index))) {
						count = count * 10 + (s.charAt(index) - '0');
						index++;
					}
					counts.push(count);
				} else if (ch == '[') {
					items.push(item.toString());
					item = new StringBuilder();
					index++;
				} else if (ch == ']') {
					StringBuilder temp = new StringBuilder(items.pop());
					int count = counts.pop();
					for (int i = 0; i < count; i++) {
						temp.append(item);
					}
					item = temp;
					index++;
				} else {
					item.append(ch);
					index++;
				}
			}

			return item.toString();
		}
	}

}
