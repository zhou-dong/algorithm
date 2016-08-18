package org.dzhou.practice.medium.premium;

/**
 * Given a binary search tree and a node in it, find the in-order successor of
 * that node in the BST.
 * 
 * Note: If the given node has no in-order successor in the tree, return null.
 * 
 * @author zhoudong
 */
public class InorderSuccessorInBST {

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

		public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
			TreeNode node = root, successor = null;
			while (node != null) {
				if (node.val > p.val) {
					successor = node;
					node = node.left;
				} else {
					node = node.right;
				}
			}
			return successor;
		}

	}

}
