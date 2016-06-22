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

	public class Solution {
		private int lastVal = Integer.MIN_VALUE;
		private boolean firstNode = true;

		public boolean isValidBST(TreeNode root) {
			if (root == null) {
				return true;
			}
			if (!isValidBST(root.left)) {
				return false;
			}
			if (!firstNode && lastVal >= root.val) {
				return false;
			}
			firstNode = false;
			lastVal = root.val;
			if (!isValidBST(root.right)) {
				return false;
			}
			return true;
		}
	}

}
