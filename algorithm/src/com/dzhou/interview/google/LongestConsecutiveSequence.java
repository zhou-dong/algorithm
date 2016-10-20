package com.dzhou.interview.google;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * 
 * Difficulty: Hard
 * 
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author zhoudong
 *
 */
public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		int max = 1;

		for (int num : nums) {
			if (!set.contains(num)) {
				continue;
			}

			int count = 1;
			set.remove(num);
			int temp = num + 1;
			while (set.contains(temp)) {
				count++;
				set.remove(temp++);
			}
			temp = num - 1;
			while (set.contains(temp)) {
				count++;
				set.remove(temp--);
			}

			max = Math.max(max, count);
		}

		return max;
	}

}
