package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @author zhoudong
 * 
 *         使用DFS遍历
 */
public class RestoreIPAddresses {

	public class Solution {

		public List<String> restoreIpAddresses(String s) {
			if (s == null || s.length() < 4 || s.length() > 12)
				return Collections.emptyList();
			List<String> result = new ArrayList<>();
			dfs(s, result, "", 0);
			return result;
		}

		private void dfs(String s, List<String> result, String item, int start) {
			if (start == 3 && isValid(s)) {// 第4段
				result.add(item + s);
				return;
			}
			for (int i = 0; i < 3 && i < s.length(); i++) {
				String sub = s.substring(0, i + 1);
				if (!isValid(sub))
					continue;
				dfs(s.substring(i + 1, s.length()), result, item + sub + ".", start + 1);
			}

		}

		private boolean isValid(String s) {
			if (s == null || s.length() == 0)
				return false;
			if (s.charAt(0) == '0')
				return s.length() == 1;
			int val = Integer.parseInt(s);
			return val > 0 && val <= 255;
		}

	}

}
