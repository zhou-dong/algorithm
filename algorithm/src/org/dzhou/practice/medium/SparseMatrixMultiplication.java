package org.dzhou.practice.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two sparse matrices A and B, return the result of AB.
 * 
 * You may assume that A's column number is equal to B's row number.
 * 
 * Example:
 * 
 * A = [ <br>
 * --[ 1, 0, 0], <br>
 * --[-1, 0, 3] <br>
 * ] <br>
 * 
 * B = [ <br>
 * --[ 7, 0, 0 ], <br>
 * --[ 0, 0, 0 ], <br>
 * --[ 0, 0, 1 ] <br>
 * ] <br>
 * 
 * @author zhoudong
 *
 *         reference:
 *         http://buttercola.blogspot.com/2016/01/leetcode-sparse-matrix-
 *         multiplication.html
 */
public class SparseMatrixMultiplication {

	public class Solution {

		public int[][] multiply(int[][] A, int[][] B) {

			int[][] C = new int[A.length][B[0].length];

			// Step 1: convert the sparse A to dense format
			Map<Integer, Map<Integer, Integer>> denseA = denseMatrix(A);

			// Step 2: convert the sparse B to dense format
			Map<Integer, Map<Integer, Integer>> denseB = denseMatrix(B);

			// Step3: calculate the denseA * denseB
			multiply(denseA, denseB, C);
			return C;
		}

		private Map<Integer, Map<Integer, Integer>> denseMatrix(int[][] matrix) {
			Map<Integer, Map<Integer, Integer>> result = new HashMap<>();
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (matrix[i][j] == 0)
						continue;
					if (!result.containsKey(i))
						result.put(i, new HashMap<>());
					result.get(i).put(j, matrix[i][j]);
				}
			}
			return result;
		}

		private void multiply(Map<Integer, Map<Integer, Integer>> denseA, Map<Integer, Map<Integer, Integer>> denseB,
				int[][] C) {
			for (int i : denseA.keySet()) {
				for (int j : denseA.get(i).keySet()) {
					if (!denseB.containsKey(j))
						continue;
					for (int k : denseB.get(j).keySet()) {
						C[i][k] += denseA.get(i).get(j) * denseB.get(j).get(k);
					}
				}
			}
		}
	}

	// Time Limit Exceeded
	public class Solution1 {

		public int[][] multiply(int[][] A, int[][] B) {
			int[][] result = new int[A.length][B[0].length];
			for (int row = 0; row < result.length; row++) {
				for (int col = 0; col < result[row].length; col++) {
					result[row][col] = multiply(A[row], col(B, col));
				}
			}
			return result;
		}

		private int multiply(int[] row, int[] col) {
			int sum = 0;
			for (int i = 0; i < row.length; i++) {
				if (row[i] != 0 && col[i] != 0)
					sum += row[i] * col[i];
			}
			return sum;
		}

		private int[] col(int[][] matrix, int col) {
			int[] result = new int[matrix.length];
			for (int i = 0; i < result.length; i++) {
				result[i] = matrix[i][col];
			}
			return result;
		}
	}

}
