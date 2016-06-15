package org.dzhou.practice.medium;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * @author zhoudong
 *
 */
public class ContainerWithMostWater {

	public class Solution {

		public int maxArea(int[] height) {

			if (height == null || height.length == 0)
				return 0;

			int low = 0, high = height.length - 1, max = 0;
			while (low < high) {
				int area = (high - low) * Math.min(height[high], height[low]);
				max = Math.max(max, area);
				if (height[low] < height[high])
					low++;
				else
					high--;
			}

			return max;
		}

	}

}
