package com.dzhou.interview.google;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * You are given a listing of directories and files in a file system. Each
 * directory and file has a name, which is a non-empty string consisting of
 * alphanumerical characters. Additionally, the name of each file contains a
 * single dot character; the part of the name starting with the dot is called
 * the extension. Directory names do not contain any dots. All the names are
 * case-sensitive.
 * 
 * Each entry is listed on a separate line. Every directory is followed by the
 * listing of its contents indented by one space character. The contents of the
 * root directory are not indented.
 * 
 * Here is a sample listing:
 * 
 * dir1 <br>
 * -dir11 <br>
 * -dir12 <br>
 * --picture.jpeg <br>
 * --dir121 <br>
 * --file1.txt <br>
 * dir2 <br>
 * -file2.gif <br>
 * 
 * We have three files (picture.jpeg, file1.txt, and file2.gif) and six
 * directories (dir1, dir11, dir12, dir121, dir2 and the root directory).
 * Directory dir12 contains two files (picture.jpeg and file1.txt) and an empty
 * directory (dir121). The root directory contains two directories (dir1 and
 * dir2).
 * 
 * The absolute path of a file is a string containing the names of directories
 * which have to be traversed (from the root directory) to reach the file,
 * separated by slash characters. For example, the absolute path to the file
 * file1.txt is "/dir1/dir12/file1.txt". Note that there is no "drive letter",
 * such as "C:", and each absolute path starts with a slash.
 * 
 * We are interested in image files only; that is, files with extensions.jpeg,
 * .png or .gif (and only these extensions). We are looking for the total length
 * of all the absolute paths leading to the image files. For example, in the
 * file system described above there are two image
 * files:"/dir1/dir12/picture.jpge" and "/dir2/file2.gif". The total length of
 * the absolute paths to these files is 24 + 15 = 39.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); }
 * 
 * that, given a string S consisting of N characters which contain the listing
 * of a file system, returns the total of lengths (in characters) modulo
 * 1,000,000,0007 of all the absolute paths to the image files.
 * 
 * For example, given the sample listing showed above, the function should
 * return 39, as explained above. If there are no image files, the function
 * should return 0.
 * 
 * Assume that:
 * 
 * N is an integer within the range[1..3,000,000];
 * 
 * string S consists only of alphanumerical characters (a-z and/or A-Z and/or
 * 0-9), spaces, dots (.) and end-of-line characters;
 * 
 * string S is a correct listing of a file system contents.
 * 
 * Complexity:
 * 
 * expected worst-case time complexity is O(N);
 * 
 * expected worst-case space complexity is O(N) (not counting the storage
 * required for input arguments).
 * 
 * @author zhoudong
 * 
 */
public class TotalImageFilePath {

	Set<String> imageExtensions = null;

	public int solution(String s) {
		createImageExtensions();
		Stack<Integer> stack = new Stack<>();
		String[] entrys = s.split("\n");
		int total = 0;
		for (String entry : entrys) {
			int spaceCount = countSpace(entry);
			while (spaceCount < stack.size()) {
				stack.pop();
			}
			int noSpaceLength = entry.length() - spaceCount;
			int preLength = stack.isEmpty() ? 1 : stack.peek();
			if (isDirectory(entry)) {
				stack.push(noSpaceLength + preLength + 1);
			} else if (isImage(entry)) {
				total += preLength + noSpaceLength;
			}
		}
		return total;
	}

	private int countSpace(String entry) {
		int count = 0;
		for (char c : entry.toCharArray()) {
			if (c != ' ')
				return count;
			else
				count++;
		}
		return count;
	}

	private void createImageExtensions() {
		imageExtensions = new HashSet<>();
		imageExtensions.add("jpeg");
		imageExtensions.add("png");
		imageExtensions.add("gif");
	}

	private boolean isDirectory(String str) {
		return str.indexOf(".") == -1;
	}

	private boolean isImage(String file) {
		int dotIndex = file.indexOf(".");
		if (dotIndex == -1)
			return false;
		String extension = file.substring(dotIndex + 1);
		return imageExtensions.contains(extension);
	}

}
