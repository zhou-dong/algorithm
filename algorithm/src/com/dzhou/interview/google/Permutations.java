package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. Permutations
 * 
 * Difficulty: Medium
 * 
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example, <br>
 * [1,2,3] have the following permutations: <br>
 * [ <br>
 * --[1,2,3], <br>
 * --[1,3,2], <br>
 * --[2,1,3], <br>
 * --[2,3,1], <br>
 * --[3,1,2], <br>
 * --[3,2,1] <br>
 * ] <br>
 * 
 * @author zhoudong
 *
 */
public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0)
			return Collections.emptyList();
		List<List<Integer>> result = new ArrayList<>();
		dfs(nums, result, new ArrayList<>());
		return result;
	}

	private void dfs(int[] nums, List<List<Integer>> result, List<Integer> item) {
		if (item.size() == nums.length) {
			result.add(new ArrayList<>(item));
			return;
		}
		for (int num : nums) {
			if (item.contains(num)) {
				continue;
			}
			item.add(num);
			dfs(nums, result, item);
			item.remove(item.size() - 1);
		}
	}

}
