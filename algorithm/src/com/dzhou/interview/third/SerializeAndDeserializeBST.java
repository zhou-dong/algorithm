package com.dzhou.interview.third;

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
			preorder(root, sb);
			return sb.toString();
		}

		private void preorder(TreeNode root, StringBuilder sb) {
			if (root == null)
				return;
			sb.append(root.val).append(",");
			preorder(root.left, sb);
			preorder(root.right, sb);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.equals(NULL))
				return null;
			int[] preorder = strToInt(data);
			return deserialize(preorder, 0, preorder.length - 1);
		}

		private int[] strToInt(String data) {
			String[] strs = data.split(SEP);
			int[] result = new int[strs.length];
			for (int i = 0; i < result.length; i++) {
				result[i] = Integer.parseInt(strs[i]);
			}
			return result;
		}

		private TreeNode deserialize(int[] preorder, int low, int high) {
			if (low > high)
				return null;
			TreeNode root = new TreeNode(preorder[low]);
			int division = findDivision(preorder, root.val, low, high);
			root.left = deserialize(preorder, low + 1, division - 1);
			root.right = deserialize(preorder, division, high);
			return root;
		}

		private int findDivision(int[] preorder, int value, int low, int high) {
			while (low <= high) {
				if (value < preorder[low]) {
					break;
				} else {
					low++;
				}
			}
			return low;
		}

	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
}