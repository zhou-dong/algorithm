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

	public void createLevelLinkedList(TreeNode<?> node, ArrayList<LinkedList<TreeNode<?>>> lists,
			int level) {

	}

}
