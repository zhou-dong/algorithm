package org.dzhou.interview.treeandgraph;

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
public class PathWithSum {

	int countPathsWithSum(TreeNode<Integer> root, int targetSum) {
		if (root == null)
			return 0;
		int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
		int pathsOnLeft = countPathsWithSum(root.getLeft(), targetSum);
		int pathsOnRight = countPathsWithSum(root.getRight(), targetSum);
		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}

	int countPathsWithSumFromNode(TreeNode<Integer> node, int targetSum, int currentSum) {
		if (node == null)
			return 0;
		currentSum += node.getData();
		int totalPaths = 0;
		if (currentSum == targetSum)
			totalPaths++;
		totalPaths += countPathsWithSumFromNode(node.getLeft(), targetSum, currentSum);
		totalPaths += countPathsWithSumFromNode(node.getRight(), targetSum, currentSum);
		return totalPaths;
	}

}
