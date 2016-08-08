package org.dzhou.practice.hard;

/***
 * Given a string which contains only lower case letters, remove duplicate
 * letters so that every letter appear once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible
 * results.
 * 
 * Example: <br>
 * Given "bcabc" <br>
 * Return "abc" <br>
 * 
 * Given "cbacdcbc" <br>
 * Return "acdb" <br>
 * 
 * @author zhoudong
 *
 *         reference: https://segmentfault.com/a/1190000004188227
 */
public class RemoveDuplicateLetters {

	public class Solution {

		public String removeDuplicateLetters(String s) {
			if (s == null || s.length() == 0)
				return s;

			// 记录每个字符出现的次数
			int[] cnt = new int[26];
			for (int i = 0; i < s.length(); i++) {
				cnt[s.charAt(i) - 'a']++;
			}

			// 找出当前最小字符
			int pos = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) < s.charAt(pos))
					pos = i;

				// 避免无字符可用
				if (--cnt[s.charAt(i) - 'a'] == 0)
					break;
			}

			// 除去字符串中已经append的字符的所有重复值
			return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
		}
	}

}
