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
 *         3. current node data bigger than left children data, so it is max
 *         than children; current node data should less than right children
 *         data, so it is minimum data than right children.
 * 
 */
public class ValidateBST {

	List<TreeNode<Integer>> nodeList = new LinkedList<>();

	private void inOrderTraversal(TreeNode<Integer> node) {
		if (node == null)
			return;
		inOrderTraversal(node.getLeft());
		visit(node);
		inOrderTraversal(node.getRight());
	}

	private void visit(TreeNode<Integer> node) {
		nodeList.add(node);
	}

	public boolean checkBST(TreeNode<Integer> node) {
		inOrderTraversal(node);
		for (int i = 1; i < nodeList.size(); i++)
			if (nodeList.get(i).getData() < nodeList.get(i - 1).getData())
				return false;
		return true;
	}

	Integer last_printed = null;

	public boolean checkBST2(TreeNode<Integer> node) {
		if (node == null)
			return true;
		if (!checkBST2(node.getLeft()))
			return false;
		if (last_printed != null && last_printed > node.getData())
			return false;
		last_printed = node.getData();
		if (!checkBST(node.getRight()))
			return false;
		return true;
	}

	public boolean checkBST3(TreeNode<Integer> node) {
		return checkBST(node, null, null);
	}

	private boolean checkBST(TreeNode<Integer> node, Integer min, Integer max) {
		if (node == null)
			return true;
		if ((min != null && node.getData() < min) || (max != null && node.getData() > max))
			return false;
		if (!checkBST(node.getLeft(), min, node.getData())
				|| !checkBST(node.getRight(), node.getData(), max))
			return false;
		return true;
	}

}
