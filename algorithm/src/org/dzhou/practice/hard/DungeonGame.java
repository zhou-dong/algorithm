package org.dzhou.practice.hard;

/**
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health (negative
 * integers) upon entering these rooms; other rooms are either empty (0's) or
 * contain magic orbs that increase the knight's health (positive integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * 
 * Write a function to determine the knight's minimum initial health so that he
 * is able to rescue the princess.
 * 
 * For example, given the dungeon below, the initial health of the knight must
 * be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * 
 * -2 (K) -3 3 <br>
 * -5 -10 1 <br>
 * 10 30 -5 (P) <br>
 * 
 * Notes:
 * 
 * 
 * The knight's health has no upper bound.
 * 
 * Any room can contain threats or power-ups, even the first room the knight
 * enters and the bottom-right room where the princess is imprisoned.
 * 
 * @author zhoudong
 *
 */
public class DungeonGame {

	public class Solution {

		public int calculateMinimumHP(int[][] dungeon) {
			if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
				return -1;

			int rowLen = dungeon.length;
			int colLen = dungeon[0].length;

			int[][] dp = new int[rowLen][colLen];
			dp[rowLen - 1][colLen - 1] = Math.max(1 - dungeon[rowLen - 1][colLen - 1], 1);

			// last row
			for (int col = colLen - 2; col >= 0; col--) {
				dp[rowLen - 1][col] = Math.max(dp[rowLen - 1][col + 1] - dungeon[rowLen - 1][col], 1);
			}

			// last col
			for (int row = rowLen - 2; row >= 0; row--) {
				dp[row][colLen - 1] = Math.max(dp[row + 1][colLen - 1] - dungeon[row][colLen - 1], 1);
			}

			// DP function
			for (int row = rowLen - 2; row >= 0; row--) {
				for (int col = colLen - 2; col >= 0; col--) {
					int right = Math.max(dp[row][col + 1] - dungeon[row][col], 1);
					int down = Math.max(dp[row + 1][col] - dungeon[row][col], 1);
					dp[row][col] = Math.min(right, down);
				}
			}
			return dp[0][0];
		}

	}

}
