package org.dzhou.practice.medium;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [<br>
 * ['A','B','C','E'],<br>
 * ['S','F','C','S'],<br>
 * ['A','D','E','E']<br>
 * ]<br>
 * 
 * word = "ABCCED", -> returns true,<br>
 * word = "SEE", -> returns true,<br>
 * word = "ABCB", -> returns false.<br>
 * 
 * @author zhoudong
 *
 */
public class WordSearch {

	public class Solution {

		public boolean exist(char[][] board, String word) {
			if (word == null || word.length() == 0)
				return true;
			if (board == null || board.length == 0 || board[0].length == 0)
				return false;

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] != word.charAt(0))
						continue;
					if (find(board, i, j, word, 0))
						return true;
				}
			}

			return false;
		}

		private boolean find(char[][] board, int i, int j, String word, int start) {
			if (start == word.length())
				return true;

			if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start))
				return false;

			board[i][j] = '#'; // should remember to mark it
			boolean rst = find(board, i - 1, j, word, start + 1) || find(board, i, j - 1, word, start + 1)
					|| find(board, i + 1, j, word, start + 1) || find(board, i, j + 1, word, start + 1);
			board[i][j] = word.charAt(start); // 还原
			return rst;
		}

	}

}
