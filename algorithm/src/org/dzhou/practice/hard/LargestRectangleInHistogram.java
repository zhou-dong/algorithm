package org.dzhou.practice.hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * For example, Given heights = [2,1,5,6,2,3], return 10.
 * 
 * @author zhoudong
 *
 */
public class LargestRectangleInHistogram {

	public class Solution {

		public int largestRectangleArea(int[] height) {
			int area = 0;
			Stack<Integer> stack = new Stack<Integer>();
			for (int i = 0; i < height.length; i++) {
				if (stack.empty() || height[stack.peek()] < height[i]) {
					stack.push(i);
				} else {
					int start = stack.pop();
					int width = stack.empty() ? i : i - stack.peek() - 1;
					area = Math.max(area, height[start] * width);
					i--;
				}
			}
			while (!stack.empty()) {
				int start = stack.pop();
				int width = stack.empty() ? height.length : height.length - stack.peek() - 1;
				area = Math.max(area, height[start] * width);
			}
			return area;
		}

	}

	public class Solution1 {

		public int largestRectangleArea(int[] height) {
			Stack<Integer> stack = new Stack<Integer>();
			int i = 0;
			int maxArea = 0;
			int[] h = new int[height.length + 1];
			h = Arrays.copyOf(height, height.length + 1);
			while (i < h.length) {
				if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
					stack.push(i++);
				} else {
					int t = stack.pop();
					maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
				}
			}
			return maxArea;
		}

	}

}
