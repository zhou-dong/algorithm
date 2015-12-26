package org.dzhou.interview.arrays;

/**
 * Write an algorithm such that if an element in an M * N matrix is 0, it's
 * entire row and column are set to 0.
 * 
 * @author DONG ZHOU
 *
 */
public class ZeroMatrix {

	public static void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		// nullify rows
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				nullifyRow(matrix, i);
			}
		}
		// nullify columns
		for (int j = 0; j < column.length; j++) {
			if (column[j]) {
				nullifyColumn(matrix, j);
			}
		}
	}

	private static void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}
	}

	private static void nullifyColumn(int[][] matrix, int column) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][column] = 0;
		}
	}

	public static void setZerosSpaceEfficiency(int[][] matrix) {

		boolean rowHasZero = false;
		boolean colHasZero = false;

		// check if first row has a zero
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}

		// check if first column has a zero
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}

		// check zeros in rest of array
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// nullify rows based on values on first column
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}
		}
		// nullify columns based on values on fist row
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				nullifyColumn(matrix, j);
			}
		}

		// nullify first row
		if (rowHasZero) {
			nullifyRow(matrix, 0);
		}

		// nullify column
		if (colHasZero) {
			nullifyColumn(matrix, 0);
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 4, 5 }, { 5, 0, 7, 1 }, { 3, 4, 7, 0 },
				{ 3, 4, 7, 1 } };
		print(matrix);
		setZeros(matrix);
		System.out.println();
		print(matrix);

		System.out.println();

		matrix = new int[][] { { 1, 2, 4, 5 }, { 5, 0, 7, 1 }, { 3, 4, 7, 0 }, { 3, 4, 7, 1 } };
		setZerosSpaceEfficiency(matrix);
		print(matrix);
	}

	private static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j]);
			System.out.println();
		}
	}
}
