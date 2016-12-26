package com.dzhou.interview.third;

/**
 * 450. Delete Node in a BST
 * 
 * Difficulty: Medium
 * 
 * Given a root node reference of a BST and a key, delete the node with the
 * given key in the BST. Return the root node reference (possibly updated) of
 * the BST.
 * 
 * Basically, the deletion can be divided into two stages:
 * 
 * Search for a node to remove. If the node is found, delete the node. Note:
 * Time complexity should be O(height of tree).
 * 
 * @author zhoudong
 *
 */
public class DeleteNodeInBST {

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

		public TreeNode deleteNode(TreeNode root, int key) {
			if (root == null)
				return null;
			if (key < root.val) {
				root.left = deleteNode(root.left, key);
			} else if (key > root.val) {
				root.right = deleteNode(root.right, key);
			} else {
				if (root.left == null) {
					return root.right;
				} else if (root.right == null) {
					return root.left;
				}
				root.val = findMin(root.right).val;
				root.right = deleteNode(root.right, root.val);
			}
			return root;
		}

		private TreeNode findMin(TreeNode node) {
			while (node.left != null)
				node = node.left;
			return node;
		}

	}

}
