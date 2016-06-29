package org.dzhou.practice.medium;

/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example, There is one obstacle in the middle of a 3x3 grid as illustrated
 * below.
 * 
 * [<br>
 * [0,0,0],<br>
 * [0,1,0],<br>
 * [0,0,0]<br>
 * ]<br>
 * 
 * The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 * 
 * @author zhoudong
 *
 *
 *         reference: http://www.cnblogs.com/springfor/p/3886644.html
 */
public class UniquePathsII {

	public class Solution {

		public int uniquePathsWithObstacles(int[][] obstacleGrid) {

			int row = obstacleGrid.length;
			int col = obstacleGrid[0].length;

			if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1)
				return 0;

			int[][] dp = new int[row][col];
			dp[0][0] = 1;

			// 只有一行时，到终点每个格子只有一种走法
			for (int i = 1; i < col; i++) {
				if (obstacleGrid[0][i] == 1)
					dp[0][i] = 0;
				else
					dp[0][i] = dp[0][i - 1];
			}

			// 只有一列时，到终点每个格子只有一种走法
			for (int j = 1; j < row; j++) {
				if (obstacleGrid[j][0] == 1)
					dp[j][0] = 0;
				else
					dp[j][0] = dp[j - 1][0];
			}

			// for each node, number of path = paths from top + paths from left
			for (int i = 1; i < row; i++) {
				for (int j = 1; j < col; j++) {
					if (obstacleGrid[i][j] == 1)
						dp[i][j] = 0;
					else
						dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				}
			}

			return dp[row - 1][col - 1];
		}

	}

}
