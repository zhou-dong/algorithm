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
			int[][] result = new int[4][2];
			for (int i = 0; i < directions.length; i++) {
				result[i] = directions[i].next(row, col);
			}
			return result;
		}
	}

	// Time Limit Exceeded
	public class Solution {

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

	public class Solution1 {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		public int longestIncreasingPath(int[][] matrix) {
			if (matrix.length == 0)
				return 0;
			int m = matrix.length, n = matrix[0].length;
			int[][] dis = new int[m][n];
			int ans = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					ans = Math.max(ans, dfs(i, j, m, n, matrix, dis));
				}
			}
			return ans;
		}

		int dfs(int x, int y, int m, int n, int[][] matrix, int[][] dis) {
			if (dis[x][y] != 0)
				return dis[x][y];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < m && ny < n && matrix[nx][ny] > matrix[x][y]) {
					dis[x][y] = Math.max(dis[x][y], dfs(nx, ny, m, n, matrix, dis));
				}
			}
			return ++dis[x][y];
		}
	}
}
