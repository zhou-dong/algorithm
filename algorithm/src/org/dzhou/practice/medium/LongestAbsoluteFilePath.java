package org.dzhou.practice.medium;

import java.util.Stack;

/**
 * 388. Longest Absolute File Path
 * 
 * @author zhoudong
 */
public class LongestAbsoluteFilePath {

	public static void main(String[] args) {
		String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		int i = new LongestAbsoluteFilePath().lengthLongestPath(input);
		System.out.println(i);
	}

	// "\t": tab
	// "\n": 回车
	public int lengthLongestPath(String input) {
		if (input == null || input.length() == 0 || !input.contains("."))
			return 0;

		String[] strs = input.split("\n");
		Stack<Integer> stack = new Stack<>();
		int max = 0;

		for (String s : strs) {
			int tabs = countTab(s);
			while (tabs < stack.size()) {
				stack.pop();
			}
			int chars = s.length() - tabs;
			int preLength = stack.isEmpty() ? 0 : stack.peek();
			if (s.contains(".")) {
				max = Math.max(max, preLength + chars);
			} else {
				stack.push(preLength + chars + 1);
			}
		}

		return max;
	}

	private int countTab(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == '\t') {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

	int before(String input) {

		if (input == null || input.length() == 0 || !input.contains("."))
			return 0;

		String[] list = input.split("\n");
		Stack<Integer> stack = new Stack<>();
		int current = 0, max = 0;

		for (String s : list) {
			int tabs = countTab(s);
			while (tabs < stack.size()) {
				current -= stack.pop();
			}

			int chars = s.length() - tabs;
			if (s.contains(".")) {
				max = Math.max(max, current + chars);
			} else {
				current += chars + 1;
				stack.push(chars + 1);
			}
		}
		return max;

	}
}
