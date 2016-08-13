package org.dzhou.practice.hard.premium;

/**
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
 * 1.The matrix is only modifiable by the update function. <br>
 * 2.You may assume the number of calls to update and sumRegion function is
 * distributed evenly. <br>
 * 3.You may assume that row1 ≤ row2 and col1 ≤ col2. <br>
 * 
 * @author zhoudong
 *
 */
public class RangeSumQuery2DMutable {

	public static void main(String[] args) {
		new RangeSumQuery2DMutable().test();
	}

	void test() {
		int[] first = new int[] { 3, 0, 1, 4, 2 };
		int[] second = new int[] { 5, 6, 3, 2, 1 };
		int[] third = new int[] { 1, 2, 0, 1, 5 };
		int[] four = new int[] { 4, 1, 0, 1, 7 };
		int[] five = new int[] { 1, 0, 3, 0, 5 };
		NumMatrix matrix = new NumMatrix(new int[][] { first, second, third, four, five });
		System.out.println(matrix.sumRegion(2, 1, 4, 3));
		matrix.update(3, 2, 2);
		System.out.println(matrix.sumRegion(2, 1, 4, 3));
	}

	public class NumMatrix {

		SegmentTree[] trees = null;

		public NumMatrix(int[][] matrix) {
			trees = new SegmentTree[matrix.length];
			for (int i = 0; i < trees.length; i++) {
				trees[i] = new SegmentTree(matrix[i]);
			}
		}

		public void update(int row, int col, int val) {
			if (row < 0 || col < 0 || row >= trees.length || col >= trees[0].size)
				return;
			trees[row].update(col, val);
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int sum = 0;
			for (int row = row1; row <= row2; row++) {
				sum += trees[row].sumRange(col1, col2);
			}
			return sum;
		}

		class SegmentTree {

			SegmentTreeNode root;
			int size = 0;

			SegmentTree(int[] array) {
				root = buildTree(array, 0, array.length - 1);
				size = array.length;
			}

			private SegmentTreeNode buildTree(int[] array, int start, int end) {
				if (start > end)
					return null;
				if (start == end)
					return new SegmentTreeNode(start, end, array[start]);

				SegmentTreeNode root = new SegmentTreeNode(start, end);
				int mid = (start + end) / 2;
				root.left = buildTree(array, start, mid);
				root.right = buildTree(array, mid + 1, end);
				root.value = root.left.value + root.right.value;
				return root;
			}

			public void update(int index, int val) {
				if (index < 0 || index >= size)
					return;
				update(root, index, val);
			}

			private int update(SegmentTreeNode root, int index, int val) {
				if (root == null)
					return 0;
				if (index == root.low && index == root.high) {
					int old = root.value;
					root.value = val;
					return old;
				}
				int mid = (root.low + root.high) / 2;
				int old = 0;
				if (index <= mid) {
					old = update(root.left, index, val);
				} else {
					old = update(root.right, index, val);
				}
				root.value = root.value - old + val;
				return old;
			}

			public int sumRange(int i, int j) {
				if (i < 0 || j >= size || i > j)
					return -1;
				return sumRange(root, i, j);
			}

			public int sumRange(SegmentTreeNode root, int i, int j) {
				if (root == null)
					return 0;
				if (root.low == i && root.high == j) {
					return root.value;
				}
				int mid = (root.low + root.high) / 2;
				if (i <= mid && j <= mid)
					return sumRange(root.left, i, j);
				else if (i > mid && j > mid)
					return sumRange(root.right, i, j);
				else
					return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
			}
		}

		class SegmentTreeNode {
			int value;
			int low;
			int high;
			SegmentTreeNode left;
			SegmentTreeNode right;

			public SegmentTreeNode(int low, int high) {
				this(low, high, 0);
			}

			public SegmentTreeNode(int low, int high, int value) {
				this.low = low;
				this.high = high;
				this.value = value;
			}
		}
	}

	// Your NumMatrix object will be instantiated and called as such:
	// NumMatrix numMatrix = new NumMatrix(matrix);
	// numMatrix.sumRegion(0, 1, 2, 3);
	// numMatrix.update(1, 1, 10);
	// numMatrix.sumRegion(1, 2, 3, 4);
}
