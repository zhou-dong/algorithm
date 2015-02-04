package org.dzhou.research.algorithm.tree;

/**
 * Implementation of AVL tree
 * 
 * Base on "Justin Ethier" the implement of AvlTree and code on:
 * https://github.com/justinethier/AVL-Tree/blob/master/AvlTree.java
 * 
 */
public class AvlTree<T extends Comparable<? super T>> {

	protected static class AvlNode<T> {

		protected T element;
		protected AvlNode<T> leftChild;
		protected AvlNode<T> rightChild;
		protected int height;

		public AvlNode(T element) {
			this(element, null, null);
		}

		public AvlNode(T element, AvlNode<T> leftChild, AvlNode<T> rightChild) {
			this.element = element;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

	}

	public AvlNode<T> insert(T element, AvlNode<T> node) throws Exception {

		if (node == null) {
			node = new AvlNode<T>(element);
			node.height = calculateHeight(node);
			return node;
		}

		if (element.compareTo(node.element) == 0)
			throw new Exception("Attempting to insert duplicate value");

		if (element.compareTo(node.element) < 0) {
			node.leftChild = insert(element, node.leftChild);
			if (gapHeightBetweenTwoNodes(node.leftChild, node.rightChild) == 2)
				if (element.compareTo(node.leftChild.element) < 0)
					node = rotateWithLeftChild(node);
				else
					node = doubleWithLeftChild(node);
			node.height = calculateHeight(node);
			return node;
		}

		node.rightChild = insert(element, node.rightChild);
		if (gapHeightBetweenTwoNodes(node.rightChild, node.leftChild) == 2)
			if (element.compareTo(node.rightChild.element) > 0)
				node = rotateWithRightChild(node);
			else
				node = doubleWithRightChild(node);
		node.height = calculateHeight(node);
		return node;
	}

	protected AvlNode<T> rotateWithLeftChild(AvlNode<T> node) {

		AvlNode<T> result = node.leftChild;

		node.leftChild = result.rightChild;
		result.rightChild = node;

		node.height = calculateHeight(node);
		result.height = calculateHeight(result);

		return result;

	}

	protected AvlNode<T> doubleWithLeftChild(AvlNode<T> node) {
		node.leftChild = rotateWithRightChild(node.leftChild);
		return rotateWithLeftChild(node);
	}

	protected AvlNode<T> rotateWithRightChild(AvlNode<T> node) {

		AvlNode<T> result = node.rightChild;

		node.rightChild = result.leftChild;
		result.leftChild = node;

		node.height = calculateHeight(node);
		result.height = calculateHeight(result);

		return result;

	}

	protected AvlNode<T> doubleWithRightChild(AvlNode<T> node) {
		node.rightChild = rotateWithLeftChild(node.rightChild);
		return rotateWithRightChild(node);
	}

	protected int calculateHeight(AvlNode<T> node) {
		return getMax(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
	}

	protected int gapHeightBetweenTwoNodes(AvlNode<T> a, AvlNode<T> b) {
		return getHeight(a) - getHeight(b);
	}

	protected int getMax(int i, int j) {
		if (i > j)
			return i;
		return j;
	}

	protected int getHeight(AvlNode<T> node) {
		return node == null ? -1 : node.height;
	}

	public static void main(String[] args) {
		int[] test = { 6, 8, 7, 4, 5, 2, 1, 9, 10 };
		for (int i : test)
			System.out.print(i + " ");
	}

}