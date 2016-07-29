package org.dzhou.practice.hard;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3},
 * 
 * 1<br>
 * -\<br>
 * --2<br>
 * -/<br>
 * 3<br>
 * return [3,2,1].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author zhoudong
 *
 *         reference: https://www.youtube.com/watch?v=qT65HltK2uE
 * 
 *         用两个栈实现，简直太棒了，简洁明了！
 */
public class BinaryTreePostorderTraversal {

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
		public List<Integer> postorderTraversal(TreeNode root) {
			if (root == null)
				return Collections.emptyList();
			Stack<TreeNode> stack = createStackWithinAllNodes(root);
			return popAllNodesFromStack(stack);
		}

		// post traversal: left, right, parent
		private Stack<TreeNode> createStackWithinAllNodes(TreeNode root) {
			Stack<TreeNode> stack1 = new Stack<>();
			Stack<TreeNode> stack2 = new Stack<>();
			stack1.add(root);
			while (!stack1.isEmpty()) {
				TreeNode node = stack1.pop();
				if (node.left != null) {
					stack1.push(node.left);
				}
				if (node.right != null) {
					stack1.push(node.right);
				}
				stack2.push(node);
			}
			return stack2;
		}

		private List<Integer> popAllNodesFromStack(Stack<TreeNode> stack) {
			List<Integer> result = new LinkedList<>();
			while (!stack.isEmpty()) {
				result.add(stack.pop().val);
			}
			return result;
		}

	}

}
