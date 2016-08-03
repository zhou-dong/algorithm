package org.dzhou.practice.hard;

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

		public int largestRectangleArea(int[] heights) {
			int index = 0, max = 0;
			Stack<Integer> stack = new Stack<>();

			while (index < heights.length) {
				if (stack.isEmpty() || heights[stack.peek()] <= heights[index]) {
					stack.push(index++);
				} else {
					int height = heights[stack.pop()];
					int width = stack.isEmpty() ? index : width(stack.peek(), index);
					max = Math.max(max, height * width);
				}
			}

			while (!stack.isEmpty()) {
				int height = heights[stack.pop()];
				int width = stack.isEmpty() ? heights.length : width(stack.peek(), heights.length);
				max = Math.max(max, height * width);
			}

			return max;
		}

		private int width(int before, int after) {
			return after - before - 1;
		}

	}

}
