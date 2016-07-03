package org.dzhou.practice.medium;

/**
 * Increasing Triplet Subsequence
 * 
 * Given an unsorted array return whether an increasing subsequence of length 3
 * exists or not in the array.
 * 
 * Formally the function should: Return true if there exists i, j, k such that
 * arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false. Your
 * algorithm should run in O(n) time complexity and O(1) space complexity.
 * 
 * Examples:
 * 
 * Given [1, 2, 3, 4, 5], return true.
 * 
 * Given [5, 4, 3, 2, 1], return false.
 * 
 * @author zhoudong
 *
 *         reference:
 *         https://www.hrwhisper.me/leetcode-increasing-triplet-subsequence/
 * 
 *         不断的缩小x1和x2，看看是否有第三个数 比x2大。
 */
public class IncreasingTripletSubsequence {

	public class Solution {

		// 1. 保证x1 < x2
		// 2. x1, x2 不断缩小
		// 3. 是否有第3个数，大于它们
		public boolean increasingTriplet(int[] nums) {
			int x1 = Integer.MAX_VALUE, x2 = Integer.MAX_VALUE;
			for (int num : nums) {
				if (num <= x1)
					x1 = num;
				else if (num <= x2)
					x2 = num;
				else
					return true;
			}
			return false;
		}

	}

}
