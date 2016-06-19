package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 
 * For example:
 * 
 * given: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 
 * Return: [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ]
 * 
 * Note: All inputs will be in lower-case.
 * 
 * @author zhoudong
 *
 */
public class GroupAnagrams {

	public class Solution {

		public List<List<String>> groupAnagrams(String[] strs) {
			if (strs == null || strs.length == 0)
				return Collections.emptyList();

			List<List<String>> result = new ArrayList<>();
			Map<String, List<String>> map = new HashMap<>();

			for (String str : strs) {
				char[] temp = str.toCharArray();
				Arrays.sort(temp);
				String key = new String(temp);
				if (!map.containsKey(key))
					map.put(key, new ArrayList<>());
				map.get(key).add(str);
			}

			for (Map.Entry<String, List<String>> entry : map.entrySet()) {
				result.add(entry.getValue());
			}

			return result;
		}

	}

}
