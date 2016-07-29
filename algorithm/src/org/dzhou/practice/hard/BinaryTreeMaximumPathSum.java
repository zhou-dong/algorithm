package org.dzhou.practice.hard;

/**
 * Given a binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path does not need to go through the root.
 * 
 * For example: Given the below binary tree,
 * 
 * --1<br>
 * -/-\<br>
 * 2---3<br>
 * 
 * Return 6.
 * 
 * @author zhoudong
 * 
 *         这道题的关键是读懂题，我真的是google了很多次，才明白本题的意思！
 * 
 *         1. 从左子树到node再到parent<br>
 *         2. 从右子树到node再到parent <br>
 *         3. 直接从node到parent <br>
 * 
 *         注意：从左子树到node再到右子树，不能走到parent，因为那条路已经经过root了，除非折回来重复走！但这是不允许的。
 * 
 * 
 *         另外：这道题是 Maximum SubArray 的扩展<br>
 *         https://leetcode.com/problems/maximum-subarray/
 *
 */
public class BinaryTreeMaximumPathSum {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 复习 Maximum SubArray
	public class MaxSubArraySolution {
		public int maxSubArray(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			int current = 0, max = Integer.MIN_VALUE;
			for (int i = 0; i < nums.length; i++) {
				current += nums[i];
				max = Math.max(max, current);
				if (current < 0) {
					current = 0;
				}
			}
			return max;
		}
	}

	public class Solution {
		int max = Integer.MIN_VALUE;

		public int maxPathSum(TreeNode root) {
			traversal(root);
			return max;
		}

		public int traversal(TreeNode root) {
			if (root == null)
				return 0;
			int left = traversal(root.left);
			int right = traversal(root.right);
			int path = Math.max(root.val + left, root.val + right);
			max = Math.max(max, left + root.val + right);
			return path > 0 ? path : 0;
		}
	}

	public class Solution1 {
		int max = Integer.MIN_VALUE;

		public int maxPathSum(TreeNode root) {
			traversal(root);
			return max;
		}

		public int traversal(TreeNode root) {
			if (root == null)
				return 0;
			int left = traversal(root.left);
			int right = traversal(root.right);
			int path = Math.max(root.val, Math.max(root.val + left, root.val + right));
			max = Math.max(max, Math.max(path, left + root.val + right));
			return path;
		}
	}

}
