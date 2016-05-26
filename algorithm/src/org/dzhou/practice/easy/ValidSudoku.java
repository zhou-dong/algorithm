package org.dzhou.practice.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * A partially filled sudoku which is valid.
 * 
 * Note:
 * 
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the
 * filled cells need to be validated.
 * 
 * @author zhoudong
 *
 */
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		if (board == null || board.length != 9 || board[0].length != 9)
			return false;

		Set<Character> set = new HashSet<>();

		// check for row
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c == '.')
					continue;
				if (set.contains(c))
					return false;
				set.add(c);
			}
			set.clear();
		}

		// check for column
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = board[j][i];
				if (c == '.')
					continue;
				if (set.contains(c))
					return false;
				set.add(c);
			}
			set.clear();
		}

		// check for each sub-grid
		for (int k = 0; k < 9; k++) {
			for (int i = k / 3 * 3; i < k / 3 * 3 + 3; i++) {
				for (int j = (k % 3) * 3; j < (k % 3) * 3 + 3; j++) {
					char c = board[i][j];
					if (c == '.')
						continue;
					if (set.contains(c))
						return false;
					set.add(c);
				}
			}
			set.clear();
		}

		return true;
	}

}
