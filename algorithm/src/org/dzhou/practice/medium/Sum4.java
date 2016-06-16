package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 * 
 * @author zhoudong
 *
 */
public class Sum4 {

	public class Solution {

		public List<List<Integer>> fourSum(int[] nums, int target) {
			Set<List<Integer>> hashSet = new HashSet<List<Integer>>();
			List<List<Integer>> result = new ArrayList<>();
			Arrays.sort(nums);

			for (int i = 0; i <= nums.length - 4; i++) {
				for (int j = i + 1; j <= nums.length - 3; j++) {
					int low = j + 1;
					int high = nums.length - 1;
					while (low < high) {
						int sum = nums[i] + nums[j] + nums[low] + nums[high];
						if (sum > target) {
							high--;
						} else if (sum < target) {
							low++;
						} else if (sum == target) {
							ArrayList<Integer> temp = new ArrayList<Integer>();
							temp.add(nums[i]);
							temp.add(nums[j]);
							temp.add(nums[low]);
							temp.add(nums[high]);
							if (!hashSet.contains(temp)) {
								hashSet.add(temp);
								result.add(temp);
							}
							low++;
							high--;
						}
					}
				}
			}

			return result;
		}
	}
}
