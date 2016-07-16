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

	class TreeNode<T> {
		T value;
		TreeNode<T> left;
		TreeNode<T> right;

		TreeNode(T value) {
			this.value = value;
		}
	}

	public class Solution<T> {
		boolean isBalanced(TreeNode<T> root) {
			if (root == null)
				return true;
			if (getHeightDiff(root) > 1)
				return false;
			return isBalanced(root.left) && isBalanced(root.right);
		}

		private int getHeightDiff(TreeNode<T> root) {
			return Math.abs(getHeight(root.left) - getHeight(root.right));
		}

		int getHeight(TreeNode<T> root) {
			if (root == null)
				return -1;
			return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		}
	}

}
