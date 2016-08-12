package org.dzhou.practice.medium.premium;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [lower, upper]
 * inclusive, return its missing ranges.
 * 
 * For example, <br>
 * given [0, 1, 3, 50, 75], <br>
 * lower = 0 and upper = 99,<br>
 * return ["2", "4->49", "51->74", "76->99"].
 * 
 * @author zhoudong
 *
 */
public class MissingRanges {

	public class Solution {

		public List<String> findMissingRanges(int[] nums, int lower, int upper) {
			List<String> result = new LinkedList<String>();
			// edge check
			if (nums == null || nums.length == 0) {
				result.add(range(lower, upper));
				return result;
			}
			// lower than nums[0]
			if (lower < nums[0]) {
				result.add(range(lower, nums[0] - 1));
			}
			// from nums[0]
			for (int i = 0; i < nums.length; i++) {
				int to = (i == nums.length - 1) ? upper : nums[i + 1] - 1;
				if (nums[i] < to) {
					result.add(range(nums[i] + 1, to));
				}
			}
			return result;
		}

		private String range(int from, int to) {
			return from == to ? String.valueOf(from) : from + "->" + to;
		}

	}

}
