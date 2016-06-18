package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations:
 * 
 * [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * 
 * @author zhoudong
 *
 */
public class Permutations {

	public class Solution {

		public List<List<Integer>> permute(int[] nums) {
			if (nums == null || nums.length == 0)
				return Collections.emptyList();
			List<List<Integer>> result = new ArrayList<>();
			dfs(nums, result, new ArrayList<>());
			return result;
		}

		private void dfs(int nums[], List<List<Integer>> result, List<Integer> temp) {
			if (temp.size() == nums.length) {
				result.add(new ArrayList<>(temp));
				return;
			}
			for (int i = 0; i < nums.length; i++) {
				if (temp.contains(nums[i]))
					continue;
				temp.add(nums[i]);
				dfs(nums, result, temp);
				temp.remove(temp.size() - 1); // 还原现场
			}
		}

	}

	private void test() {
		Solution instance = new Solution();
		int[] nums = { 1, 2, 3 };
		System.out.println(instance.permute(nums));
	}

	public static void main(String[] args) {
		Permutations instance = new Permutations();
		instance.test();
	}
}
