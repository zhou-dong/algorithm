package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 305. Number of Islands II
 * 
 * Difficulty: Hard
 * 
 * A 2d grid map of m rows and n columns is initially filled with water. We may
 * perform an addLand operation which turns the water at position (row, col)
 * into a land. Given a list of positions to operate, count the number of
 * islands after each addLand operation. An island is surrounded by water and is
 * formed by connecting adjacent lands horizontally or vertically. You may
 * assume all four edges of the grid are all surrounded by water.
 * 
 * Example:
 * 
 * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]. <br>
 * 
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water
 * and 1 represents land).
 * 
 * 0 0 0 <br>
 * 0 0 0 <br>
 * 0 0 0 <br>
 * 
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * 
 * 1 0 0 <br>
 * 0 0 0 Number of islands = 1 <br>
 * 0 0 0 <br>
 * 
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * 
 * 1 1 0 <br>
 * 0 0 0 Number of islands = 1 <br>
 * 0 0 0 <br>
 * 
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * 
 * 1 1 0 <br>
 * 0 0 1 Number of islands = 2 <br>
 * 0 0 0 <br>
 * 
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * 
 * 1 1 0 <br>
 * 0 0 1 Number of islands = 3 <br>
 * 0 1 0 <br>
 * 
 * We return the result as an array: [1, 1, 2, 3]
 * 
 * Challenge:
 * 
 * Can you do it in time complexity O(k log mn), where k is the length of the
 * positions?
 * 
 * @author zhoudong
 *
 */
public class NumberOfIslandsII {

	class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof Point)) {
				return false;
			}
			return equals((Point) obj);
		}

		private boolean equals(Point other) {
			return this.x == other.x && this.y == other.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	class TreeNode {
		Point point;
		TreeNode parent;
		int rank;

		TreeNode(Point point) {
			this.point = point;
			this.parent = this;
			rank = 0;
		}
	}

	class DisjointSet {
		Map<Point, TreeNode> map;

		DisjointSet() {
			map = new HashMap<>();
		}

		void addElement(Point point) {
			map.put(point, new TreeNode(point));
		}

		/**
		 * Combines two sets together to one. Does union by rank
		 * 
		 * @return true if data1 and data2 are in different set before union
		 *         else false.
		 */
		boolean union(Point x, Point y) {
			if (!map.containsKey(x) || !map.containsKey(y)) {
				return false;
			}
			TreeNode node1 = map.get(x);
			TreeNode node2 = map.get(y);
			TreeNode parent1 = findSet(node1);
			TreeNode parent2 = findSet(node2);
			if (parent1 == parent2) {
				return false;
			}
			if (parent1.rank >= parent2.rank) {
				parent1.rank += (parent1.rank > parent2.rank) ? 1 : 0;
				parent2.parent = parent1;
			} else {
				parent1.parent = parent2;
			}
			return true;
		}

		/**
		 * Find the representative recursively and does path compression as
		 * well.
		 */
		TreeNode findSet(TreeNode node) {
			if (node.parent == node)
				return node;
			node.parent = findSet(node.parent);
			return node.parent;
		}
	}

	private int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		DisjointSet disjointSet = new DisjointSet();
		List<Integer> result = new ArrayList<>();
		int count = 0;
		for (int[] position : positions) {
			Point point = new Point(position[0], position[1]);
			count++;
			disjointSet.addElement(point);
			for (int[] direction : directions) {
				Point neighbor = neighbor(point, direction);
				if (disjointSet.union(point, neighbor)) {
					count--;
				}
			}
			result.add(count);
		}
		return result;
	}

	private Point neighbor(Point point, int[] direction) {
		int x = point.x + direction[0];
		int y = point.y + direction[1];
		return new Point(x, y);
	}

}
