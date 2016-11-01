package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow
 * 
 * Difficulty: Medium
 * 
 * Given an m x n matrix of non-negative integers representing the height of
 * each unit cell in a continent, the "Pacific ocean" touches the left and top
 * edges of the matrix and the "Atlantic ocean" touches the right and bottom
 * edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a cell
 * to another one with height equal or lower.
 * 
 * Find the list of grid coordinates where water can flow to both the Pacific
 * and Atlantic ocean.
 * 
 * Note:
 * 
 * The order of returned grid coordinates does not matter.
 * 
 * Both m and n are less than 150.
 * 
 * @author zhoudong
 *
 */
public class PacificAtlanticWaterFlow {

	public List<int[]> pacificAtlantic(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return Collections.emptyList();
		}

		boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
		boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];

		for (int col = 0; col < matrix[0].length; col++) {
			flow(matrix, pacific, 0, col);
			flow(matrix, atlantic, matrix.length - 1, col);
		}

		for (int row = 0; row < matrix.length; row++) {
			flow(matrix, pacific, row, 0);
			flow(matrix, atlantic, row, matrix[0].length - 1);
		}

		List<int[]> result = new ArrayList<>();
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (pacific[row][col] && atlantic[row][col]) {
					result.add(new int[] { row, col });
				}
			}
		}
		return result;
	}

	private void flow(int[][] matrix, boolean[][] visited, int row, int col) {
		visited[row][col] = true;
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextCol = col + direction[1];
			if (!isValid(matrix, nextRow, nextCol)) {
				continue;
			}
			if (visited[nextRow][nextCol]) {
				continue;
			}
			if (matrix[row][col] <= matrix[nextRow][nextCol]) {
				flow(matrix, visited, nextRow, nextCol);
			}
		}
	}

	private int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	private boolean isValid(int[][] matrix, int row, int col) {
		return row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length;
	}
}
