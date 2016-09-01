package org.dzhou.practice.medium;

import java.util.Stack;

/**
 * 388. Longest Absolute File Path
 * 
 * "\t": tab
 * 
 * "\n": 回车
 * 
 * @author zhoudong
 */
public class LongestAbsoluteFilePath {

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

}
