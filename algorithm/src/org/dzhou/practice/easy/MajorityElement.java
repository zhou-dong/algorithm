package org.dzhou.practice.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * @author zhoudong
 *
 */
public class MajorityElement {

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int half = nums.length / 2;
		for (int x : nums) {
			if (map.containsKey(x))
				map.put(x, map.get(x) + 1);
			else
				map.put(x, 1);
			if (map.get(x) > half)
				return x;
		}
		throw new NoSuchElementException();
	}

	public int majorityElement1(int[] nums) {
		int hold = Integer.MIN_VALUE;
		int half = nums.length / 2;
		for (int i = 0; i < half; i++) {
			if (nums[i] == hold)
				continue;
			int diffIndex = findDifferent(nums, i, hold);
			if (diffIndex == nums.length)
				break;
			nums[i] = hold;
			nums[diffIndex] = hold;
		}
		for (int x : nums) {
			if (x != hold)
				return x;
		}
		throw new NoSuchElementException();
	}

	private int findDifferent(int[] nums, int index, int hold) {
		for (int i = index + 1; i < nums.length; i++) {
			if (nums[i] == hold)
				continue;
			if (nums[i] != nums[index])
				return i;
		}
		return nums.length;
	}

}
