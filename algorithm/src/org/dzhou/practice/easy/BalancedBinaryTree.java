package org.dzhou.practice.easy;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author zhoudong
 *
 */
public class BalancedBinaryTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public boolean isBalanced(TreeNode root) {
			if (root == null)
				return true;
			int left = height(root.left);
			int right = height(root.right);
			if (Math.abs(left - right) > 1)
				return false;
			return isBalanced(root.left) && isBalanced(root.right);
		}

		private int height(TreeNode node) {
			if (node == null)
				return 0;
			int left = height(node.left) + 1;
			int right = height(node.right) + 1;
			return Math.max(left, right);
		}
	}

	class Solution1 {
		public boolean isBalanced(TreeNode root) {
			if (root == null)
				return true;
			if (Math.abs(height(root.left) - height(root.right)) > 1)
				return false;
			return isBalanced(root.left) && isBalanced(root.right);
		}

		private int height(TreeNode node) {
			if (node == null)
				return 0;
			return Math.max(height(node.left), height(node.right)) + 1;
		}
	}

}
