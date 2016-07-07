package org.dzhou.practice.hard;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,<br>
 * Given [1,2,0] return 3,<br>
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author zhoudong
 *
 */
public class FirstMissingPositive {

	public class Solution {

		public int firstMissingPositive(int[] nums) {
			if (nums == null || nums.length == 0)
				return 1;
			// create bucket
			int[] bucket = new int[nums.length + 1];
			for (int num : nums) {
				if (num < 0 || num > nums.length)
					continue;
				bucket[num]++;
			}
			// check bucket
			int i = 1;
			for (; i < bucket.length; i++) {
				if (bucket[i] == 0)
					return i;
			}
			return i;
		}

	}

}
