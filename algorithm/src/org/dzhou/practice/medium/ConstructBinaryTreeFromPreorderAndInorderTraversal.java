package org.dzhou.practice.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author zhoudong
 *
 *         graph of (In-order, Pre-order, Post-order traversal):
 *         https://en.wikipedia.org/wiki/Tree_traversal
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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

		public TreeNode buildTree(int[] preorder, int[] inorder) {
			if (preorder == null || inorder == null || preorder.length != inorder.length)
				return null;
			return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1,
					createInOrderIndex(inorder));
		}

		// 索引value在inOrder数组中的index，方便快速查抄。
		private Map<Integer, Integer> createInOrderIndex(int[] inorder) {
			Map<Integer, Integer> inOrderIndex = new HashMap<>();
			for (int i = 0; i < inorder.length; i++)
				inOrderIndex.put(inorder[i], i);
			return inOrderIndex;
		}

		// 1. PreOrder traversal的第一个元素，就是当前树的root。
		// 2. 在inOrder数组中，所有root前面的元素都在（树中）root的左边，root后面的元素都在（树中）root的右边。
		// 3. 循环1和2，就可以构建出整棵树。
		private TreeNode helper(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight,
				Map<Integer, Integer> inOrderIndex) {
			if (preLeft > preRight || inLeft > inRight)
				return null;
			TreeNode root = new TreeNode(preorder[preLeft]);
			// 元素在inOrder中的位置
			int index = inOrderIndex.get(root.val);
			root.left = helper(preorder, inorder, preLeft + 1, index - inLeft + preLeft, inLeft, index - 1,
					inOrderIndex);
			root.right = helper(preorder, inorder, preLeft + index - inLeft + 1, preRight, index + 1, inRight,
					inOrderIndex);
			return root;
		}

	}

}
