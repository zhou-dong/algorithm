package org.dzhou.practice.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	// recursion
	class Solution {

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
			result.get(level).add(node.val);
			levelOrder(node.left, result, level + 1);
			levelOrder(node.right, result, level + 1);
		}

	}

	// BFS
	class Solution1 {

		public List<List<Integer>> levelOrder(TreeNode root) {
			if (root == null)
				return Collections.emptyList();

			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);

			List<List<Integer>> result = new LinkedList<>();

			while (!queue.isEmpty()) {
				List<Integer> level = new LinkedList<>();
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					level.add(node.val);
					if (node.left != null)
						queue.offer(node.left);
					if (node.right != null)
						queue.offer(node.right);
				}
				result.add(level);
			}

			return result;
		}

	}
}
