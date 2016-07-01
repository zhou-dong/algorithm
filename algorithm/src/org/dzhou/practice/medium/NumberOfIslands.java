package org.dzhou.practice.medium;

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

	public class Solution {

		public int numIslands(char[][] grid) {
			if (grid == null || grid.length == 0 || grid[0].length == 0)
				return 0;
			int count = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (grid[i][j] != '1')
						continue;
					count++;
					dfs(grid, i, j);
				}
			}
			return count;
		}

		private void dfs(char[][] grid, int i, int j) {
			if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
				return;
			if (grid[i][j] != '1')
				return;
			grid[i][j] = '#';
			dfs(grid, i - 1, j);
			dfs(grid, i + 1, j);
			dfs(grid, i, j - 1);
			dfs(grid, i, j + 1);
		}

	}
}
