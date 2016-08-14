package org.dzhou.practice.medium.premium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Given a binary tree, return the vertical order traversal of its nodes'
 * values. (ie, from top to bottom, column by column).
 * 
 * If two nodes are in the same row and column, the order should be from left to
 * right.
 * 
 * @author zhoudong
 *
 */
public class BinaryTreeVerticalOrderTraversal {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {

		public List<List<Integer>> verticalOrder(TreeNode root) {
			if (root == null)
				return Collections.emptyList();

			Map<Integer, List<Integer>> map = new HashMap<>();
			int begin = 0;

			Queue<TreeNode> queue = new LinkedList<>();
			Queue<Integer> indices = new LinkedList<>();
			queue.add(root);
			indices.add(0);

			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				int index = indices.poll();
				begin = Math.min(begin, index);
				addItem(map, index, node.val);
				if (node.left != null) {
					queue.add(node.left);
					indices.add(index - 1);
				}
				if (node.right != null) {
					queue.add(node.right);
					indices.add(index + 1);
				}
			}

			List<List<Integer>> result = new ArrayList<>();
			for (int i = 0; i < map.size(); i++) {
				result.add(map.get(begin++));
			}
			return result;
		}

		private void addItem(Map<Integer, List<Integer>> map, int key, int value) {
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());
			map.get(key).add(value);
		}
	}

	// Wrong Answer
	// Input:---[3,9,8,4,0,1,7,null,null,null,2,5]
	// Output:--[[4],[9,5],[3,0,1],[2,8],[7]]
	// Expected:[[4],[9,5],[3,0,1],[8,2],[7]]
	public class Solution1 {
		int begin = 0;

		public List<List<Integer>> verticalOrder(TreeNode root) {
			if (root == null)
				return Collections.emptyList();

			Map<Integer, List<Integer>> map = new HashMap<>();
			dfs(root, 0, map);

			List<List<Integer>> result = new ArrayList<>();
			for (int i = 0; i < map.size(); i++) {
				result.add(map.get(begin++));
			}
			return result;
		}

		private void dfs(TreeNode root, int index, Map<Integer, List<Integer>> map) {
			if (root == null)
				return;
			begin = Math.min(begin, index);
			addItem(map, index, root.val);
			dfs(root.left, index - 1, map);
			dfs(root.right, index + 1, map);
		}

		private void addItem(Map<Integer, List<Integer>> map, int key, int value) {
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());
			map.get(key).add(value);
		}
	}

}
