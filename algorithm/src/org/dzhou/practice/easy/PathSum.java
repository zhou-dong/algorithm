package org.dzhou.practice.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * @author zhoudong
 *
 */
public class PathSum {

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
		public boolean hasPathSum(TreeNode root, int sum) {
			if (root == null)
				return false;
			sum -= root.val;
			if (root.left == null && root.right == null)
				return sum == 0;
			return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
		}
	}

	class Solution1 {
		public boolean hasPathSum(TreeNode root, int sum) {
			if (root == null)
				return false;

			Queue<TreeNode> nodes = new LinkedList<>();
			Queue<Integer> values = new LinkedList<>();

			nodes.add(root);
			values.add(root.val);

			while (!nodes.isEmpty()) {
				TreeNode node = nodes.poll();
				int value = values.poll();

				if (node.left == null && node.right == null && value == sum)
					return true;

				if (node.left != null) {
					nodes.add(node.left);
					values.add(node.left.val + value);
				}

				if (node.right != null) {
					nodes.add(node.right);
					values.add(node.right.val + value);
				}
			}
			return false;
		}
	}

}
