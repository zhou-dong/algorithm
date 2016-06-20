package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example, If nums = [1,2,3], a solution is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * @author zhoudong
 *
 */
public class Subsets {

	public class Solution {

		public List<List<Integer>> subsets(int[] nums) {
			if (nums == null || nums.length == 0)
				return Collections.emptyList();

			List<List<Integer>> result = new ArrayList<>();
			List<Integer> item = new ArrayList<>();
			result.add(item);

			// call combination k times which is from 1 to k + 1
			for (int k = 1; k < nums.length + 1; k++) {
				dfs(nums, result, item, k, 0);
			}

			return result;
		}

		private void dfs(int[] nums, List<List<Integer>> result, List<Integer> item, int k, int start) {
			if (item.size() == k) {
				result.add(new ArrayList<>(item));
				return;
			}
			for (int i = start; i < nums.length; i++) {
				item.add(nums[i]);
				dfs(nums, result, item, k, i + 1);
				item.remove(item.size() - 1);
			}
		}

	}

}
