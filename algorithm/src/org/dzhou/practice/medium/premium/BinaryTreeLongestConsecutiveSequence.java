package org.dzhou.practice.medium.premium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find the length of the longest consecutive sequence
 * path.
 * 
 * The path refers to any sequence of nodes from some starting node to any node
 * in the tree along the parent-child connections. The longest consecutive path
 * need to be from parent to child (cannot be the reverse).
 * 
 * For example, <br>
 * ---1<br>
 * ----\<br>
 * -----3<br>
 * ----/-\<br>
 * ---2---4<br>
 * --------\<br>
 * ---------5<br>
 * 
 * Longest consecutive sequence path is 3-4-5, so return 3.<br>
 * ---2<br>
 * ----\<br>
 * -----3<br>
 * ----/ <br>
 * ---2 <br>
 * --/ <br>
 * -1<br>
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 * 
 * @author zhoudong
 *
 */
public class BinaryTreeLongestConsecutiveSequence {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// DFS
	public class Solution {

		public int longestConsecutive(TreeNode root) {
			if (root == null)
				return 0;
			return findLongest(root, 0, root.val);
		}

		private int findLongest(TreeNode root, int length, int preVal) {
			if (root == null)
				return length;
			int currLen = (preVal == root.val - 1) ? length + 1 : 1;
			int leftLen = findLongest(root.left, currLen, root.val);
			int rightLen = findLongest(root.right, currLen, root.val);
			return Math.max(currLen, Math.max(leftLen, rightLen));
		}

	}

	// DFS 2
	public class Solution1 {
		int max = 1;

		public int longestConsecutive(TreeNode root) {
			if (root == null)
				return 0;
			findLongest(root, 1);
			return max;
		}

		private void findLongest(TreeNode root, int length) {
			if (root.left != null)
				execute(root, root.left, length);
			if (root.right != null)
				execute(root, root.right, length);
		}

		private void execute(TreeNode node, TreeNode child, int length) {
			int childLen = child.val - node.val == 1 ? length + 1 : 1;
			max = Math.max(max, childLen);
			findLongest(child, childLen);
		}

	}

	// BFS Solution
	public class Solution2 {
		public int longestConsecutive(TreeNode root) {
			if (root == null)
				return 0;
			return bfs(root);
		}

		private int bfs(TreeNode root) {
			int max = 1;

			Queue<TreeNode> queue = new LinkedList<>();
			Queue<Integer> lengths = new LinkedList<>();
			queue.add(root);
			lengths.add(1);

			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				int length = lengths.poll();
				if (node.left != null) {
					int currLen = childLen(node, node.left, length);
					queue.add(node.left);
					lengths.add(currLen);
					max = Math.max(max, currLen);
				}
				if (node.right != null) {
					int currLen = childLen(node, node.right, length);
					lengths.add(currLen);
					queue.add(node.right);
					max = Math.max(max, currLen);
				}
			}
			return max;
		}

		private int childLen(TreeNode node, TreeNode child, int length) {
			return (child.val - node.val == 1) ? length + 1 : 1;
		}
	}
}
