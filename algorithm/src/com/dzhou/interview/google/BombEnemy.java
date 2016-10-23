package com.dzhou.interview.google;

/**
 * 361. Bomb Enemy
 * 
 * Difficulty: Medium
 * 
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0'
 * (the number zero), return the maximum enemies you can kill using one bomb.
 * 
 * The bomb kills all the enemies in the same row and column from the planted
 * point until it hits the wall since the wall is too strong to be destroyed.
 * 
 * Note that you can only put the bomb at an empty cell.
 * 
 * Example:
 * 
 * For the given grid
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

	public int maxKilledEnemies(char[][] grid) {
		int max = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (!isEmpty(grid, row, col)) {
					continue;
				}
				int count = 0;
				for (int[] direction : directions) {
					count += countEnemy(grid, row, col, direction);
				}
				max = Math.max(max, count);
			}
		}
		return max;
	}

	private int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	private int countEnemy(char[][] grid, int row, int col, int[] direction) {
		int count = 0;
		while (isValid(grid, row, col) && !isWall(grid, row, col)) {
			if (isEnemy(grid, row, col)) {
				count++;
			}
			row += direction[0];
			col += direction[1];
		}
		return count;
	}

	private boolean isEmpty(char[][] grid, int row, int col) {
		return grid[row][col] == '0';
	}

	private boolean isEnemy(char[][] grid, int row, int col) {
		return grid[row][col] == 'E';
	}

	private boolean isWall(char[][] grid, int row, int col) {
		return grid[row][col] == 'W';
	}

	private boolean isValid(char[][] grid, int row, int col) {
		return row >= 0 && col >= 0 && row < grid.length && col < grid[row].length;
	}

}
