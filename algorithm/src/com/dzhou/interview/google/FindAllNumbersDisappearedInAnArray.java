package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 448. Find All Numbers Disappeared in an Array
 * 
 * Total Accepted: 1076
 * 
 * Total Submissions: 1616
 * 
 * Difficulty: Easy
 * 
 * Contributors: yuhaowang001
 * 
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * 
 * Example:
 * 
 * Input: [4,3,2,7,8,2,3,1]
 * 
 * Output: [5,6]
 * 
 * @author zhoudong
 *
 */
public class FindAllNumbersDisappearedInAnArray {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		if (nums == null || nums.length == 0)
			return Collections.emptyList();
		List<Integer> result = new ArrayList<>();

		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		for (int num = 1; num <= nums.length; num++) {
			if (!set.contains(num)) {
				result.add(num);
			}
		}
		return result;
	}

}
