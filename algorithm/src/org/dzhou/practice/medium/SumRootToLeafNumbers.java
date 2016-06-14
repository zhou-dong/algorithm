package org.dzhou.practice.medium;

import java.util.Stack;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * --1<br>
 * -/-\<br>
 * 2---3
 * 
 * The root-to-leaf path 1->2 represents the number 12.<br>
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * @author zhoudong
 *
 */
public class SumRootToLeafNumbers {

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
		public int sumNumbers(TreeNode root) {
			Stack<TreeNode> nodeStack = new Stack<TreeNode>();
			Stack<Integer> sumStack = new Stack<Integer>();
			TreeNode node = root;
			int prePathSum = 0, sum = 0;
			while (node != null || !nodeStack.empty()) {
				while (node != null) {
					prePathSum = (prePathSum * 10) + node.val;
					nodeStack.push(node);
					sumStack.push(prePathSum);
					node = node.left;
				}
				if (!nodeStack.empty()) {
					node = nodeStack.pop();
					prePathSum = sumStack.pop();
					if (node.left == null && node.right == null) {
						sum += prePathSum;
					}
					node = node.right;
				}
			}
			return sum;
		}
	}

	public class Solution1 {
		int sum = 0;

		public int sumNumbers(TreeNode root) {
			helper(root, 0);
			return sum;
		}

		private void helper(TreeNode node, int pre) {
			if (node == null)
				return;
			int value = pre * 10 + node.val;
			if (node.left == null && node.right == null)
				sum += value;
			helper(node.left, value);
			helper(node.right, value);
		}
	}

}
