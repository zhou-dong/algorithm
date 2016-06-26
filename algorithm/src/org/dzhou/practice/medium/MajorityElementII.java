package org.dzhou.practice.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 * 
 * Hint: How many majority elements could it possibly have?
 * 
 * @author zhoudong
 *
 */
public class MajorityElementII {

	public class Solution {

		public List<Integer> majorityElement(int[] nums) {

			if (nums == null || nums.length == 0)
				return Collections.emptyList();

			List<Integer> result = new LinkedList<>();
			if (nums.length < 2) {
				for (int n : nums)
					result.add(n);
				return result;
			}

			int x = nums[0], y = 0;
			int c1 = 1, c2 = 0;

			for (int i = 1; i < nums.length; i++) {
				int n = nums[i];
				if (x == n) {
					c1++;
				} else if (y == n) {
					c2++;
				} else if (c1 == 0) {
					x = n;
					c1 = 1;
				} else if (c2 == 0) {
					y = n;
					c2 = 1;
				} else {
					c1--;
					c2--;
				}
			}

			c1 = 0;
			c2 = 0;
			for (int n : nums) {
				if (x == n)
					c1++;
				else if (y == n)
					c2++;
			}

			if (c1 > nums.length / 3)
				result.add(x);
			if (c2 > nums.length / 3)
				result.add(y);
			return result;
		}

	}

}
