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
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	public boolean isBalanced(TreeNode<?> root) {
		if (root == null)
			return true;
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(heightDiff) > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}

}
