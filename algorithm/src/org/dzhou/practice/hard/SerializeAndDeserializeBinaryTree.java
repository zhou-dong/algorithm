package org.dzhou.practice.hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * For example, you may serialize the following tree
 * 
 * ----1 ---/-\ --2---3 -----/-\ ----4---5 F * as "[1,2,3,null,null,4,5]", just
 * the same as how LeetCode OJ serializes a binary tree. You do not necessarily
 * need to follow this format, so please be creative and come up with different
 * approaches yourself. Note: Do not use class member/global/static variables to
 * store states. Your serialize and deserialize algorithms should be stateless.
 * 
 * @author zhoudong
 *
 */
public class SerializeAndDeserializeBinaryTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();
		s.test();
	}

	void test() {
		Codec codec = new Codec();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(codec.deserialize(codec.serialize(root)));
	}

	public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			return (root == null) ? "" : bfs(root);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data == null || data.length() == 0)
				return null;
			String[] vals = data.split(",");
			TreeNode[] nodes = new TreeNode[vals.length];
			int[] nulls = new int[vals.length]; // 节点i之前null节点的个数

			for (int i = 0; i < vals.length; i++) {
				if ("null".equals(vals[i])) {
					nulls[i] = nulls[i - 1] + 1;
				} else {
					if (i != 0)
						nulls[i] = nulls[i - 1];
					nodes[i] = new TreeNode(Integer.parseInt(vals[i]));
				}
			}

			for (int i = 0; i < nodes.length; i++) {
				TreeNode node = nodes[i];
				if (node == null) {
					continue;
				}
				node.left = nodes[2 * (i - nulls[i]) + 1];
				node.right = nodes[2 * (i - nulls[i]) + 2];
			}
			return nodes[0];
		}

		private String bfs(TreeNode root) {
			StringBuilder sb = new StringBuilder();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (node == null) {
					sb.append("null,");
				} else {
					sb.append(node.val).append(",");
					queue.add(node.left);
					queue.add(node.right);
				}
			}
			return sb.substring(0, sb.length() - 1).toString();
		}

	}
	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
}
