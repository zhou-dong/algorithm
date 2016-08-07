package org.dzhou.practice.medium;

/**
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * The update(i, val) function modifies nums by updating the element at index i
 * to val.
 * 
 * Example: <br>
 * 
 * Given nums = [1, 3, 5] <br>
 * 
 * sumRange(0, 2) -> 9<br>
 * update(1, 2)<br>
 * sumRange(0, 2) -> 8<br>
 * 
 * Note: <br>
 * The array is only modifiable by the update function.<br>
 * You may assume the number of calls to update and sumRange function is
 * distributed evenly.
 * 
 * @author zhoudong
 *
 *         reference :
 *         http://www.voidcn.com/blog/pointbreak1/article/p-4878279.html
 */
public class RangeSumQueryMutable {

	public class NumArray {

		class SegmentTreeNode {
			int low;
			int high;
			int val;
			SegmentTreeNode left;
			SegmentTreeNode right;

			SegmentTreeNode(int low, int high, int val) {
				this.low = low;
				this.high = high;
				this.val = val;
			}

			public SegmentTreeNode(int low, int high) {
				this(low, high, 0);
			}
		}

		private SegmentTreeNode root;
		private int size;

		public NumArray(int[] nums) {
			root = buildSegmentTree(nums, 0, nums.length - 1);
			size = nums.length;
		}

		private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
			if (start > end)
				return null;
			if (start == end) // leaf
				return new SegmentTreeNode(start, end, nums[start]);

			SegmentTreeNode root = new SegmentTreeNode(start, end);
			int mid = (start + end) / 2;
			root.left = buildSegmentTree(nums, start, mid);
			root.right = buildSegmentTree(nums, mid + 1, end);
			root.val = root.left.val + root.right.val;
			return root;
		}

		void update(int i, int val) {
			if (i < 0 || i >= size)
				return;
			update(root, i, val);
		}

		private int update(SegmentTreeNode root, int i, int val) {
			if (root == null)
				return 0;
			if (root.low == i && root.high == i) {
				int old = root.val;
				root.val = val;
				return old;
			}

			int mid = (root.low + root.high) / 2;
			int old = 0;
			if (i >= root.low && i <= mid)
				old = update(root.left, i, val);
			else
				old = update(root.right, i, val);
			root.val = root.val - old + val;
			return old;
		}

		public int sumRange(int i, int j) {
			if (i < 0 || j >= size || i > j)
				return -1;
			return sumRange(root, i, j);
		}

		private int sumRange(SegmentTreeNode root, int i, int j) {
			if (root == null)
				return 0;
			if (root.low == i && root.high == j)
				return root.val;
			int mid = (root.low + root.high) / 2;
			if (i <= mid && j <= mid)
				return sumRange(root.left, i, j);
			else if (i > mid && j > mid)
				return sumRange(root.right, i, j);
			else {
				return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
			}
		}
	}

}
