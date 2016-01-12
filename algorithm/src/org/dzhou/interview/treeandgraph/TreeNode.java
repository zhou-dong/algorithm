package org.dzhou.interview.treeandgraph;

public class TreeNode<T> {

	public TreeNode(T data) {
		this.data = data;
	}

	public TreeNode(T data, TreeNode<T> parent) {
		this.data = data;
		this.parent = parent;
	}

	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode<T> parent;

	public TreeNode<T> addLeftChild(T data) {
		this.left = new TreeNode<T>(data, this);
		return this.left;
	}

	public TreeNode<T> addRightChild(T data) {
		this.right = new TreeNode<T>(data, this);
		return this.right;
	}

}
