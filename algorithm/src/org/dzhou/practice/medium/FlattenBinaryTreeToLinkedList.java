package org.dzhou.practice.medium;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, Given
 * 
 * ---------1<br>
 * --------/-\<br>
 * -------2---5<br>
 * ------/-\---\<br>
 * -----3---4---6<br>
 * 
 * The flattened tree should look like:
 * 
 * ---1<br>
 * ----\<br>
 * -----2<br>
 * ------\<br>
 * -------3<br>
 * --------\<br>
 * ---------4<br>
 * ----------\<br>
 * -----------5<br>
 * ------------\<br>
 * -------------6<br>
 * 
 * Hints:
 * 
 * If you notice carefully in the flattened tree, each node's right child points
 * to the next node of a pre-order traversal.
 * 
 * @author zhoudong
 *
 */
public class FlattenBinaryTreeToLinkedList {

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

		TreeNode prev = null;

		public void flatten(TreeNode root) {

			if (root == null)
				return;

			if (prev != null) {
				prev.left = null;
				prev.right = root;
			}

			prev = root;
			// 因为右孩子会更新，所以为了递归右子树，要在更新之前提前保存右孩子。
			TreeNode right = root.right;
			flatten(root.left);
			flatten(right);
		}

	}

}
