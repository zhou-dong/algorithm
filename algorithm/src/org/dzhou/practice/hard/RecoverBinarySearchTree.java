package org.dzhou.practice.hard;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution?
 * 
 * @author zhoudong
 *
 */
public class RecoverBinarySearchTree {

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

		TreeNode firstNode = null;
		TreeNode secondNode = null;
		TreeNode previous = new TreeNode(Integer.MIN_VALUE);

		public void recoverTree(TreeNode root) {
			preOrderTraversal(root);
			swap(firstNode, secondNode);
		}

		private void preOrderTraversal(TreeNode node) {
			if (node == null)
				return;
			preOrderTraversal(node.left);
			if (firstNode == null && node.val < previous.val) {
				firstNode = previous;
			}
			if (firstNode != null && node.val < previous.val) {
				secondNode = node;
			}
			previous = node;
			preOrderTraversal(node.right);
		}

		private void swap(TreeNode first, TreeNode second) {
			if (first == null || second == null)
				return;
			int temp = first.val;
			first.val = second.val;
			second.val = temp;
		}

	}

}
