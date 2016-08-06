package org.dzhou.practice.medium;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * 
 * b) Delete a character
 * 
 * c) Replace a character
 * 
 * @author zhoudong
 *
 *         reference: http://www.cnblogs.com/springfor/p/3896167.html
 * 
 */
public class EditDistance {

	public class Solution {

		public int minDistance(String word1, String word2) {
			int[][] table = createAndInitDpTable(word1.length() + 1, word2.length() + 1);
			runningDP(table, word1, word2);
			return table[word1.length()][word2.length()];
		}

		private void runningDP(int[][] table, String word1, String word2) {
			for (int row = 1; row < table.length; row++) {
				char c1 = word1.charAt(row - 1);
				for (int col = 1; col < table[row].length; col++) {
					char c2 = word2.charAt(col - 1);
					if (c1 == c2) {
						table[row][col] = table[row - 1][col - 1];
					} else {
						int replace = table[row - 1][col - 1] + 1;
						int insert = table[row - 1][col] + 1;
						int delete = table[row][col - 1] + 1;
						table[row][col] = min(replace, insert, delete);
					}
				}
			}
		}

		private int min(int a, int b, int c) {
			return Math.min(a, Math.min(b, c));
		}

		private int[][] createAndInitDpTable(int rows, int cols) {
			int[][] table = new int[rows][cols];
			table[0][0] = 0;
			for (int row = 1; row < rows; row++)
				table[row][0] = row;
			for (int col = 1; col < cols; col++)
				table[0][col] = col;
			return table;
		}

	}

}
