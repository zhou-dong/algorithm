package org.dzhou.research.cci.treegraph;

/**
 * Practice of "cracking the code interview"
 * 
 * Implement a function to check if a binary tree is balanced. For the purposes
 * of this question, a balanced tree is defined to be a tree such that the
 * heights of the tow subtrees of any node never differ by more than one.
 * 
 * @author DONG ZHOU
 *
 */
public class CheckBalanced {

	class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		TreeNode(int value) {
			this.value = value;
		}
	}

	public class Solution {
		boolean isBalanced(TreeNode root) {
			if (root == null)
				return true;
			if (getHeightDiff(root) > 1)
				return false;
			return isBalanced(root.left) && isBalanced(root.right);
		}

		private int getHeightDiff(TreeNode root) {
			return Math.abs(getHeight(root.left) - getHeight(root.right));
		}

		int getHeight(TreeNode root) {
			if (root == null)
				return -1;
			return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		}
	}

	public class Solution1 {
		boolean isBalanced(TreeNode root) {
			return checkHeight(root) != Integer.MIN_VALUE;
		}

		int checkHeight(TreeNode root) {
			if (root == null)
				return -1;
			int leftHeight = checkHeight(root.left);
			if (leftHeight == Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			int rightHeight = checkHeight(root.right);
			if (rightHeight == Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			if (checkHeightDiff(leftHeight, rightHeight) > 1)
				return Integer.MIN_VALUE;
			return Math.max(leftHeight, rightHeight) + 1;
		}

		private int checkHeightDiff(int leftHeight, int rightHeight) {
			return Math.abs(leftHeight - rightHeight);
		}
	}

	/**
	 * This is error solution!
	 * 
	 * for example:<br>
	 * Input: [1,null,3,2]<br>
	 * Output: true<br>
	 * Expected: false
	 */
	public class ErrorSolution {
		public boolean isBalanced(TreeNode root) {
			if (root == null)
				return true;
			if (getHeightDiff(root) > 1)
				return false;
			return isBalanced(root.left) && isBalanced(root.right);
		}

		private int getHeightDiff(TreeNode node) {
			return Math.abs(getLeftHeight(node) - getRightHeight(node));
		}

		// error method
		private int getLeftHeight(TreeNode node) {
			if (node == null)
				return -1;
			return getLeftHeight(node.left) + 1;
		}

		// error method
		private int getRightHeight(TreeNode node) {
			if (node == null)
				return -1;
			return getRightHeight(node.right) + 1;
		}
	}

}
