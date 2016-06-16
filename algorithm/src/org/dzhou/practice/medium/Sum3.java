package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [[-1, 0, 1],[-1, -1, 2]]
 * 
 * @author zhoudong
 *
 */
public class Sum3 {

	public class Solution {

		public List<List<Integer>> threeSum(int[] nums) {

			if (nums == null || nums.length < 3)
				return Collections.emptyList();

			Set<List<Integer>> set = new HashSet<>();
			List<List<Integer>> result = new ArrayList<>();
			Arrays.sort(nums);

			for (int i = 0; i <= nums.length - 3; i++) {

				if (i != 0 && nums[i] == nums[i - 1])
					continue;

				int low = i + 1;
				int high = nums.length - 1;
				while (low < high) {
					int sum = nums[i] + nums[low] + nums[high];
					if (sum == 0) {
						List<Integer> unit = new ArrayList<>();
						unit.add(nums[i]);
						unit.add(nums[low]);
						unit.add(nums[high]);
						if (!set.contains(unit)) {
							set.add(unit);
							result.add(unit);
						}
						low++;
						high--;
					} else if (sum < 0) {
						low++;
					} else {
						high--;
					}
				}
			}

			return result;
		}

	}

}
