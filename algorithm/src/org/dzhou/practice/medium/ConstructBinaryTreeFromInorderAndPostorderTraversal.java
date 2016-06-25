package org.dzhou.practice.medium;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author zhoudong
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

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
		public TreeNode buildTree(int[] inorder, int[] postorder) {
			TreeNode root = new TreeNode(0);

			return root;
		}
	}

}
