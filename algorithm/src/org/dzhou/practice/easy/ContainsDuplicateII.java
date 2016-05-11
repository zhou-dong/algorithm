package org.dzhou.practice.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * difference between i and j is at most k.
 * 
 * @author zhoudong
 *
 */
public class ContainsDuplicateII {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k))
				return true;
			map.put(nums[i], i);
		}
		return false;
	}

	// naive approach
	public boolean containsNearbyDuplicate1(int[] nums, int k) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length && i + k >= j; j++) {
				if (nums[i] == nums[j])
					return true;
			}
		}
		return false;
	}

}
