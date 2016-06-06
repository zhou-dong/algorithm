package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * 
 * Given binary tree [1,null,2,3], return [1,3,2].
 * 
 * Note:
 * 
 * Recursive solution is trivial, could you do it iteratively?
 * 
 * @author zhoudong
 *
 */
public class BinaryTreeInorderTraversal {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 递归做法
	public class Solution {

		public List<Integer> inorderTraversal(TreeNode root) {
			if (root == null)
				return Collections.emptyList();
			List<Integer> result = new ArrayList<>();
			helper(root, result);
			return result;
		}

		private void helper(TreeNode node, List<Integer> list) {
			if (node == null)
				return;
			helper(node.left, list);
			list.add(node.val);
			helper(node.right, list);
		}

	}

	// 非递归方法
	public class Solution1 {

		public List<Integer> inorderTraversal(TreeNode root) {
			if (root == null)
				return Collections.emptyList();
			List<Integer> result = new ArrayList<>();
			Stack<TreeNode> stack = new Stack<>();

			while (root != null || !stack.isEmpty()) {
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					result.add(root.val);
					root = root.right;
				}
			}
			return result;
		}

	}

}
