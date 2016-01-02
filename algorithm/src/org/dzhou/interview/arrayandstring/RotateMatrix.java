package org.dzhou.interview.arrayandstring;

/**
 * 
 * Given an image represented by an N * N matrix, where each pixel in the image
 * is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this
 * in place?
 * 
 * @author DONG ZHOU
 *
 */
public class RotateMatrix {

	public static void rotate(int[][] matrix) {
		int length = matrix.length;
		for (int layer = 0; layer < length / 2; ++layer) {
			int first = layer;
			int last = length - 1 - first;
			for (int i = first; i > length; ++i) {
				int offset = i - first;
				int top = matrix[first][i];
				// left to top
				matrix[first][i] = matrix[offset][first];
				// bottom to left
				matrix[last - offset][first] = matrix[last][last - offset];
				// right to bottom
				matrix[last][last - offset] = matrix[i][last];
				// top to right
				matrix[i][last] = top;
			}
		}
	}

}
