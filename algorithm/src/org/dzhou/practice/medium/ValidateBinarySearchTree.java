package org.dzhou.practice.medium;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 * 
 * Example 1:
 * 
 * --2<br>
 * -/-\<br>
 * 1---3<br>
 * 
 * Binary tree [2,1,3], return true.
 * 
 * Example 2:
 * 
 * --1<br>
 * -/-\<br>
 * 2---3<br>
 * 
 * Binary tree [1,2,3], return false.
 * 
 * @author zhoudong
 *
 */
public class ValidateBinarySearchTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Definition_Solution {
		public boolean isValidBST(TreeNode root) {
			return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		}

		private boolean isValidBST(TreeNode root, double min, double max) {
			if (root == null)
				return true;
			if (root.val <= min || root.val >= max)
				return false;
			return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
		}
	}

	public class Inorder_Solution {
		double previous = 0d;
		boolean isValid = true;

		public boolean isValidBST(TreeNode root) {
			init();
			inOrder(root);
			return isValid;

		}

		private void init() {
			previous = Double.NEGATIVE_INFINITY;
			isValid = true;
		}

		private void inOrder(TreeNode root) {
			if (root == null)
				return;
			inOrder(root.left);
			if (root.val <= previous) {
				isValid = false;
				return;
			}
			previous = root.val;
			inOrder(root.right);
		}
	}

}
