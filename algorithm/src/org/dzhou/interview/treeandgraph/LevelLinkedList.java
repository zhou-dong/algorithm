package org.dzhou.interview.treeandgraph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Practice of "cracking the code interview"
 * 
 * Given a binary tree, design an algorithm which creates a linked list of all
 * the nodes at each depth.(e.g. if you have a tree with depth D, you will have
 * D linked list).
 * 
 * @author DONG ZHOU
 *
 */
public class LevelLinkedList {

	public ArrayList<LinkedList<TreeNode<?>>> createLevelLinkedList(TreeNode<?> root) {
		ArrayList<LinkedList<TreeNode<?>>> lists = new ArrayList<>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}

	public void createLevelLinkedList(TreeNode<?> root, ArrayList<LinkedList<TreeNode<?>>> lists,
			int level) {
		if (root == null)
			return;
		LinkedList<TreeNode<?>> list = null;
		if (lists.size() == level) {
			list = new LinkedList<>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.getLeft(), lists, level + 1);
		createLevelLinkedList(root.getRight(), lists, level + 1);
	}

	public ArrayList<LinkedList<TreeNode<?>>> createLevelLinkedList2(TreeNode<?> root) {
		if (root == null)
			return null;
		ArrayList<LinkedList<TreeNode<?>>> result = new ArrayList<>();
		LinkedList<TreeNode<?>> current = new LinkedList<>();
		current.add(root);
		while (current.size() > 0) {
			result.add(current);
			LinkedList<TreeNode<?>> parents = current;
			current = new LinkedList<>();
			for (TreeNode<?> parent : parents) {
				if (parent.getLeft() != null)
					current.add(parent.getLeft());
				if (parent.getRight() != null)
					current.add(parent.getRight());
			}
		}
		return result;
	}

}