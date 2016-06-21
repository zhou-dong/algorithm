package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example, If nums = [1,2,2], a solution is:
 * 
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * @author zhoudong
 *
 */
public class SubsetsII {

	public class Solution {

		public List<List<Integer>> subsetsWithDup(int[] nums) {

			if (nums == null || nums.length == 0)
				return Collections.emptyList();

			List<List<Integer>> result = new ArrayList<List<Integer>>();
			result.add(new ArrayList<>());

			Arrays.sort(nums);
			for (int i = 1; i < nums.length + 1; i++) {
				dfs(nums, result, new ArrayList<>(), 0, i);
			}

			return result;
		}

		private void dfs(int[] nums, List<List<Integer>> result, List<Integer> item, int start, int len) {
			if (item.size() == len) {
				if (!result.contains(item))
					result.add(new ArrayList<>(item));
				return;
			}
			for (int i = start; i < nums.length; i++) {
				item.add(nums[i]);
				dfs(nums, result, item, i + 1, len);
				item.remove(item.size() - 1);
			}
		}

	}

}
