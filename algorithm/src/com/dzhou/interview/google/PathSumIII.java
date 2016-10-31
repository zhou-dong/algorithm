package com.dzhou.interview.google;

/**
 * 437. Path Sum III
 * 
 * Difficulty: Easy
 * 
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * 
 * @author zhoudong
 *
 */
public class PathSumIII {

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

		public int pathSum(TreeNode root, int sum) {
			int[] result = new int[1];
			traverse(root, sum, result);
			return result[0];
		}

		private void traverse(TreeNode root, int sum, int[] result) {
			if (root != null) {
				count(root, sum, 0, result);
				traverse(root.left, sum, result);
				traverse(root.right, sum, result);
			}
		}

		private void count(TreeNode root, int sum, int previous, int[] result) {
			if (root == null)
				return;
			int current = previous + root.val;
			if (current == sum)
				result[0]++;
			count(root.left, sum, current, result);
			count(root.right, sum, current, result);
		}

	}

}
