package org.dzhou.practice.hard;

/**
 * Given an integer matrix, find the length of the longest increasing path.
 * 
 * From each cell, you can either move to four directions: left, right, up or
 * down. You may NOT move diagonally or move outside of the boundary (i.e.
 * wrap-around is not allowed).
 * 
 * Example 1: <br>
 * nums = [ <br>
 * [9,9,4], <br>
 * [6,6,8], <br>
 * [2,1,1] <br>
 * ] <br>
 * Return 4 <br>
 * The longest increasing path is [1, 2, 6, 9].
 * 
 * Example 2: <br>
 * nums = [ <br>
 * [3,4,5], <br>
 * [3,2,6], <br>
 * [2,2,1] <br>
 * ] <br>
 * Return 4 <br>
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not
 * allowed.
 * 
 * @author zhoudong
 *
 */
public class LongestIncreasingPathInAMatrix {

	public class Solution {
		public int longestIncreasingPath(int[][] matrix) {
			if (matrix.length == 0)
				return 0;
			int max = 0;
			int[][] distance = new int[matrix.length][matrix[0].length];
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix[row].length; col++) {
					max = Math.max(max, dfs(matrix, distance, row, col));
				}
			}
			return max;
		}

		private int dfs(int[][] matrix, int[][] distance, int row, int col) {
			if (distance[row][col] != 0)
				return distance[row][col];
			for (int[] next : Direction.nexts(row, col)) {
				int nextRow = next[0];
				int nextCol = next[1];
				if (isValid(matrix, row, col, nextRow, nextCol)) {
					distance[row][col] = Math.max(distance[row][col], dfs(matrix, distance, nextRow, nextCol));
				}
			}
			return ++distance[row][col];
		}

		private boolean isValid(int[][] matrix, int row, int col, int nextRow, int nextCol) {
			return isValidLaction(matrix, nextRow, nextCol) && isIncrease(matrix, row, col, nextRow, nextCol);
		}

		private boolean isIncrease(int[][] matrix, int row, int col, int nextRow, int nextCol) {
			return matrix[row][col] < matrix[nextRow][nextCol];
		}

		private boolean isValidLaction(int[][] matrix, int row, int col) {
			return row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length;
		}
	}

	// Time Limit Exceeded
	public class Solution1 {
		int max = 0;

		public int longestIncreasingPath(int[][] matrix) {
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix[row].length; col++) {
					dfs(matrix, new boolean[matrix.length][matrix[row].length], row, col, 1);
				}
			}
			return max;
		}

		private void dfs(int[][] matrix, boolean[][] visited, int row, int col, int count) {
			max = Math.max(max, count);
			for (int[] next : Direction.nexts(row, col)) {
				int nextRow = next[0];
				int nextCol = next[1];
				if (!isValid(matrix, visited, nextRow, nextCol))
					continue;
				if (isIncrease(matrix, row, col, nextRow, nextCol)) {
					visited[nextRow][nextCol] = true;
					dfs(matrix, visited, nextRow, nextCol, count + 1);
					visited[nextRow][nextCol] = false;
				}
			}
		}

		private boolean isIncrease(int[][] matrix, int row, int col, int nextRow, int nextCol) {
			return matrix[row][col] < matrix[nextRow][nextCol];
		}

		private boolean isValid(int[][] matrix, boolean[][] visited, int row, int col) {
			return isValidLaction(matrix, row, col) && !visited[row][col];
		}

		private boolean isValidLaction(int[][] matrix, int row, int col) {
			return row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length;
		}
	}

	enum Direction {
		LEFT {
			@Override
			int[] next(int row, int col) {
				return new int[] { row, col - 1 };
			}
		},
		RIGHT {
			@Override
			int[] next(int row, int col) {
				return new int[] { row, col + 1 };
			}
		},
		UP {
			@Override
			int[] next(int row, int col) {
				return new int[] { row - 1, col };
			}
		},
		DOWN {
			@Override
			int[] next(int row, int col) {
				return new int[] { row + 1, col };
			}
		};
		abstract int[] next(int row, int col);

		public static int[][] nexts(int row, int col) {
			Direction[] directions = Direction.values();
			int[][] result = new int[directions.length][2];
			for (int i = 0; i < directions.length; i++) {
				result[i] = directions[i].next(row, col);
			}
			return result;
		}
	}

}
