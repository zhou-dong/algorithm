package org.dzhou.practice.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * @author zhoudong
 *
 */
public class MinimumDepthOfBinaryTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public int minDepth(TreeNode root) {
			if (root == null)
				return 0;
			int minLeft = minDepth(root.left);
			int minRight = minDepth(root.right);
			if (minLeft == 0 || minRight == 0) {
				return minLeft > minRight ? minLeft + 1 : minRight + 1;
			}
			return Math.min(minLeft, minRight) + 1;
		}
	}

	class Solution1 {
		public int minDepth(TreeNode root) {
			if (root == null)
				return 0;
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			int depth = 1;
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode current = queue.poll();
					if (current.left == null && current.right == null)
						return depth;
					if (current.left != null)
						queue.add(current.left);
					if (current.right != null)
						queue.add(current.right);
				}
				depth++;
			}
			return depth;
		}
	}

}
