package org.dzhou.practice.medium;

/**
 * 289. Game of Life
 * 
 * Difficulty: Medium
 * 
 * According to the Wikipedia's article:
 * "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal, vertical,
 * diagonal) using the following four rules (taken from the above Wikipedia
 * article):
 * 
 * 1.Any live cell with fewer than two live neighbors dies, as if caused by
 * under-population.
 * 
 * 2.Any live cell with two or three live neighbors lives on to the next
 * generation.
 * 
 * 3.Any live cell with more than three live neighbors dies, as if by
 * over-population..
 * 
 * 4.Any dead cell with exactly three live neighbors becomes a live cell, as if
 * by reproduction.
 * 
 * Write a function to compute the next state (after one update) of the board
 * given its current state.
 * 
 * Follow up:
 * 
 * Could you solve it in-place? Remember that the board needs to be updated at
 * the same time: You cannot update some cells first and then use their updated
 * values to update other cells.
 * 
 * In this question, we represent the board using a 2D array. In principle, the
 * board is infinite, which would cause problems when the active area encroaches
 * the border of the array. How would you address these problems?
 * 
 * @author zhoudong
 *
 *         reference: http://www.cnblogs.com/grandyang/p/4854466.html
 *
 *         我们可以使用状态机转换：<br>
 *         状态0： 死细胞转为死细胞<br>
 *         状态1： 活细胞转为活细胞<br>
 *         状态2： 活细胞转为死细胞<br>
 *         状态3： 死细胞转为活细胞<br>
 * 
 *         最后我们对所有状态对2取余，那么状态0和2就变成死细胞，状态1和3就是活细胞，达成目的。我们先对原数组进行逐个扫描，对于每一个位置，
 *         扫描其周围八个位置，如果遇到状态1或2，就计数器累加1，扫完8个邻居，如果少于两个活细胞或者大于三个活细胞，而且当前位置是活细胞的话，
 *         标记状态2，如果正好有三个活细胞且当前是死细胞的话，标记状态3。完成一遍扫描后再对数据扫描一遍，对2取余变成我们想要的结果。
 */
public class GameOfLife {

	public void gameOfLife(int[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				int neighbors = countLiveNeighbors(board, row, col);
				if (board[row][col] == 0 && neighbors == 3) {
					board[row][col] = 3;
				}
				if (board[row][col] == 1 && (neighbors < 2 || neighbors > 3)) {
					board[row][col] = 2;
				}
			}
		}
		update(board);
	}

	// 最后我们对所有状态对2取余，那么状态0和2就变成死细胞，状态1和3就是活细胞，达成目的。
	private void update(int[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				board[row][col] %= 2;
			}
		}
	}

	int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	private int countLiveNeighbors(int[][] board, int row, int col) {
		int count = 0;
		for (int[] direction : directions) {
			int x = row + direction[0];
			int y = col + direction[1];
			if (!isValid(board, x, y)) {
				continue;
			}
			if (isAlive(board, x, y)) {
				count++;
			}
		}
		return count;
	}

	private boolean isAlive(int[][] board, int row, int col) {
		return board[row][col] == 1 || board[row][col] == 2;
	}

	private boolean isValid(int[][] board, int row, int col) {
		return row >= 0 && col >= 0 && row < board.length && col < board[0].length;
	}

}
