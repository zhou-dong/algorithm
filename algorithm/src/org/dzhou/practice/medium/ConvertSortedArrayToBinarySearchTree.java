package org.dzhou.practice.medium;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * @author zhoudong
 *
 */
public class ConvertSortedArrayToBinarySearchTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {

		public TreeNode sortedArrayToBST(int[] nums) {
			if (nums.length == 0)
				return null;
			return sortedArrayToBST(nums, 0, nums.length - 1);
		}

		public TreeNode sortedArrayToBST(int[] num, int start, int end) {
			if (start > end)
				return null;

			int mid = (start + end) / 2;
			TreeNode root = new TreeNode(num[mid]);
			root.left = sortedArrayToBST(num, start, mid - 1);
			root.right = sortedArrayToBST(num, mid + 1, end);
			return root;
		}

	}

}
