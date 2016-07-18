package org.dzhou.research.cci.treegraph;

/**
 * Practice of "cracking the code interview"
 * 
 * You are given a binary tree in which each node contains an integer value
 * (which might be positive or negative). Design an algorithm to count the
 * number of paths that sum to a given value. The path does not need to start or
 * end at the root or a leaf, but it must go downwards (traveling only from
 * parent nodes to child nodes).
 * 
 * @author DONG ZHOU
 *
 */
public class PathsWithSum {

	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	// brute force
	public class Solution {
		int countPathsWithSum(TreeNode root, int targetSum) {
			if (root == null)
				return 0;
			int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
			int pathsOnLeft = countPathsWithSum(root.left, targetSum);
			int pathsOnRight = countPathsWithSum(root.right, targetSum);
			return pathsFromRoot + pathsOnLeft + pathsOnRight;
		}

		int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
			if (node == null)
				return 0;
			currentSum += node.data;
			int totalPaths = 0;
			if (currentSum == targetSum)
				totalPaths++;
			totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
			totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);
			return totalPaths;
		}
	}

}
