package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 77. Combinations
 * 
 * Difficulty: Medium
 * 
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example,
 * 
 * If n = 4 and k = 2, a solution is:
 * 
 * [ <br>
 * --[2,4], <br>
 * --[3,4], <br>
 * --[2,3], <br>
 * --[1,2], <br>
 * --[1,3], <br>
 * --[1,4], <br>
 * ] <br>
 *
 * @author zhoudong
 *
 *         tags: Backtracking
 *
 */
public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
		if (n == 0 || k == 0)
			return Collections.emptyList();
		List<List<Integer>> result = new ArrayList<>();
		dfs(result, new ArrayList<>(), n, k, 1);
		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> item, int n, int k, int start) {
		if (item.size() == k) {
			result.add(new ArrayList<>(item));
			return;
		}
		for (int i = start; i <= n; i++) {
			item.add(i);
			dfs(result, item, n, k, i + 1);
			item.remove(item.size() - 1);
		}
	}

}
