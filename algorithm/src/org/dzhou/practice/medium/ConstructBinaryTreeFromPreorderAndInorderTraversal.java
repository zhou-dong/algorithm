package org.dzhou.practice.medium;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author zhoudong
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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
		public TreeNode buildTree(int[] preorder, int[] inorder) {

			TreeNode root = new TreeNode(preorder[0]);

			return root;
		}
	}

}
