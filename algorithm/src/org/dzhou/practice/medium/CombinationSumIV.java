package org.dzhou.practice.medium;

/**
 * Given an integer array with all positive numbers and no duplicates, find the
 * number of possible combinations that add up to a positive integer target.
 * 
 * Example:
 * 
 * nums = [1, 2, 3] <br>
 * target = 4 <br>
 * 
 * The possible combination ways are: <br>
 * (1, 1, 1, 1) <br>
 * (1, 1, 2) <br>
 * (1, 2, 1) <br>
 * (1, 3) <br>
 * (2, 1, 1) <br>
 * (2, 2) <br>
 * (3, 1) <br>
 * 
 * Note that different sequences are counted as different combinations.
 * 
 * Therefore the output is 7. <br>
 * 
 * Follow up:<br>
 * What if negative numbers are allowed in the given array? <br>
 * How does it change the problem? <br>
 * What limitation we need to add to the question to allow negative numbers?
 * <br>
 * 
 * @author zhoudong
 *
 */
public class CombinationSumIV {

	// DP Solution
	// 首先想到了递归的解法，结果TLE了，然后实在想不来了，google了网上的解法。
	// 这道题，其实就是“爬梯的那道题，只是问的方法不一样了！”
	public class Solution {
		public int combinationSum4(int[] nums, int target) {
			int[] dp = new int[target + 1];
			dp[0] = 1;
			for (int i = 1; i < dp.length; i++) {
				for (int num : nums) {
					if (i >= num) {
						dp[i] += dp[i - num];
					}
				}
			}
			return dp[target];
		}
	}

	// Time Limit Exceeded
	// Recursive Solution
	public class Solution1 {
		int count = 0;

		public int combinationSum4(int[] nums, int target) {
			helper(nums, target, 0);
			return count;
		}

		private void helper(int[] nums, int target, int current) {
			if (current >= target) {
				if (current == target)
					count++;
				return;
			}
			for (int num : nums) {
				helper(nums, target, num + current);
			}
		}
	}

}
