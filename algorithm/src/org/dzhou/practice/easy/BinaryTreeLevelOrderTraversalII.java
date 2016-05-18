package org.dzhou.practice.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example:<br>
 * Given binary tree {3,9,20,#,#,15,7},<br>
 * 3<br>
 * / \<br>
 * 9 20<br>
 * / \<br>
 * 15 7<br>
 * return its bottom-up level order traversal as:<br>
 * [<br>
 * [15,7],<br>
 * [9,20],<br>
 * [3] ]<br>
 * 
 * @author zhoudong
 *
 */
public class BinaryTreeLevelOrderTraversalII {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null)
			return Collections.emptyList();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		List<List<Integer>> result = new LinkedList<>();
		while (!queue.isEmpty()) {
			List<Integer> level = new LinkedList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			result.add(0, level);
		}

		return result;
	}

}
