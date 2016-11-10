package com.dzhou.interview.google;

/**
 * 453. Minimum Moves to Equal Array Elements
 * 
 * Difficulty: Easy
 * 
 * Given a non-empty integer array of size n, find the minimum number of moves
 * required to make all array elements equal, where a move is incrementing n - 1
 * elements by 1.
 * 
 * Example:
 * 
 * Input: [1,2,3]
 * 
 * Output: 3
 * 
 * Explanation: Only three moves are needed (remember each move increments two
 * elements):
 * 
 * [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4]
 * 
 * @author zhoudong
 *
 */
public class MinimumMovesToEqualArrayElements {

	// 一次移动将n - 1个元素加1，等价于将剩下的1个元素减1。
	// 就相当于计算所有元素和最小元素之间的差值
	class Solution1 {
		public int minMoves(int[] nums) {
			int count = 0;
			int min = min(nums);
			for (int num : nums) {
				count += (num - min);
			}
			return count;
		}

		private int min(int[] nums) {
			int min = nums[0];
			for (int i = 1; i < nums.length; i++)
				min = Math.min(min, nums[i]);
			return min;
		}
	}

	class Solution2 {
		public int minMoves(int[] nums) {
			return sum(nums) - min(nums) * nums.length;
		}

		private int sum(int[] nums) {
			int sum = 0;
			for (int num : nums)
				sum += num;
			return sum;
		}

		public int min(int[] nums) {
			int min = nums[0];
			for (int i = 1; i < nums.length; i++)
				min = Math.min(min, nums[i]);
			return min;
		}
	}

	// 一次移动将n - 1个元素加1，等价于将剩下的1个元素减1。
	class Brute_Force_Solution {
		public int minMoves(int[] nums) {
			int count = 0;
			while (true) {
				if (isAllEqual(nums))
					return count;
				nums[findMaxIndex(nums)]--;
				count++;
			}
		}

		private int findMaxIndex(int[] nums) {
			int index = 0, max = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] > max) {
					max = nums[i];
					index = i;
				}
			}
			return index;
		}

		private boolean isAllEqual(int[] nums) {
			int first = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] != first) {
					return false;
				}
			}
			return true;
		}
	}

}
