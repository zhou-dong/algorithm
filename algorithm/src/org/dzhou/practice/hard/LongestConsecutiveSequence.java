package org.dzhou.practice.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, <br>
 * Given [100, 4, 200, 1, 3, 2], <br>
 * The longest consecutive elements sequence is [1, 2, 3, 4]. <br>
 * Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author zhoudong
 *
 */
public class LongestConsecutiveSequence {

	public class Solution {
		public int longestConsecutive(int[] nums) {
			Set<Integer> set = createSet(nums);
			int max = 0;
			for (int i : nums) {
				if (!set.contains(i))
					continue;
				set.remove(i);
				int count = 1;
				int temp = i;
				while (set.contains(++temp)) {
					set.remove(temp);
					count++;
				}
				temp = i;
				while (set.contains(--temp)) {
					set.remove(temp);
					count++;
				}
				max = Math.max(max, count);
			}
			return max;
		}

		private Set<Integer> createSet(int[] nums) {
			Set<Integer> set = new HashSet<>();
			for (int num : nums)
				set.add(num);
			return set;
		}
	}

}
