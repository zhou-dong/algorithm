package org.dzhou.interview.treeandgraph;

public class TreeNode<T> {

	public TreeNode(T data) {
		this.data = data;
	}

	public TreeNode(T data, TreeNode<T> parent) {
		this.data = data;
		this.parent = parent;
	}

	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;
	private TreeNode<T> parent;

	public TreeNode<T> addLeftChild(T data) {
		this.left = new TreeNode<T>(data, this);
		return this.left;
	}

	public TreeNode<T> addRightChild(T data) {
		this.right = new TreeNode<T>(data, this);
		return this.right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}

}
