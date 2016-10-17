package com.dzhou.interview.google;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 求到 包含image文件的 文件夹的最长路径
 * 
 * @author zhoudong
 *
 */
public class LongestDirectoryPath {

	public String solution(String input) {
		initImageExtensions();
		String[] entrys = input.split("\n");
		String maxDirectory = "";
		Stack<String> stack = new Stack<>();
		for (String entry : entrys) {
			int countSpace = countSpace(entry);
			while (countSpace < stack.size()) {
				stack.pop();
			}
			String prev = stack.isEmpty() ? "/" : stack.peek();
			String name = entry.substring(countSpace);
			if (isDirectory(entry)) {
				stack.push(prev + name + "/");
			} else if (isImage(entry)) {
				if (prev.length() > maxDirectory.length()) {
					maxDirectory = prev;
				}
			}
		}
		return maxDirectory;
	}

	Set<String> imageExtensions = null;

	private void initImageExtensions() {
		imageExtensions = new HashSet<>();
		imageExtensions.add("jpeg");
		imageExtensions.add("png");
		imageExtensions.add("gif");
	}

	private boolean isImage(String entry) {
		if (isDirectory(entry))
			return false;
		String extension = entry.substring(entry.indexOf(".") + 1);
		return imageExtensions.contains(extension);
	}

	private boolean isDirectory(String entry) {
		return entry.indexOf(".") == -1;
	}

	private int countSpace(String entry) {
		int count = 0;
		for (char c : entry.toCharArray()) {
			if (c == ' ')
				count++;
			else
				return count;
		}
		return count;
	}

}
