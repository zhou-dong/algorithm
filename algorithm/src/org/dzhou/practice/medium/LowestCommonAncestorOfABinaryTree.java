package org.dzhou.practice.medium;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * @author zhoudong
 *
 *         对于二叉搜索树，公共祖先的值一定大于等于较小的节点，小于等于较大的节点。换言之，在遍历树的时候，如果当前结点大于两个节点，
 *         则结果在当前结点的左子树里，如果当前结点小于两个节点，则结果在当前节点的右子树里。
 */
public class LowestCommonAncestorOfABinaryTree {

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
