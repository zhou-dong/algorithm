package org.dzhou.interview.treeandgraph;

import java.util.LinkedList;
import java.util.List;

/**
 * Practice of "cracking the code interview"
 * 
 * Implement a function to check if a binary tree is a binary search tree.
 * 
 * @author DONG ZHOU
 *
 *         1. in order traversal to copy all node into a array, then check
 * 
 *         2. Optimize first solution
 * 
 *         3.
 */
public class ValidateBST {

	List<TreeNode<Integer>> nodeList = new LinkedList<>();

	private void inOrderTraversal(TreeNode<Integer> node) {
		if (node == null)
			return;
		inOrderTraversal(node.left);
		visit(node);
		inOrderTraversal(node.right);
	}

	private void visit(TreeNode<Integer> node) {
		nodeList.add(node);
	}

	public boolean checkBST(TreeNode<Integer> node) {
		inOrderTraversal(node);
		for (int i = 1; i < nodeList.size(); i++)
			if (nodeList.get(i).data < nodeList.get(i - 1).data)
				return false;
		return true;
	}

	Integer last_printed = null;

	public boolean checkBST2(TreeNode<Integer> node) {
		if (node == null)
			return true;
		if (!checkBST2(node.left))
			return false;
		if (last_printed != null && last_printed > node.data)
			return false;
		last_printed = node.data;
		if (!checkBST(node.right))
			return false;
		return true;
	}

	public boolean checkBST3(TreeNode<Integer> node) {
		return checkBST(node, null, null);
	}

	private boolean checkBST(TreeNode<Integer> node, Integer min, Integer max) {
		if (node == null)
			return true;
		if ((min != null && node.data < min) || (max != null && node.data > max))
			return false;
		if (!checkBST(node.left, min, node.data) || !checkBST(node, node.data, max))
			return false;
		return true;
	}

}
