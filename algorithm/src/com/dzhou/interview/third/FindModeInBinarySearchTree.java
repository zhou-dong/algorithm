package com.dzhou.interview.third;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the
 * most frequently occurred element) in the given BST.
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key.
 * 
 * The right subtree of a node contains only nodes with keys greater than or
 * equal to the node's key.
 * 
 * Both the left and right subtrees must also be binary search trees.
 * 
 * Note: If a tree has more than one mode, you can return them in any order.
 * 
 * Follow up: Could you do that without using any extra space? (Assume that the
 * implicit stack space incurred due to recursion does not count).
 * 
 * @author zhoudong
 *
 */
public class FindModeInBinarySearchTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Traverse_Solution {

		public int[] findMode(TreeNode root) {
			Map<Integer, Integer> map = new HashMap<>();
			inorder(root, map);
			int maxCount = 1;
			for (int key : map.keySet()) {
				int count = map.get(key);
				if (count > maxCount) {
					maxCount = count;
				}
			}
			List<Integer> list = new ArrayList<>();
			for (int key : map.keySet()) {
				int count = map.get(key);
				if (count == maxCount) {
					list.add(key);
				}
			}
			return listToArray(list);
		}

		private void inorder(TreeNode root, Map<Integer, Integer> map) {
			if (root == null)
				return;
			inorder(root.left, map);
			addToMap(map, root);
			inorder(root.right, map);
		}

		private void addToMap(Map<Integer, Integer> map, TreeNode root) {
			int preValue = map.getOrDefault(root.val, 0);
			map.put(root.val, preValue + 1);
		}

		private int[] listToArray(List<Integer> list) {
			int[] result = new int[list.size()];
			for (int i = 0; i < result.length; i++) {
				result[i] = list.get(i);
			}
			return result;
		}

	}

}
