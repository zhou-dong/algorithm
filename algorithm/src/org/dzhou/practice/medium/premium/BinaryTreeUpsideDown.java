package org.dzhou.practice.medium.premium;

/**
 * 
 * @author zhoudong
 *
 */
public class BinaryTreeUpsideDown {

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

		public TreeNode upsideDownBinaryTree(TreeNode root) {

			TreeNode node = root, parent = null, right = null;

			while (node != null) {
				TreeNode left = node.left;
				node.left = right;
				right = node.right;
				node.right = parent;
				parent = node;
				node = left;
			}
			return parent;
		}

	}

	public class Solution1 {

		public TreeNode upsideDownBinaryTree(TreeNode root) {
			if (root == null)
				return null;
			return upsideDownBinaryTreeHelper(root, null);
		}

		private TreeNode upsideDownBinaryTreeHelper(TreeNode root, TreeNode parent) {
			if (root == null)
				return parent;
			TreeNode newNode = upsideDownBinaryTreeHelper(root.left, root);
			root.left = (parent == null) ? null : parent.right;
			root.right = parent;
			return newNode;
		}

	}

}
