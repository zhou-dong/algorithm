package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * 
 * path = "/home/", => "/home"<br>
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases:
 * 
 * Did you consider the case where path = "/../"?<br>
 * In this case, you should return "/".
 * 
 * Another corner case is the path might contain multiple slashes '/' together,
 * such as "/home//foo/".<br>
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * @author zhoudong
 *
 */
public class SimplifyPath {

	public class Solution {

		public String simplifyPath(String path) {

			if (path == null || path.length() == 0)
				return "";

			List<String> list = new ArrayList<>();
			String[] paths = path.split("/+");
			for (String temp : paths) {
				if (temp.equals(".") || temp.length() == 0)
					continue;
				if (temp.equals("..")) {
					if (!list.isEmpty()) {
						list.remove(list.size() - 1);
					}
				} else {
					list.add(temp);
				}
			}

			if (list.isEmpty())
				return "/";

			StringBuilder result = new StringBuilder();
			for (String str : list)
				result.append("/").append(str);

			return result.toString();
		}

	}

}
