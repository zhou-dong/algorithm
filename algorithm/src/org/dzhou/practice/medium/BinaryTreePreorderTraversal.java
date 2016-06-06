package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * 
 * Given binary tree {1,#,2,3},
 * 
 * 1<br>
 * \<br>
 * 2<br>
 * /<br>
 * 3<br>
 * 
 * return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * 
 * @author zhoudong
 *
 */
public class BinaryTreePreorderTraversal {

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

		public List<Integer> preorderTraversal(TreeNode root) {
			if (root == null)
				return Collections.emptyList();
			List<Integer> result = new ArrayList<>();
			helper(root, result);
			return result;
		}

		private void helper(TreeNode node, List<Integer> list) {
			if (node == null)
				return;
			list.add(node.val);
			helper(node.left, list);
			helper(node.right, list);
		}

	}

	// 非递归方法
	public class Solution1 {

		public List<Integer> preorderTraversal(TreeNode root) {
			if (root == null)
				return Collections.emptyList();
			List<Integer> result = new ArrayList<>();
			Stack<TreeNode> stack = new Stack<>();
			while (root != null || !stack.isEmpty()) {
				if (root != null) {
					stack.push(root);
					result.add(root.val);
					root = root.left;
				} else {
					root = stack.pop();
					root = root.right;
				}
			}
			return result;
		}

	}

}
