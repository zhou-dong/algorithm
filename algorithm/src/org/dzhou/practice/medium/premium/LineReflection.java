package org.dzhou.practice.medium.premium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis
 * that reflect the given points.
 * 
 * Example 1: <br>
 * Given points = [[1,1],[-1,1]], return true.
 * 
 * Example 2: <br>
 * Given points = [[1,1],[-1,-1]], return false.
 * 
 * Hint:
 * 
 * 1.Find the smallest and largest x-value for all points.
 * 
 * 2.If there is a line then it should be at y = (minX + maxX) / 2.
 * 
 * 3.For each point, make sure that it has a reflected point in the opposite
 * side.
 * 
 * @author zhoudong
 *
 */
public class LineReflection {

	public class Solution {

		public boolean isReflected(int[][] points) {
			if (points == null || points.length == 0)
				return true;
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			Map<Integer, Set<Integer>> map = new HashMap<>();
			for (int[] point : points) {
				min = Math.min(min, point[0]);
				max = Math.max(max, point[0]);
				if (!map.containsKey(point[1]))
					map.put(point[1], new HashSet<>());
				map.get(point[1]).add(point[0]);
			}
			for (int[] point : points) {
				if (!map.get(point[1]).contains(max + min - point[0]))
					return false;
			}
			return true;
		}

	}

}
