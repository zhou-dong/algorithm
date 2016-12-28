package com.dzhou.interview.third;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 449. Serialize and Deserialize BST
 * 
 * Difficulty: Medium
 * 
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. There
 * is no restriction on how your serialization/deserialization algorithm should
 * work. You just need to ensure that a binary search tree can be serialized to
 * a string and this string can be deserialized to the original tree structure.
 * 
 * The encoded string should be as compact as possible.
 * 
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 * 
 * @author zhoudong
 *
 */
public class SerializeAndDeserializeBST {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Codec {

		private static final String SEP = ",";
		private static final String NULL = "null";

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null)
				return NULL;
			StringBuilder sb = new StringBuilder();
			Stack<TreeNode> st = new Stack<>();
			st.push(root);
			while (!st.empty()) {
				root = st.pop();
				sb.append(root.val).append(SEP);
				if (root.right != null)
					st.push(root.right);
				if (root.left != null)
					st.push(root.left);
			}
			return sb.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.equals(NULL))
				return null;
			Queue<Integer> q = new LinkedList<>();
			for (String e : data.split(SEP)) {
				q.offer(Integer.parseInt(e));
			}
			return getNode(q);
		}

		private TreeNode getNode(Queue<Integer> q) {
			if (q.isEmpty())
				return null;
			TreeNode root = new TreeNode(q.poll());
			Queue<Integer> samllerQueue = new LinkedList<>();
			while (!q.isEmpty() && q.peek() < root.val) {
				samllerQueue.offer(q.poll());
			}
			root.left = getNode(samllerQueue);
			root.right = getNode(q);
			return root;
		}
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));

}
