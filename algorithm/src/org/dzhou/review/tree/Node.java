package org.dzhou.review.tree;

public class Node<T> {

	private T data;
	private Node<T> left;
	private Node<T> right;
	private Node<T> parent;

	public Node(T data) {
		this.data = data;
	}

	public Node(T data, Node<T> parent) {
		this.data = data;
		this.parent = parent;
	}

	public Node<T> addLeftChild(T data) {
		this.left = new Node<T>(data, this);
		return this.left;
	}

	public Node<T> addRightChild(T data) {
		this.right = new Node<T>(data, this);
		return this.right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

}
