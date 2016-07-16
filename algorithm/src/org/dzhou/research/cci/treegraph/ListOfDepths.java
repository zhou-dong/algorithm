package org.dzhou.research.cci.treegraph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class ListOfDepths {

	class TreeNode<T> {
		T value;
		TreeNode<T> left;
		TreeNode<T> right;

		TreeNode(T value) {
			this.value = value;
		}
	}

	public class Solution<T> {
		List<List<TreeNode<T>>> createLevelLinkedList(TreeNode<T> root) {
			return bfs(root);
		}

		private List<List<TreeNode<T>>> bfs(TreeNode<T> root) {
			if (root == null)
				return Collections.emptyList();
			List<List<TreeNode<T>>> result = new LinkedList<>();
			Queue<TreeNode<T>> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				List<TreeNode<T>> item = new LinkedList<>();
				for (int i = 0; i < size; i++) {
					TreeNode<T> node = queue.poll();
					item.add(node);
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
				}
				result.add(item);
			}
			return result;
		}
	}

	public class Solution1<T> {
		List<List<TreeNode<T>>> createLevelLinkedList(TreeNode<T> root) {
			if (root == null)
				return Collections.emptyList();
			List<List<TreeNode<T>>> result = new LinkedList<>();
			dfs(root, result, 0);
			return result;
		}

		private void dfs(TreeNode<T> root, List<List<TreeNode<T>>> result, int level) {
			if (root == null)
				return;
			if (result.size() == level)
				result.add(new LinkedList<>());
			result.get(level).add(root);
			dfs(root.left, result, level + 1);
			dfs(root.right, result, level + 1);
		}
	}

}
