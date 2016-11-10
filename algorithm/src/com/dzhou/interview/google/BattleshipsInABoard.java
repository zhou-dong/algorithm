package com.dzhou.interview.google;

/**
 * 419. Battleships in a Board
 * 
 * Difficulty: Medium
 * 
 * Given an 2D board, count how many different battleships are in it. The
 * battleships are represented with 'X's, empty slots are represented with '.'s.
 * You may assume the following rules:
 * 
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words,
 * they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1
 * column), where N can be of any size. At least one horizontal or vertical cell
 * separates between two battleships - there are no adjacent battleships.
 * 
 * @author zhoudong
 *
 */
public class BattleshipsInABoard {

	public int countBattleships(char[][] board) {
		int count = 0;
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (!isBattleship(board, row, col)) {
					continue;
				}
				if (isBattleship(board, toLeft(row, col))) {
					continue;
				}
				if (isBattleship(board, toUp(row, col))) {
					continue;
				}
				count++;
			}
		}
		return count;
	}

	private boolean isBattleship(char[][] board, int[] slot) {
		return isBattleship(board, slot[0], slot[1]);
	}

	private boolean isBattleship(char[][] board, int row, int col) {
		return isInBoard(board, row, col) && board[row][col] == 'X';
	}

	private int[] toLeft(int row, int col) {
		return new int[] { row, col - 1 };
	}

	private int[] toUp(int row, int col) {
		return new int[] { row - 1, col };
	}

	private boolean isInBoard(char[][] board, int row, int col) {
		return row >= 0 && col >= 0 && row < board.length && col < board[0].length;
	}

}
