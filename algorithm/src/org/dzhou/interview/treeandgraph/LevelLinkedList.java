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

	public ArrayList<LinkedList<TreeNode<?>>> createLevelLinkedList(TreeNode<?> node) {
		ArrayList<LinkedList<TreeNode<?>>> lists = new ArrayList<>();
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
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}

}
