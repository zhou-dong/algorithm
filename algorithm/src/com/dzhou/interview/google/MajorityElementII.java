package com.dzhou.interview.google;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 229. Majority Element II
 * 
 * Difficulty: Medium
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times. The algorithm should run in linear time and in O(1) space
 * 
 * Hint: How many majority elements could it possibly have?
 * 
 * @author zhoudong
 *
 */
public class MajorityElementII {

	public List<Integer> majorityElement(int[] nums) {

		if (nums == null || nums.length == 0)
			return Collections.emptyList();

		List<Integer> result = new LinkedList<>();

		int x = 0, y = 0;
		int count1 = 0, count2 = 0;

		for (int num : nums) {
			if (num == x) {
				count1++;
			} else if (num == y) {
				count2++;
			} else if (count1 == 0) {
				x = num;
				count1++;
			} else if (count2 == 0) {
				y = num;
				count2++;
			} else {
				count1--;
				count2--;
			}
		}

		int check1 = 0, check2 = 0;
		for (int num : nums) {
			if (num == x) {
				check1++;
			} else if (num == y) {
				check2++;
			}
		}
		if (check1 > (nums.length / 3)) {
			result.add(x);
		}
		if (check2 > (nums.length / 3)) {
			result.add(y);
		}
		return result;
	}

}
