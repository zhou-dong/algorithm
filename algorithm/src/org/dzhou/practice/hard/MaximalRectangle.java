package org.dzhou.practice.hard;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0 <br>
 * 1 0 1 1 1 <br>
 * 1 1 1 1 1 <br>
 * 1 0 0 1 0 <br>
 * 
 * Return 6.
 * 
 * @author zhoudong
 *
 */
public class MaximalRectangle {

	public class Solution {

		public int maximalRectangle(char[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
				return 0;
			int[][] heightTable = createHeightTable(matrix);
			int max = 0;
			for (int[] row : heightTable) {
				max = Math.max(max, largestRectangleArea(row));
			}
			return max;
		}

		private int[][] createHeightTable(char[][] matrix) {
			int[][] result = new int[matrix.length][matrix[0].length];
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix[row].length; col++) {
					if (matrix[row][col] == '0') {
						result[row][col] = 0;
					} else {
						result[row][col] = (row == 0) ? 1 : result[row - 1][col] + 1;
					}
				}
			}
			return result;
		}

		private int largestRectangleArea(int[] heights) {
			int max = 0, index = 0;
			Stack<Integer> stack = new Stack<>();
			while (index < heights.length) {
				if (stack.isEmpty() || heights[stack.peek()] < heights[index]) {
					stack.push(index++);
				} else {
					int area = calculateArea(stack, heights, index);
					max = Math.max(max, area);
				}
			}
			while (!stack.isEmpty()) {
				int area = calculateArea(stack, heights, heights.length);
				max = Math.max(max, area);
			}
			return max;
		}

		private int calculateArea(Stack<Integer> stack, int[] heights, int after) {
			int height = heights[stack.pop()];
			int width = stack.isEmpty() ? after : calculateWidth(stack.peek(), after);
			return height * width;
		}

		private int calculateWidth(int before, int after) {
			return after - before - 1;
		}
	}

}
