package com.dzhou.interview.google;

/**
 * 308. Range Sum Query 2D - Mutable
 * 
 * Difficulty: Hard
 * 
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2,
 * col2).
 *
 * Example: <br>
 * Given matrix = [ <br>
 * --[3, 0, 1, 4, 2], <br>
 * --[5, 6, 3, 2, 1], <br>
 * --[1, 2, 0, 1, 5], <br>
 * --[4, 1, 0, 1, 7], <br>
 * --[1, 0, 3, 0, 5] <br>
 * ] <br>
 * 
 * sumRegion(2, 1, 4, 3) -> 8 <br>
 * update(3, 2, 2) <br>
 * sumRegion(2, 1, 4, 3) -> 10 <br>
 * 
 * Note: <br>
 * The matrix is only modifiable by the update function. <br>
 * You may assume the number of calls to update and sumRegion function is
 * distributed evenly. <br>
 * You may assume that row1 ≤ row2 and col1 ≤ col2. <br>
 * 
 * @author zhoudong
 *
 */
public class RangeSumQuery2DMutable {

	public class NumMatrix {

		class SegmentTreeNode {
			int start = 0;
			int end = 0;
			int value = 0;
			SegmentTreeNode left;
			SegmentTreeNode right;

			SegmentTreeNode(int start, int end) {
				this.start = start;
				this.end = end;
			}

			SegmentTreeNode(int start, int end, int value) {
				this(start, end);
				this.value = value;
			}
		}

		class SegmentTree {
			int size;
			SegmentTreeNode root;

			SegmentTree(int[] nums) {
				this.size = nums.length;
				this.root = buildSegmentTree(nums, 0, nums.length - 1);
			}

			private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
				if (start > end)
					return null;
				if (start == end) {
					return new SegmentTreeNode(start, end, nums[start]);
				}
				SegmentTreeNode root = new SegmentTreeNode(start, end);
				int mid = (start + end) / 2;
				root.left = buildSegmentTree(nums, start, mid);
				root.right = buildSegmentTree(nums, mid + 1, end);
				root.value = root.left.value + root.right.value;
				return root;
			}

			void update(int index, int value) {
				if (index < 0 || index >= size)
					return;
				update(root, index, value);
			}

			private int update(SegmentTreeNode root, int index, int value) {
				if (root == null)
					return 0;
				if (root.start == index && root.end == index) {
					int old = root.value;
					root.value = value;
					return old;
				}
				int mid = (root.start + root.end) / 2;
				int old = 0;
				if (index <= mid) {
					old = update(root.left, index, value);
				} else {
					old = update(root.right, index, value);
				}
				root.value = root.value - old + value;
				return old;
			}

			int sumRange(int start, int end) {
				if (start < 0 || start > end || end >= size)
					return -1;
				return sumRange(root, start, end);
			}

			private int sumRange(SegmentTreeNode root, int start, int end) {
				if (root == null)
					return 0;
				if (root.start == start && root.end == end)
					return root.value;
				int mid = (root.start + root.end) / 2;
				if (start <= mid && end <= mid) {
					return sumRange(root.left, start, end);
				} else if (start > mid && end > mid) {
					return sumRange(root.right, start, end);
				} else {
					return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
				}
			}
		}

		SegmentTree[] trees = null;

		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
				return;
			trees = new SegmentTree[matrix.length];
			for (int i = 0; i < trees.length; i++) {
				trees[i] = new SegmentTree(matrix[i]);
			}
		}

		public void update(int row, int col, int val) {
			if (isValid(row, col)) {
				trees[row].update(col, val);
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			if (!isValid(row1, col1, row2, col2))
				return -1;
			int sum = 0;
			for (int row = row1; row <= row2; row++)
				sum += trees[row].sumRange(col1, col2);
			return sum;
		}

		private boolean isValid(int row1, int col1, int row2, int col2) {
			return isValid(row1, col1) && isValid(row2, col2) && row1 <= row2 && col1 <= col2;
		}

		private boolean isValid(int row, int col) {
			if (trees == null || trees.length == 0)
				return false;
			if (row < 0 || row >= trees.length || col < 0 || col >= trees[row].size)
				return false;
			return true;
		}
	}

	// Your NumMatrix object will be instantiated and called as such:
	// NumMatrix numMatrix = new NumMatrix(matrix);
	// numMatrix.sumRegion(0, 1, 2, 3);
	// numMatrix.update(1, 1, 10);
	// numMatrix.sumRegion(1, 2, 3, 4);

}
