package org.dzhou.practice.hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * 327. Count of Range Sum
 * 
 * Given an integer array nums, return the number of range sums that lie in
 * [lower, upper] inclusive. Range sum S(i, j) is defined as the sum of the
 * elements in nums between indices i and j (i ≤ j), inclusive.
 * 
 * Note: A naive algorithm of O(n2) is trivial. You MUST do better than that.
 * 
 * Example:
 * 
 * Given nums = [-2, 5, -1], lower = -2, upper = 2,
 * 
 * Return 3.
 * 
 * The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are:
 * -2, -1, 2.
 * 
 * @author zhoudong
 *
 */
public class CountOfRangeSum {

	public class Solution {

		public int countRangeSum(int[] nums, int lower, int upper) {
			if (nums == null || nums.length == 0)
				return 0;
			int count = 0;
			long[] sum = new long[nums.length + 1];
			TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
			map.put(0L, 1);
			for (int i = 0; i < nums.length; i++) {
				sum[i + 1] = sum[i] + nums[i];
				map.put(sum[i + 1], map.containsKey(sum[i + 1]) ? map.get(sum[i + 1]) + 1 : 1);
			}
			for (int i = 0; i < nums.length; i++) {
				map.put(sum[i], map.get(sum[i]) - 1);
				if (map.get(sum[i]) == 0)
					map.remove(sum[i]);
				for (Map.Entry<Long, Integer> entry : map.subMap(sum[i] + lower, sum[i] + upper + 1).entrySet())
					count += entry.getValue();
			}
			return count;
		}

	}

	// naive solution
	public class Solution1 {
		public int countRangeSum(int[] nums, int lower, int upper) {
			if (nums == null || nums.length == 0)
				return 0;
			int count = 0;
			for (int i = 0; i < nums.length; i++) {
				long sum = 0;
				for (int j = i; j < nums.length; j++) {
					sum += nums[j];
					if (sum <= upper && sum >= lower) {
						count++;
					}
				}
			}
			return count;
		}
	}

}
