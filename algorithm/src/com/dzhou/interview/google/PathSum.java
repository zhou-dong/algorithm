package com.dzhou.interview.google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. Path Sum
 * 
 * Difficulty: Easy
 * 
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

	public class DFS_Solution {
		public boolean hasPathSum(TreeNode root, int sum) {
			return root == null ? false : dfs(root, 0, sum);
		}

		private boolean dfs(TreeNode node, int prev, int sum) {
			if (node.left == null && node.right == null) {
				return (prev + node.val == sum) ? true : false;
			}
			if (node.left != null && dfs(node.left, prev + node.val, sum)) {
				return true;
			}
			if (node.right != null && dfs(node.right, prev + node.val, sum)) {
				return true;
			}
			return false;
		}
	}

	public class DFS_Solution1 {
		public boolean hasPathSum(TreeNode root, int sum) {
			return dfs(root, 0, sum);
		}

		private boolean dfs(TreeNode node, int prev, int sum) {
			if (node == null)
				return false;
			int current = prev + node.val;
			if (node.left == null && node.right == null)
				return (current == sum) ? true : false;
			return dfs(node.left, current, sum) || dfs(node.right, current, sum);
		}
	}

	public class BFS_Solution {
		public boolean hasPathSum(TreeNode root, int sum) {
			if (root == null)
				return false;
			Queue<TreeNode> nodeQueue = new LinkedList<>();
			Queue<Integer> sumQueue = new LinkedList<>();
			nodeQueue.add(root);
			sumQueue.add(sum);
			while (!nodeQueue.isEmpty()) {
				TreeNode node = nodeQueue.poll();
				int current = sumQueue.poll();
				current -= node.val;
				if (node.left == null && node.right == null) {
					if (current == 0)
						return true;
					else
						continue;
				}
				if (node.left != null) {
					nodeQueue.add(node.left);
					sumQueue.add(current);
				}
				if (node.right != null) {
					nodeQueue.add(node.right);
					sumQueue.add(current);
				}
			}
			return false;
		}
	}
}
