package org.dzhou.practice.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author zhoudong
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

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

		public TreeNode buildTree(int[] inorder, int[] postorder) {
			if (postorder == null || inorder == null || postorder.length != inorder.length)
				return null;
			return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1,
					createInOrderIndex(inorder));
		}

		// 索引value在inOrder数组中的index，方便快速查抄。
		private Map<Integer, Integer> createInOrderIndex(int[] inorder) {
			Map<Integer, Integer> inOrderIndex = new HashMap<>();
			for (int i = 0; i < inorder.length; i++)
				inOrderIndex.put(inorder[i], i);
			return inOrderIndex;
		}

		// 1. PostOrder traversal的最后一个元素，就是当前树的root。
		// 2. 在inOrder数组中，所有root前面的元素都在（树中）root的左边，root后面的元素都在（树中）root的右边。
		// 3. 循环1和2，就可以构建出整棵树。
		private TreeNode helper(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight,
				Map<Integer, Integer> inOrderIndex) {
			if (postLeft > postRight || inLeft > inRight)
				return null;
			TreeNode root = new TreeNode(postorder[postRight]);
			// 元素在inOrder中的位置
			int index = inOrderIndex.get(root.val);
			root.left = helper(inorder, postorder, inLeft, index - 1, postLeft, postLeft + index - inLeft - 1,
					inOrderIndex);
			root.right = helper(inorder, postorder, index + 1, inRight, postRight - (inRight - index), postRight - 1,
					inOrderIndex);
			return root;
		}
	}

}
