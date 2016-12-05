package com.dzhou.interview.google;

import java.util.List;

/**
 * 469. Convex Polygon
 * 
 * Difficulty: Medium
 * 
 * Given a list of points that form a polygon when joined sequentially, find if
 * this polygon is convex (Convex polygon definition).
 * 
 * Note:
 * 
 * There are at least 3 and at most 10,000 points.
 * 
 * Coordinates are in the range -10,000 to 10,000.
 * 
 * You may assume the polygon formed by given points is always a simple polygon
 * (Simple polygon definition). In other words, we ensure that exactly two edges
 * intersect at each vertex, and that edges otherwise don't intersect each
 * other.
 * 
 * @author zhoudong
 *
 *         reference:
 *         https://discuss.leetcode.com/topic/70706/beyond-my-knowledge-java-
 *         solution-with-in-line-explanation
 */
public class ConvexPolygon {

	public boolean isConvex(List<List<Integer>> points) {
		// For each set of three adjacent points A, B, C, find the cross product
		// AB · BC. If the sign of all the cross products is the same, the
		// angles are all positive or negative (depending on the order in which
		// we visit them) so the polygon is convex.
		boolean gotNegative = false;
		boolean gotPositive = false;
		int numPoints = points.size();
		int B, C;
		for (int A = 0; A < numPoints; A++) {
			// Trick to calc the last 3 points: n - 1, 0 and 1.
			B = (A + 1) % numPoints;
			C = (B + 1) % numPoints;

			int crossProduct = crossProductLength(points.get(A), points.get(B), points.get(C));
			if (crossProduct < 0) {
				gotNegative = true;
			} else if (crossProduct > 0) {
				gotPositive = true;
			}
			if (gotNegative && gotPositive) {
				return false;
			}
		}

		// If we got this far, the polygon is convex.
		return true;
	}

	private int crossProductLength(List<Integer> A, List<Integer> B, List<Integer> C) {
		return crossProductLength(A.get(0), A.get(1), B.get(0), B.get(1), C.get(0), C.get(1));
	}

	// Return the cross product AB x BC.
	// The cross product is a vector perpendicular to AB and BC having length
	// |AB| * |BC| * Sin(theta) and
	// with direction given by the right-hand rule. For two vectors in the X-Y
	// plane, the result is a
	// vector with X and Y components 0 so the Z component gives the vector's
	// length and direction.
	private int crossProductLength(int Ax, int Ay, int Bx, int By, int Cx, int Cy) {
		// Get the vectors' coordinates.
		int BAx = Ax - Bx;
		int BAy = Ay - By;
		int BCx = Cx - Bx;
		int BCy = Cy - By;
		// Calculate the Z coordinate of the cross product.
		return (BAx * BCy - BAy * BCx);
	}

}
