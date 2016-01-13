package org.dzhou.interview.treeandgraph;

/**
 * Implement of Binary Search Tree
 * 
 * @author DONG ZHOU
 *
 */
public class BinarySearchTreeImplement<T extends Comparable<? super T>> {

	public TreeNode<T> root;

	public boolean contains(T toFind) {
		TreeNode<T> current = root;
		while (current != null) {
			int compare = current.getData().compareTo(toFind);
			if (compare == 0)
				return true;
			else if (compare < 0)
				current = current.getLeft();
			else
				current = current.getRight();
		}
		return false;
	}

	public boolean insert(T toInsert) {
		TreeNode<T> current = root;
		TreeNode<T> parent = null;
		int compare = 0;
		while (current != null) {
			parent = current;
			compare = current.getData().compareTo(toInsert);
			if (compare == 0)
				return false;
			else if (compare < 0)
				current = current.getLeft();
			else
				current = current.getRight();
		}
		if (compare < 0)
			parent.addLeftChild(toInsert);
		else
			parent.addRightChild(toInsert);
		return true;
	}

	public T remove(T toRemove) {

		return toRemove;
	}

}
