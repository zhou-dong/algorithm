package org.dzhou.practice.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example:<br>
 * Given binary tree {3,9,20,#,#,15,7},<br>
 * 3<br>
 * / \<br>
 * 9 20<br>
 * / \<br>
 * 15 7<br>
 * 
 * return its level order traversal as: [<br>
 * [3],<br>
 * [9,20],<br>
 * [15,7]<br>
 * ]<br>
 * 
 * @author zhoudong
 *
 */
public class BinaryTreeLevelOrderTraversal {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
		levelOrder(root, result, 0);
		return result;
	}

	private void levelOrder(TreeNode node, List<List<Integer>> result, int level) {
		if (node == null)
			return;
		if (result.size() == level)
			result.add(level, new LinkedList<>());
		List<Integer> list = result.get(level);
		list.add(node.val);
		levelOrder(node.left, result, level + 1);
		levelOrder(node.right, result, level + 1);
	}

}
