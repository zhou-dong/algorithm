package org.dzhou.practice.medium.premium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
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
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * 
 * 1 0 0 <br>
 * 0 0 0 Number of islands = 1 <br>
 * 0 0 0 <br>
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * 
 * 1 1 0 <br>
 * 0 0 0 Number of islands = 1 <br>
 * 0 0 0 <br>
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * 
 * 1 1 0 <br>
 * 0 0 1 Number of islands = 2 <br>
 * 0 0 0 <br>
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * 
 * 1 1 0 <br>
 * 0 0 1 Number of islands = 3 <br>
 * 0 1 0 <br>
 * We return the result as an array: [1, 1, 2, 3]
 * 
 * Challenge:
 * 
 * Can you do it in time complexity O(k log mn), where k is the length of the
 * positions?
 * 
 * @author zhoudong
 *
 *         reference: https://segmentfault.com/a/1190000004197552
 */
public class NumberOfIslandsII {

	public class Solution {
		public List<Integer> numIslands2(int m, int n, int[][] positions) {
			int[] id = new int[m * n]; // 表示各个index对应的root

			List<Integer> res = new ArrayList<>();
			Arrays.fill(id, -1); // 初始化root为-1，用来标记water, 非-1表示land
			int count = 0; // 记录island的数量

			int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
			for (int i = 0; i < positions.length; i++) {
				count++;
				int index = positions[i][0] * n + positions[i][1];
				id[index] = index; // root初始化

				for (int j = 0; j < dirs.length; j++) {
					int x = positions[i][0] + dirs[j][0];
					int y = positions[i][1] + dirs[j][1];
					if (x >= 0 && x < m && y >= 0 && y < n && id[x * n + y] != -1) {
						int root = root(id, x * n + y);

						// 发现root不等的情况下，才union, 同时减小count
						if (root != index) {
							id[root] = index;
							count--;
						}
					}
				}
				res.add(count);
			}
			return res;
		}

		public int root(int[] id, int i) {
			while (i != id[i]) {
				id[i] = id[id[i]]; // 优化，为了减小树的高度
				i = id[i];
			}
			return i;
		}
	}

	enum Direction {
		LEFT() {
			@Override
			int[] getDirection(int row, int col) {
				return new int[] { row, col - 1 };
			}
		},
		RIGHT() {
			@Override
			int[] getDirection(int row, int col) {
				return new int[] { row, col + 1 };
			}
		},
		UP() {
			@Override
			int[] getDirection(int row, int col) {
				return new int[] { row - 1, col };
			}
		},
		DOWN() {
			@Override
			int[] getDirection(int row, int col) {
				return new int[] { row + 1, col };
			}
		};
		abstract int[] getDirection(int row, int col);

		public static int[][] getDirections(int[] location) {
			return getDirections(location[0], location[1]);
		}

		public static int[][] getDirections(int row, int col) {
			Direction[] directions = Direction.values();
			int[][] result = new int[directions.length][2];
			for (int i = 0; i < directions.length; i++) {
				result[i] = directions[i].getDirection(row, col);
			}
			return result;
		}
	}

	// Wrong answer
	public class Solution1 {

		class UnionFind {
			private int[] roots;

			private int rows, cols;
			private int count = 0;

			UnionFind(int rows, int cols) {
				this.rows = rows;
				this.cols = cols;
				initRoots(rows * cols);
			}

			private void initRoots(int size) {
				roots = new int[size];
				Arrays.fill(roots, -1);
			}

			private int setRoot(int[] location) {
				return setRoot(location[0], location[1]);
			}

			private int setRoot(int row, int col) {
				int index = getIndex(row, col);
				roots[index] = index;
				return index;
			}

			private int getIndex(int[] location) {
				return getIndex(location[0], location[1]);
			}

			private int getIndex(int row, int col) {
				return row * cols + col;
			}

			public void union(int[] position) {

				count++;
				int index = setRoot(position);
				for (int[] direction : Direction.getDirections(position)) {
					if (!isValidLocation(direction) || !isIsland(direction)) {
						continue;
					}
					int directionIndex = getIndex(direction);
					if (isConnected(index, directionIndex)) {
						continue;
					}
					count--;
					roots[directionIndex] = index;
				}
				count = count < 1 ? 1 : count;

			}

			public void union2(int[] position) {
				count++;
				for (int[] direction : Direction.getDirections(position)) {
					if (!isValidLocation(direction) || !isIsland(direction)) {
						continue;
					}
					if (isConnected(getIndex(position), getIndex(direction))) {
						continue;
					}
					count--;
					updateRoot(direction);
				}
				setRoot(position);
				updateRoot(position);
				count = count < 1 ? 1 : count;
			}

			private void updateRoot(int[] location) {
				int index = getIndex(location);
				Queue<int[]> queue = new LinkedList<>();
				queue.add(location);
				while (!queue.isEmpty()) {
					int[] current = queue.poll();
					int currentIndex = getIndex(current);
					toConnect(index, currentIndex);
					for (int[] direction : Direction.getDirections(current)) {
						if (!isValidLocation(direction) || !isIsland(direction)) {
							continue;
						}
						if (!isConnected(currentIndex, getIndex(direction))) {
							queue.add(direction);
						}
					}
				}
			}

			private void toConnect(int source, int target) {
				roots[target] = source;
			}

			private boolean isConnected(int index1, int index2) {
				return roots[index1] == roots[index2];
			}

			private boolean isValidLocation(int[] location) {
				return isValidLocation(location[0], location[1]);
			}

			private boolean isValidLocation(int row, int col) {
				return row >= 0 && col >= 0 && row < rows && col < cols;
			}

			private boolean isIsland(int[] location) {
				return isIsland(location[0], location[1]);
			}

			private boolean isIsland(int row, int col) {
				return roots[getIndex(row, col)] != -1;
			}

			public int count() {
				return count;
			}

		}

		public List<Integer> numIslands2(int m, int n, int[][] positions) {
			List<Integer> result = new ArrayList<>();
			if (m * n == 1) {
				result.add(1);
				return result;
			}

			UnionFind unionFind = new UnionFind(m, n);
			for (int[] position : positions) {
				unionFind.union(position);
				result.add(unionFind.count());
			}
			return result;
		}

	}

	public static void main(String[] args) {
		new NumberOfIslandsII().test();
	}

	void test() {
		int[][] positions = { { 0, 1 }, { 1, 2 }, { 2, 1 }, { 1, 0 }, { 0, 2 }, { 0, 0 }, { 1, 1 } };
		List<Integer> s = new Solution().numIslands2(3, 3, positions);
		System.out.println(s);
	}
}
