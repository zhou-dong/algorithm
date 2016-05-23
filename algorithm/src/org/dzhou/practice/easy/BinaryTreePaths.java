package org.dzhou.practice.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * @author zhoudong
 *
 */
public class BinaryTreePaths {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null)
			return Collections.emptyList();
		List<String> result = new ArrayList<>();
		binaryTreePaths(root, result, root.val + "");
		return result;
	}

	public void binaryTreePaths(TreeNode root, List<String> result, String path) {
		if (root.left == null && root.right == null)
			result.add(path);
		if (root.left != null)
			binaryTreePaths(root.left, result, path + "->" + root.left.val);
		if (root.right != null)
			binaryTreePaths(root.right, result, path + "->" + root.right.val);
	}

}
