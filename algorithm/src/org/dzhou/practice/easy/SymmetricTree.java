package org.dzhou.practice.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * @author zhoudong
 *
 */
public class SymmetricTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Iterative
	public class Solution {

		public boolean isSymmetric(TreeNode root) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			queue.add(root);

			while (!queue.isEmpty()) {
				TreeNode n1 = queue.poll();
				TreeNode n2 = queue.poll();
				if (n1 == null && n2 == null)
					continue;
				if (n1 == null || n2 == null)
					return false;
				if (n1.val != n2.val)
					return false;
				queue.add(n1.left);
				queue.add(n2.right);
				queue.add(n1.right);
				queue.add(n2.left);
			}

			return true;
		}

	}

	// Recursive

	class Solution1 {
		public boolean isSymmetric(TreeNode root) {
			return isSymmetric(root, root);
		}

		public boolean isSymmetric(TreeNode n1, TreeNode n2) {
			if (n1 == null && n2 == null)
				return true;
			if (n1 == null || n2 == null)
				return false;
			return (n1.val == n2.val) && isSymmetric(n1.right, n2.left) && isSymmetric(n1.left, n2.right);
		}
	}
}
