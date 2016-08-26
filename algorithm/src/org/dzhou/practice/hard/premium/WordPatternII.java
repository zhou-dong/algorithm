package org.dzhou.practice.hard.premium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty substring in str.
 * 
 * Examples: <br>
 * 1. pattern = "abab", str = "redblueredblue" should return true. <br>
 * 2. pattern = "aaaa", str = "asdasdasdasd" should return true. <br>
 * 3.pattern = "aabb", str = "xyzabcxzyabc" should return false. <br>
 * 
 * Notes:<br>
 * You may assume both pattern and str contains only lowercase letters.
 * 
 * @author zhoudong
 *
 */
public class WordPatternII {

	public class Solution {

		Map<Character, String> map;
		Set<String> set;
		boolean res;

		public boolean wordPatternMatch(String pattern, String str) {
			// 和I中一样，Map用来记录字符和字符串的映射关系
			map = new HashMap<Character, String>();
			// Set用来记录哪些字符串被映射了，防止多对一映射
			set = new HashSet<String>();
			res = false;
			// 递归回溯
			helper(pattern, str, 0, 0);
			return res;
		}

		public void helper(String pattern, String str, int i, int j) {
			// 如果pattern匹配完了而且str也正好匹配完了，说明有解
			if (i == pattern.length() && j == str.length()) {
				res = true;
				return;
			}
			// 如果某个匹配超界了，则结束递归
			if (i >= pattern.length() || j >= str.length()) {
				return;
			}
			char c = pattern.charAt(i);
			// 尝试从当前位置到结尾的所有划分方式
			for (int cut = j + 1; cut <= str.length(); cut++) {
				// 拆出一个子串
				String substr = str.substring(j, cut);
				// 如果这个子串没有被映射过，而且当前pattern的字符也没有产生过映射
				// 则新建一对映射，并且继续递归求解
				if (!set.contains(substr) && !map.containsKey(c)) {
					map.put(c, substr);
					set.add(substr);
					helper(pattern, str, i + 1, cut);
					map.remove(c);
					set.remove(substr);
					// 如果已经有映射了，但是是匹配的，也继续求解
				} else if (map.containsKey(c) && map.get(c).equals(substr)) {
					helper(pattern, str, i + 1, cut);
				}
				// 否则跳过该子串，尝试下一种拆分
			}
		}
	}
}
