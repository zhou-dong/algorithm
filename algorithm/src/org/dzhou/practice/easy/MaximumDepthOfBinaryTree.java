package org.dzhou.practice.easy;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * @author zhoudong
 *
 */
public class MaximumDepthOfBinaryTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		return maxDepth(root, 0);
	}

	public int maxDepth(TreeNode node, int depth) {
		if (node == null)
			return depth;
		int left = maxDepth(node.left, depth + 1);
		int right = maxDepth(node.right, depth + 1);
		return Math.max(left, right);
	}

}
