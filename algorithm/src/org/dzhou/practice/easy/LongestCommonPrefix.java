package org.dzhou.practice.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * @author zhoudong
 *
 */
public class LongestCommonPrefix {

	public class Solution {
		public String longestCommonPrefix(String[] strs) {
			if (strs == null || strs.length == 0)
				return "";
			int len = minLen(strs);
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < len; i++) {
				for (int j = 1; j < strs.length; j++) {
					if (strs[0].charAt(i) != strs[j].charAt(i))
						return result.toString();
				}
				result.append(strs[0].charAt(i));
			}
			return result.toString();
		}

		private int minLen(String[] strs) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < strs.length; i++)
				min = Math.min(min, strs[i].length());
			return min;
		}
	}

	public class Solution1 {
		public String longestCommonPrefix(String[] strs) {
			if (strs == null || strs.length == 0)
				return "";
			for (int i = 0; i < strs[0].length(); i++) {
				for (int j = 1; j < strs.length; j++) {
					if (strs[j].length() == i || strs[0].charAt(i) != strs[j].charAt(i))
						return strs[0].substring(0, i);
				}
			}
			return strs[0];
		}
	}

}
