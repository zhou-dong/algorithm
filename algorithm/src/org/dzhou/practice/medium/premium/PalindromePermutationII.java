package org.dzhou.practice.medium.premium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, return all the palindromic permutations (without
 * duplicates) of it. Return an empty list if no palindromic permutation could
 * be form.
 * 
 * For example: <br>
 * Given s = "aabb", return ["abba", "baab"]. <br>
 * Given s = "abc", return []. <br>
 * 
 * Hint: <br>
 * 1.If a palindromic permutation exists, we just need to generate the first
 * half of the string.<br>
 * 2.To generate all distinct permutations of a (half of) string, use a similar
 * approach from: Permutations II or Next Permutation.
 * 
 * @author zhoudong
 *
 */
public class PalindromePermutationII {

	Map<Character, Integer> map = new HashMap<>();
	Character mid = null;
	int length = 0;

	public List<String> generatePalindromes(String s) {
		if (!isPalindromePermutation(s))
			return Collections.emptyList();
		length = s.length();
		List<Character> half = findHalfs();
		Set<String> halfResult = new HashSet<>();
		dfs(half, halfResult, new StringBuilder(), new boolean[half.size()]);
		return buildFromHalf(halfResult);
	}

	private List<String> buildFromHalf(Set<String> halfResult) {
		List<String> result = new ArrayList<>();
		for (String str : halfResult) {
			char[] chars = new char[length];
			int i = 0;
			for (; i < str.length(); i++) {
				chars[i] = str.charAt(i);
				chars[length - i - 1] = str.charAt(i);
			}
			if (mid != null)
				chars[i] = mid;
			result.add(new String(chars));
		}
		return result;
	}

	private void dfs(List<Character> chars, Set<String> result, StringBuilder item, boolean[] visited) {
		if (item.length() == chars.size()) {
			result.add(item.toString());
			return;
		}
		for (int i = 0; i < chars.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				item.append(chars.get(i));
				dfs(chars, result, item, visited);
				visited[i] = false;
				item.deleteCharAt(item.length() - 1);
			}
		}
	}

	private List<Character> findHalfs() {
		List<Character> result = new ArrayList<>();
		for (char c : map.keySet()) {
			if (map.get(c) % 2 == 1)
				mid = c;
			int count = map.get(c) / 2;
			for (int i = 0; i < count; i++) {
				result.add(c);
			}
		}
		return result;
	}

	private boolean isPalindromePermutation(String s) {
		for (char c : s.toCharArray()) {
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}
		int oddCount = 0;
		for (int count : map.values()) {
			if (count % 2 == 1) {
				if (oddCount > 0)
					return false;
				oddCount++;
			}
		}
		return true;
	}

}
