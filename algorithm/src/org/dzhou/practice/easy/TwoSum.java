package org.dzhou.practice.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author zhoudong
 *
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int val = target - nums[i];
			if (map.containsKey(val) && map.get(val) != i)
				return new int[] { i, map.get(val) };
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public int[] twoSum1(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], i);
		for (int i = 0; i < nums.length; i++) {
			int val = target - nums[i];
			if (map.containsKey(val) && map.get(val) != i)
				return new int[] { i, map.get(val) };
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public int[] twoSum2(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++)
			for (int j = i + 1; j < nums.length; j++)
				if (nums[i] + nums[j] == target)
					return new int[] { i, j };
		throw new IllegalArgumentException("No two sum solution");
	}

}
