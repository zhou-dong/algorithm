package org.dzhou.practice.medium;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * 
 * A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * @author zhoudong
 *
 */
public class JumpGame {

	public class Solution {

		public boolean canJump(int[] nums) {
			int max = 0, i = 0;
			for (i = 0; i <= max && i < nums.length; i++) {
				max = Math.max(max, nums[i] + i);
			}
			return i == nums.length;
		}

	}

}
