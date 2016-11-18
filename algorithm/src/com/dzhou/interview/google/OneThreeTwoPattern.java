package com.dzhou.interview.google;

import java.util.Map;
import java.util.TreeMap;

/**
 * 456. 132 Pattern
 * 
 * Difficulty: Medium
 * 
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a
 * subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an
 * algorithm that takes a list of n numbers as input and checks whether there is
 * a 132 pattern in the list.
 * 
 * Note: n will be less than 15,000.
 * 
 * Example 1: Input: [1, 2, 3, 4]
 * 
 * Output: False
 * 
 * Explanation: There is no 132 pattern in the sequence.
 * 
 * Example 2: Input: [3, 1, 4, 2]
 * 
 * Output: True
 * 
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * 
 * Example 3: Input: [-1, 3, 2, 0]
 * 
 * Output: True
 * 
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1,
 * 3, 0] and [-1, 2, 0].
 * 
 * @author zhoudong
 *
 *         参考的： http://bookshadow.com/weblog/2016/11/13/leetcode-132-pattern/
 * 
 *         上面链接的想法太帮了！
 */
public class OneThreeTwoPattern {

	public static class BruteForce_Solution {

		public boolean find132pattern(int[] nums) {
			for (int i = 0; i < nums.length - 2; i++) {
				for (int j = i + 1; j < nums.length - 1; j++) {
					if (nums[i] < nums[j]) {
						for (int k = j + 1; k < nums.length; k++) {
							if (nums[j] > nums[k] && nums[k] > nums[i]) {
								return true;
							}
						}
					}
				}
			}
			return false;
		}

	}

	public class TreeMap_Solution {
		public boolean find132pattern(int[] nums) {
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
			for (int num : nums) {
				increase(treeMap, num);
			}

			int min = Integer.MAX_VALUE;
			for (int num : nums) {
				decrease(treeMap, num);
				if (num <= min) {
					min = num;
				} else {
					Integer target = treeMap.higherKey(min);
					if (target != null && target < num) {
						return true;
					}
				}
			}
			return false;
		}

		private void increase(Map<Integer, Integer> map, int key) {
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		private void decrease(Map<Integer, Integer> map, int key) {
			int value = map.get(key);
			if (value == 1) {
				map.remove(key);
			} else {
				map.put(key, value - 1);
			}
		}
	}

}
