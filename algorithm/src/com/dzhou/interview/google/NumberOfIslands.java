package com.dzhou.interview.google;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:<br>
 * 11110<br>
 * 11010<br>
 * 11000<br>
 * 00000<br>
 * Answer: 1
 * 
 * Example 2:<br>
 * 11000<br>
 * 11000<br>
 * 00100<br>
 * 00011<br>
 * Answer: 3
 * 
 * @author zhoudong
 *
 */
public class NumberOfIslands {

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int sum = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (isUnvisitedIsland(grid, visited, row, col)) {
					dfs(grid, visited, row, col);
					sum++;
				}
			}
		}
		return sum;
	}

	int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
		if (!isValid(grid, row, col) || !isUnvisitedIsland(grid, visited, row, col)) {
			return;
		}
		visited[row][col] = true;
		for (int[] direction : directions) {
			dfs(grid, visited, row + direction[0], col + direction[1]);
		}
	}

	private boolean isUnvisitedIsland(char[][] grid, boolean[][] visited, int row, int col) {
		return grid[row][col] == '1' && visited[row][col] == false;
	}

	private boolean isValid(char[][] grid, int row, int col) {
		return row >= 0 && col >= 0 && row < grid.length && col < grid[row].length;
	}

}
