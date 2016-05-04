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
	public static String reverseString(String s) {
		char[] result = new char[s.length()];
		for (int i = 0; i < result.length; i++)
			result[i] = s.charAt(result.length - 1 - i);
		return new String(result);
	}

	// method two
	public static String reverseStringFromBothSide(String s) {
		char[] result = s.toCharArray();
		for (int left = 0, right = result.length - 1; left < right; left++, right--)
			swap(result, left, right);
		return new String(result);
	}

	private static void swap(char[] chars, int x, int y) {
		char temp = chars[x];
		chars[x] = chars[y];
		chars[y] = temp;
	}

	// method three
	public static String reverseStringByStack(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray())
			stack.add(c);
		char[] result = new char[stack.size()];
		for (int i = 0; i < result.length; i++)
			result[i] = stack.pop();
		return new String(result);
	}

	// method four
	public static String reverseStringByRecursionFrontEnd(String s) {
		char[] input = s.toCharArray();
		char[] result = new char[input.length];
		reverseStringByRecursionFrontEnd(input, result, 0);
		return new String(result);
	}

	private static void reverseStringByRecursionFrontEnd(char[] input, char[] result, int index) {
		if (index < input.length) {
			result[index] = input[input.length - 1 - index];
			reverseStringByRecursionFrontEnd(input, result, index + 1);
		}
	}

	// method five
	public static String reverseStringByRecursionEndFront(String s) {
		char[] input = s.toCharArray();
		char[] result = new char[input.length];
		reverseStringByRecursionEndFront(input, result, 0);
		return new String(result);
	}

	private static void reverseStringByRecursionEndFront(char[] input, char[] result, int index) {
		if (index < input.length) {
			reverseStringByRecursionEndFront(input, result, index + 1);
			result[result.length - 1 - index] = input[index];
		}
	}

	// method six
	public static String reverseStringByRecursionFromHalf(String s) {
		char[] input = s.toCharArray();
		reverseStringByRecursionFromHalf(input, 0, input.length / 2);
		return new String(input);
	}

	private static void reverseStringByRecursionFromHalf(char[] input, int index, int half) {
		if (index < input.length) {
			reverseStringByRecursionFromHalf(input, index + 1, half);
			if (index > half)
				swap(input, index, input.length - index - 1);
		}
	}

	// method seven
	public static String reverseStringByStringBuilder(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	// method eight
	public static String reverseStringByLinkedList(String s) {
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
