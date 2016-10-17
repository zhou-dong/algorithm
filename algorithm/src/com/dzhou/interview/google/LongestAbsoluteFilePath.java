package com.dzhou.interview.google;

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
		Stack<Integer> stack = new Stack<>();
		String[] entrys = input.split("\n");
		int max = 0;
		for (String entry : entrys) {
			int countTab = countTab(entry);
			while (countTab < stack.size()) {
				stack.pop();
			}
			int preLength = stack.isEmpty() ? 0 : stack.peek();
			int noTabLength = entry.length() - countTab;
			if (isDirectory(entry)) {
				stack.push(preLength + noTabLength + 1);
			} else {
				max = Math.max(max, preLength + noTabLength);
			}
		}
		return max;
	}

	private boolean isDirectory(String entry) {
		return entry.indexOf(".") == -1;
	}

	private int countTab(String entry) {
		int count = 0;
		for (char c : entry.toCharArray()) {
			if (c == '\t') {
				count++;
			} else
				return count;
		}
		return count;
	}

}
