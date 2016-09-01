package org.dzhou.practice.medium;

import java.util.Stack;

/**
 * 388. Longest Absolute File Path
 * 
 * @author zhoudong
 */
public class LongestAbsoluteFilePath {

	// "\t": tab
	// "\n": 回车
	public class Solution {

		public int lengthLongestPath(String input) {
			if (input == null || input.length() == 0 || !input.contains("."))
				return 0;

			String[] list = input.split("\n");
			Stack<Integer> stack = new Stack<>();
			int curLength = 0;
			int maxLength = -1;
			for (String s : list) {
				int tabs = 0;
				while (s.charAt(tabs) == '\t') {
					tabs++;
				}
				while (tabs < stack.size()) {
					curLength -= stack.pop();
				}
				s = s.substring(tabs);
				if (s.contains(".")) {
					maxLength = Math.max(maxLength, curLength + s.length());
				} else {
					curLength += s.length() + 1;
					stack.push(s.length() + 1);
				}
			}
			return maxLength;
		}

	}

}
