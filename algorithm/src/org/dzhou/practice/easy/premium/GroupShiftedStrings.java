package org.dzhou.practice.easy.premium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * 
 * "abc" -> "bcd" -> ... -> "xyz" Given a list of strings which contains only
 * lowercase alphabets, group all strings that belong to the same shifting
 * sequence.
 * 
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], A
 * solution is:
 * 
 * [ <br>
 * ---["abc","bcd","xyz"], <br>
 * ---["az","ba"], <br>
 * ---["acef"], <br>
 * ---["a","z"] <br>
 * ] <br>
 * 
 * @author zhoudong
 *
 */
public class GroupShiftedStrings {

	public class Solution {

		public List<List<String>> groupStrings(String[] strings) {
			Map<String, List<String>> map = keyStringsMap(strings);
			return fetchFromMap(map);
		}

		private List<List<String>> fetchFromMap(Map<String, List<String>> map) {
			List<List<String>> result = new ArrayList<>();
			for (List<String> list : map.values())
				result.add(list);
			return result;
		}

		private Map<String, List<String>> keyStringsMap(String[] strings) {
			Map<String, List<String>> map = new HashMap<>();
			for (String string : strings) {
				String key = calculateKey(string);
				if (map.containsKey(key)) {
					map.get(key).add(string);
				} else {
					List<String> list = new ArrayList<>();
					list.add(string);
					map.put(key, list);
				}
			}
			return map;
		}

		private String calculateKey(String string) {
			StringBuilder key = new StringBuilder();
			for (int i = 1; i < string.length(); i++) {
				int distance = distance(string.charAt(i), string.charAt(i - 1));
				key.append(distance);
			}
			return key.toString();
		}

		private int distance(char x, char y) {
			return ((x - y) + 26) % 26;
		}

	}

}
