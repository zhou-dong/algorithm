package org.dzhou.practice.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * 
 * @author zhoudong
 * 
 *         Analysis
 * 
 *         This problem can be solve by counting points that have the same slope
 *         for each point. When counting, we need to be careful about the
 *         duplicate points and points on the vertical lines
 * 
 *         reference
 * 
 *         http://blog.csdn.net/linhuanmars/article/details/21060933
 * 
 * 
 *         y1 = ax1 + b1 y2 = ax2 + b2
 */
public class MaxPointsOnALine {

	// Definition for a point.
	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public class Solution {

		public int maxPoints(Point[] points) {
			if (points == null || points.length == 0)
				return 0;

			int max = 0;
			for (int i = 0; i < points.length; i++) {
				Map<Double, Integer> map = new HashMap<>();
				int vertical = 0, duplicate = 1;
				for (int j = i + 1; j < points.length; j++) {
					if (points[i].x == points[j].x) {
						if (points[i].y == points[j].y)
							duplicate++;
						else
							vertical++;
					} else {
						double slope = calculateSlope(points[i], points[j]);
						addToMap(map, slope);
					}
				}
				int maxSlope = countMaxSlope(map);
				int localMax = Math.max(maxSlope, vertical);
				max = Math.max(localMax + duplicate, max);
			}

			return max;
		}

		private void addToMap(Map<Double, Integer> map, double slope) {
			if (!map.containsKey(slope)) {
				map.put(slope, 1);
			} else {
				map.put(slope, map.get(slope) + 1);
			}
		}

		private int countMaxSlope(Map<Double, Integer> map) {
			int max = 0;
			for (int value : map.values())
				max = Math.max(max, value);
			return max;
		}

		// Double a = -0.0, b = 0.0;
		// (a==b) == false
		private double calculateSlope(Point a, Point b) {
			double slope = (double) (b.y - a.y) / (double) (b.x - a.x);
			return a.y == b.y ? 0 : slope;
		}
	}

}
