package com.dzhou.interview.third;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. Find Bottom Left Tree Value
 * 
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * 
 * @author zhoudong
 *
 */
public class FindBottomLeftTreeValue {

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

		class Helper {
			int maxHeight = -1;
			int value = 0;
		}

		public int findBottomLeftValue(TreeNode root) {
			Helper helper = new Helper();
			traverse(root, 0, helper);
			return helper.value;
		}

		private void traverse(TreeNode node, int currHeight, Helper helper) {
			if (node == null)
				return;
			if (currHeight > helper.maxHeight) {
				helper.maxHeight = currHeight;
				helper.value = node.val;
			}
			traverse(node.left, currHeight + 1, helper);
			traverse(node.right, currHeight + 1, helper);
		}

	}

	public class BFS_Solution {

		public int findBottomLeftValue(TreeNode root) {
			if (root == null)
				return -1;

			Queue<TreeNode> queue = new LinkedList<>();
			int result = -1;
			queue.add(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode curr = queue.poll();
					if (i == 0)
						result = curr.val;
					if (curr.left != null) {
						queue.add(curr.left);
					}
					if (curr.right != null) {
						queue.add(curr.right);
					}
				}
			}
			return result;
		}

	}

}
