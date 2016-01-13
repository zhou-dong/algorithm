package org.dzhou.interview.treeandgraph;

/**
 * 
 * @author DONG ZHOU
 *
 */
public class BinarySearchTreeImplement<T extends Comparable<T>> {

	public TreeNode<T> root;

	public boolean contains(TreeNode<T> toFind) {
		TreeNode<T> current = root;
		while (current != null) {
			int compare = current.getData().compareTo(toFind.getData());
			if (compare == 0)
				return true;
			else if (compare < 0)
				current = current.getLeft();
			else
				current = current.getRight();
		}
		return false;
	}
}
