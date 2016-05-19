package org.dzhou.practice.easy;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure.
 * 
 * @author zhoudong
 *
 */
public class RectangleArea {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		return (C - A) * (D - B) + (G - E) * (H - F) - overlap(A, B, C, D, E, F, G, H);
	}

	private int overlap(int A, int B, int C, int D, int E, int F, int G, int H) {
		int h1 = Math.max(A, E);
		int h2 = Math.min(C, G);
		if (h2 <= h1)
			return 0;
		int v1 = Math.max(B, F);
		int v2 = Math.min(D, H);
		if (v2 < v1)
			return 0;
		return (h2 - h1) * (v2 - v1);
	}

}
