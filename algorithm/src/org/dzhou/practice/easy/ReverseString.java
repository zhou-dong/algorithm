package org.dzhou.practice.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Write a function that takes a string as input and returns the string
 * reversed.
 * 
 * Example: Given s = "hello", return "olleh".
 * 
 * @author DONG ZHOU
 *
 */
public class ReverseString {

	// method one
	public static class CopyFromBackToFrontSolution {
		public String reverseString(String s) {
			char[] result = new char[s.length()];
			for (int i = 0; i < result.length; i++)
				result[i] = s.charAt(result.length - 1 - i);
			return new String(result);
		}
	}

	// method two
	public static class TwoPointerSolution {
		public String reverseString(String s) {
			char[] result = s.toCharArray();
			for (int left = 0, right = result.length - 1; left < right; left++, right--)
				swap(result, left, right);
			return new String(result);
		}

		private void swap(char[] chars, int x, int y) {
			char temp = chars[x];
			chars[x] = chars[y];
			chars[y] = temp;
		}
	}

	// method three
	public static class StackSolution {
		public String reverseString(String s) {
			Stack<Character> stack = new Stack<>();
			for (char c : s.toCharArray())
				stack.add(c);
			char[] result = new char[stack.size()];
			for (int i = 0; i < result.length; i++)
				result[i] = stack.pop();
			return new String(result);
		}
	}

	public static class RecursionFrontToEndSolution {

		public String reverseString(String s) {
			char[] result = new char[s.length()];
			dfs(s, result, 0);
			return new String(result);
		}

		private void dfs(String s, char[] result, int index) {
			if (index < result.length) {
				result[index] = s.charAt(s.length() - 1 - index);
				dfs(s, result, index + 1);
			}
		}

	}

	public static class RecursionEndToFrontSolution {

		public String reverseString(String s) {
			char[] result = new char[s.length()];
			dfs(s, result, 0);
			return new String(result);
		}

		private void dfs(String s, char[] result, int index) {
			if (index < result.length) {
				dfs(s, result, index + 1);
				result[result.length - 1 - index] = s.charAt(index);
			}
		}

	}

	public static class RecursionFromMiddleSolution {

		public String reverseString(String s) {
			char[] result = s.toCharArray();
			dfs(result, result.length / 2);
			return new String(result);
		}

		private void dfs(char[] result, int index) {
			if (index < result.length) {
				dfs(result, index + 1);
				swap(result, index, result.length - index - 1);
			}
		}

		private void swap(char[] chars, int x, int y) {
			char temp = chars[x];
			chars[x] = chars[y];
			chars[y] = temp;
		}

	}

	// method seven
	public static class LinkedListAsStackSolution {
		public String reverseString(String s) {
			LinkedList<Character> list = new LinkedList<>();
			for (char c : s.toCharArray())
				list.add(c);
			char[] result = new char[list.size()];
			for (int i = 0; i < result.length; i++)
				result[i] = list.pollLast();
			return new String(result);
		}
	}

	// method eight
	public static class LinkedListSolution {
		public String reverseString(String s) {
			LinkedList<Character> list = new LinkedList<>();
			for (char c : s.toCharArray())
				list.add(c);
			Collections.reverse(list);
			char[] result = new char[list.size()];
			for (int i = 0; i < result.length; i++)
				result[i] = list.get(i);
			return new String(result);
		}
	}

	public static class StringBuilderSolution {
		public String reverseString(String s) {
			return new StringBuilder(s).reverse().toString();
		}
	}

	public static class RecursionAndSwapSolution {

		public String reverseString(String s) {
			char[] input = s.toCharArray();
			dfs(input, 0);
			return new String(input);
		}

		private void dfs(char[] input, int index) {
			if (index < input.length / 2) {
				swap(input, index, input.length - index - 1);
				dfs(input, index + 1);
			}
		}

		private void swap(char[] chars, int x, int y) {
			char temp = chars[x];
			chars[x] = chars[y];
			chars[y] = temp;
		}
	}
}
