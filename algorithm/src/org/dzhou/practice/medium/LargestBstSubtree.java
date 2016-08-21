package org.dzhou.practice.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree
 * (BST), where largest means subtree with largest number of nodes in it.
 * 
 * Note: A subtree must include all of its descendants. Here's an example:
 * 
 * @author zhoudong
 *
 */
public class LargestBstSubtree {

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
		int max = 0;

		public int largestBSTSubtree(TreeNode root) {
			if (root == null)
				return 0;
			max = Math.max(isValidateBST(root, null, null), max);
			largestBSTSubtree(root.left);
			largestBSTSubtree(root.right);
			return max;
		}

		private int isValidateBST(TreeNode root, Integer min, Integer max) {
			if (root == null)
				return 0;
			if ((min != null && root.val <= min) || (max != null && root.val > max))
				return -1;
			int left = isValidateBST(root.left, min, root.val);
			int right = isValidateBST(root.right, root.val, max);
			return (left == -1 || right == -1) ? -1 : left + right + 1;
		}
	}

}
