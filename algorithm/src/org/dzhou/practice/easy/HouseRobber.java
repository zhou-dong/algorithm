package org.dzhou.practice.easy;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author zhoudong
 *
 */
public class HouseRobber {

	public int rob(int[] nums) {
		if (nums.length < 2) {
			return nums.length == 0 ? 0 : nums[0];
		}
		int x = nums[0];
		int y = Math.max(x, nums[1]);
		for (int i = 2; i < nums.length; i++) {
			int temp = y;
			y = Math.max(y, x + nums[i]);
			x = temp;
		}
		return y;
	}

}
