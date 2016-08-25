package org.dzhou.practice.medium.premium;

/**
 * 361. Bomb Enemy
 * 
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0'
 * (the number zero), return the maximum enemies you can kill using one bomb.
 * 
 * The bomb kills all the enemies in the same row and column from the planted
 * point until it hits the wall since the wall is too strong to be destroyed.
 * 
 * Note that you can only put the bomb at an empty cell.
 * 
 * For the given grid <br>
 * 
 * 0 E 0 0 <br>
 * E 0 W E <br>
 * 0 E 0 0 <br>
 * 
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 * 
 * @author zhoudong
 *
 */
public class BombEnemy {

	public class Solution {
		public int maxKilledEnemies(char[][] grid) {
			int m = grid.length;
			int n = m > 0 ? grid[0].length : 0;

			int result = 0, rows = 0;
			int[] cols = new int[n];
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					if (j == 0 || grid[i][j - 1] == 'W') {
						rows = 0;
						for (int k = j; k < n && grid[i][k] != 'W'; ++k)
							if (grid[i][k] == 'E')
								rows += 1;
					}
					if (i == 0 || grid[i - 1][j] == 'W') {
						cols[j] = 0;
						for (int k = i; k < m && grid[k][j] != 'W'; ++k)
							if (grid[k][j] == 'E')
								cols[j] += 1;
					}

					if (grid[i][j] == '0' && rows + cols[j] > result)
						result = rows + cols[j];
				}
			}
			return result;
		}
	}

}
