package com.dzhou.interview.twitter;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Objective: Write a function to find all the combinations of three numbers
 * that sum to zero
 * 
 * Sample input:
 * 
 * [2, 3, 1, -2, -1, 0, 2, -3, 0]
 * 
 * Sorted:
 * 
 * [-3, -2, -1, 0, 0, 1, 2, 2, 3]
 * 
 * Sample output:
 * 
 * [[0, -3, 3], [1, -3, 2], [-1, -2, 3], [0, -2, 2], [-1, 0, 1]]
 * 
 * @author zhoudong
 *
 */
public class ThreeSum {

	public Set<Set<Integer>> threeSum(int[] nums) {
		return (nums == null || nums.length < 3) ? Collections.emptySet() : binarySearchHelper(nums);
	}

	private Set<Set<Integer>> binarySearchHelper(int[] nums) {
		Arrays.sort(nums);
		Set<Set<Integer>> set = new HashSet<>();
		for (int i = 0; i < nums.length - 2; i++) {
			for (int low = i + 1, high = nums.length - 1; low < high;) {
				int sum = nums[i] + nums[low] + nums[high];
				if (sum == 0) {
					addItem(set, nums[i], nums[low], nums[high]);
					low++;
					high--;
				} else if (sum < 0) {
					low++;
				} else {
					high--;
				}
			}
		}
		return set;

	}

	private void addItem(Set<Set<Integer>> set, int x, int y, int z) {
		Set<Integer> item = new HashSet<>();
		item.add(x);
		item.add(y);
		item.add(z);
		set.add(item);
	}

}
