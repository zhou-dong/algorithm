package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 * @author zhoudong
 *
 */
public class SummaryRanges {

	public class Solution {

		public List<String> summaryRanges(int[] nums) {
			if (nums == null || nums.length == 0)
				Collections.emptyList();
			List<String> result = new ArrayList<>();
			int slow = 0, fast = 0;
			while (fast < nums.length) {
				if (fast + 1 < nums.length && nums[fast + 1] == nums[fast] + 1) {
					fast++;
				} else {
					if (slow == fast) {
						result.add(nums[slow] + "");
					} else {
						result.add(nums[slow] + "->" + nums[fast]);
					}
					slow = ++fast;
				}
			}
			return result;
		}
	}

}
