package org.dzhou.interview.treeandgraph;

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
public class CheckBalance {

	public int getHeight(TreeNode<?> root) {
		if (root == null)
			return -1;
		return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
	}

	public boolean isBalanced(TreeNode<?> root) {
		if (root == null)
			return true;
		int heightDiff = getHeight(root.getLeft()) - getHeight(root.getRight());
		if (Math.abs(heightDiff) > 1)
			return false;
		else
			return isBalanced(root.getLeft()) && isBalanced(root.getRight());
	}

	public int getHeight2(TreeNode<?> root) {
		if (root == null)
			return -1;
		int leftHeight = getHeight2(root.getLeft());
		if (leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		int rightHeight = getHeight2(root.getRight());
		if (rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1)
			return Integer.MIN_VALUE;
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}

	public boolean isBalanced2(TreeNode<?> root) {
		return getHeight2(root) != Integer.MIN_VALUE;
	}

}
