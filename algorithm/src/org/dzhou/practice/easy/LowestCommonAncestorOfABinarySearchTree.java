package org.dzhou.practice.easy;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * two given nodes in the BST.
 * 
 * @author zhoudong
 *
 */
public class LowestCommonAncestorOfABinarySearchTree {

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
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (root.val > p.val && root.val > q.val)
				return lowestCommonAncestor(root.left, p, q);
			if (root.val < p.val && root.val < q.val)
				return lowestCommonAncestor(root.right, p, q);
			return root;
		}
	}

	class Solution1 {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (root == null || root == p || root == q)
				return root;
			TreeNode left = lowestCommonAncestor(root.left, p, q);
			TreeNode right = lowestCommonAncestor(root.right, p, q);
			if (left != null && right != null)
				return root;
			return left == null ? right : left;
		}
	}

}
