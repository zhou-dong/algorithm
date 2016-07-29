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
 *         reference: https://segmentfault.com/a/1190000004284255
 * 
 *         有两种情况需要考虑:
 * 
 *         1. 两个错位的node是相邻的父子node，其实只发生了一次逆序，那么first=previous，second=current
 * 
 *         2. 两个错位的节点不是相邻的父子node,这就是发生两次逆序的情况，
 *         那么这时候需要调换的元素应该是第一次逆序前面的元素，和第二次逆序后面的元素。
 * 
 *         Example1: 1,4,3,5,6,7 (两个node相邻)
 * 
 *         Example2: 1,4,3,2,5,6 (两个node不相邻)
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

	// 时间O(n) 空间栈O(log(n))
	public class Solution {

		TreeNode first = null, second = null, previous = null;

		public void recoverTree(TreeNode root) {
			inOrderTraversal(root);
			swap(first, second);
		}

		// example1: 1,4,3,5,6,7 (两个node相邻)
		// example2: 1,4,3,2,5,6 (两个node不相邻)
		private void inOrderTraversal(TreeNode node) {
			if (node == null)
				return;
			inOrderTraversal(node.left);
			if (previous != null && node.val < previous.val) {
				if (first == null)
					first = previous; // 第一个逆序点
				second = node; // 如果相邻：第一次就找全；如果不相邻：更新second
			}
			previous = node;
			inOrderTraversal(node.right);
		}

		private void swap(TreeNode one, TreeNode two) {
			if (one == null || two == null)
				return;
			int temp = one.val;
			one.val = two.val;
			two.val = temp;
		}

	}

}
