package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations:
 * 
 * [ [1,1,2], [1,2,1], [2,1,1] ]
 * 
 * @author zhoudong
 * 
 */
public class PermutationsII {

	public class Solution {

		public List<List<Integer>> permuteUnique(int[] nums) {
			if (nums == null || nums.length == 0)
				return Collections.emptyList();
			List<List<Integer>> result = new ArrayList<>();
			Arrays.sort(nums);
			dfs(nums, result, new ArrayList<>(), new boolean[nums.length]);
			return result;
		}

		private void dfs(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] used) {
			if (temp.size() == nums.length) {
				result.add(new ArrayList<>(temp));
				return;
			}
			for (int i = 0; i < nums.length; i++) {
				if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1])
					continue;
				if (!used[i]) {
					used[i] = true;
					temp.add(nums[i]);
					dfs(nums, result, temp, used);
					temp.remove(temp.size() - 1);
					used[i] = false;
				}
			}
		}

	}
}
