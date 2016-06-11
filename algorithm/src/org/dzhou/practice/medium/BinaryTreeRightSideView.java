package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example:<br>
 * Given the following binary tree,<br>
 * --1 <---<br>
 * -/-\<br>
 * 2---3 <---<br>
 * -\---\<br>
 * --5---4 <---<br>
 * You should return [1, 3, 4].
 * 
 * 给定一棵二叉树，返回从右边看这棵二叉树所看到的节点序列（从上到下）。
 * 
 * @author zhoudong
 *
 */
public class BinaryTreeRightSideView {
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
		public List<Integer> rightSideView(TreeNode root) {
			if (root == null)
				return Collections.emptyList();
			List<Integer> result = new ArrayList<Integer>();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					if (i == 0)
						result.add(node.val);
					if (node.right != null)
						queue.add(node.right);
					if (node.left != null)
						queue.add(node.left);
				}
			}
			return result;
		}
	}

	public class Solution1 {
		public List<Integer> rightSideView(TreeNode root) {
			if (root == null)
				return Collections.emptyList();
			List<Integer> result = new ArrayList<Integer>();
			helper(result, root, 1);
			return result;
		}

		int maxdepth = 0;

		private void helper(List<Integer> result, TreeNode root, int depth) {
			if (depth > maxdepth) {
				result.add(root.val);
				maxdepth = depth;
			}
			if (root.right != null)
				helper(result, root.right, depth + 1);
			if (root.left != null)
				helper(result, root.left, depth + 1);
		}
	}
}
