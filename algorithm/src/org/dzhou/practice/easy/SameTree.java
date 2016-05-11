package org.dzhou.practice.easy;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 * @author zhoudong
 *
 */
public class SameTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null && q != null)
			return false;
		if (p != null && q == null)
			return false;
		if (p.val != q.val)
			return false;
		boolean isLeftSame = isSameTree(p.left, q.left);
		if (!isLeftSame)
			return false;
		boolean isRightSame = isSameTree(p.right, q.right);
		if (!isRightSame)
			return false;
		return true;
	}

	public boolean isSameTree1(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

}
