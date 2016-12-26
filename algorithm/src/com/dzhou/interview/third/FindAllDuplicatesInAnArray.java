package com.dzhou.interview.third;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 * 
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements
 * appear twice and others appear once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 * 
 * Example:
 * 
 * Input: [4,3,2,7,8,2,3,1]
 * 
 * Output: [2,3]
 * 
 * @author zhoudong
 *
 */
public class FindAllDuplicatesInAnArray {

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();
		for (int num : nums) {
			int abs = Math.abs(num);
			if (nums[abs - 1] < 0) {
				result.add(abs);
			} else {
				nums[abs - 1] *= -1;
			}
		}
		return result;
	}

}
