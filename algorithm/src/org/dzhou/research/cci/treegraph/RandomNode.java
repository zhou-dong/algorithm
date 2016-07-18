package org.dzhou.research.cci.treegraph;

import java.util.Random;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         You are implementing a binary search tree class from scratch, which,
 *         in addition to insert, find and delete, has a method getRandomNode()
 *         which returns a random node from the tree. All nodes should be
 *         equally likely to be chosen. Design and implement an algorithm for
 *         getRandomNode, and explain how you would implement the rest of the
 *         methods.
 *
 */
public class RandomNode {

	class Solution {
		public TreeNode getRandomNode(TreeNode root) {
			int leftSize = (root.left == null) ? 0 : root.left.size;
			int index = new Random().nextInt(root.size());
			if (index == leftSize) {
				return root;
			} else if (index < leftSize) {
				return getRandomNode(root.left);
			} else {
				return getRandomNode(root.right);
			}
		}
	}

	class Solution2 {
		TreeNode root = null;

		public TreeNode getRandomNode(TreeNode root) {
			if (root == null)
				return null;
			return root.getIthNode(new Random().nextInt(root.size()));
		}

		public void insertInOrder(int data) {
			if (root == null) {
				root = new TreeNode(data);
			} else {
				root.insertInOrder(data);
			}
		}
	}

	class TreeNode {
		private int data;
		private int size;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int data) {
			this.data = data;
			size = 1;
		}

		// binary search tree insert data method
		public void insertInOrder(int data) {
			if (data <= this.data) {
				if (left == null) {
					left = new TreeNode(data);
				} else {
					left.insertInOrder(data);
				}
			} else {
				if (right == null) {
					right = new TreeNode(data);
				} else {
					right.insertInOrder(data);
				}
			}
			size++;
		}

		// binary search tree find node method
		public TreeNode find(int data) {
			if (data == this.data)
				return this;
			else if (data <= this.data)
				return left != null ? left.find(data) : null;
			else if (data > this.data)
				return right != null ? right.find(data) : null;
			return null;
		}

		// binary search tree get iTh node
		public TreeNode getIthNode(int i) {
			int leftSize = (left == null) ? 0 : left.size();
			if (i < leftSize) {
				return left.getIthNode(i);
			} else if (i == leftSize) {
				return this;
			} else {
				return right.getIthNode(i - (leftSize + 1));
			}
		}

		public int data() {
			return this.data;
		}

		public int size() {
			return size;
		}

	}

}
