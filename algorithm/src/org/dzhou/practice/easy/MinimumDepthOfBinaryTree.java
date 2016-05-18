package org.dzhou.practice.easy;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * @author zhoudong
 *
 */
public class MinimumDepthOfBinaryTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int minLeft = minDepth(root.left);
		int minRight = minDepth(root.right);
		if (minLeft == 0 || minRight == 0) {
			return minLeft > minRight ? minLeft + 1 : minRight + 1;
		}
		return Math.min(minLeft, minRight) + 1;
	}

}
