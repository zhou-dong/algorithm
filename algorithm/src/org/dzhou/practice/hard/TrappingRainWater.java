package org.dzhou.practice.hard;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author zhoudong
 *
 */
public class TrappingRainWater {

	public class Solution {

		public int trap(int[] height) {

			if (height == null || height.length < 3)
				return 0;

			int[] left = new int[height.length];
			int[] right = new int[height.length];

			int leftMax = 0;
			for (int i = 1; i < height.length; i++) {
				left[i] = Math.max(leftMax, height[i - 1]);
				leftMax = Math.max(leftMax, left[i]);
			}

			int rightMax = 0;
			for (int i = height.length - 2; i >= 0; i--) {
				right[i] = Math.max(rightMax, height[i + 1]);
				rightMax = Math.max(rightMax, right[i]);
			}

			int sum = 0;
			for (int i = 1; i < height.length; i++) {
				int val = Math.min(left[i], right[i]) - height[i];
				sum += val > 0 ? val : 0;
			}
			return sum;
		}

	}

}
