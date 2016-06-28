package org.dzhou.practice.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree
 * 
 * struct TreeLinkNode {<br>
 * TreeLinkNode *left;<br>
 * TreeLinkNode *right;<br>
 * TreeLinkNode *next;<br>
 * }<br>
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * 
 * You may assume that it is a perfect binary tree (ie, all leaves are at the
 * same level, and every parent has two children).
 * 
 * For example,
 * 
 * Given the following perfect binary tree,
 * 
 * ---------1<br>
 * -------/--\<br>
 * ------2----3<br>
 * -----/-\---/-\<br>
 * ----4---5-6---7<br>
 * 
 * After calling your function, the tree should look like:
 * 
 * ---------1 -> NULL <br>
 * -------/--\<br>
 * ------2--->3 -> NULL<br>
 * -----/-\--/-\<br>
 * ----4->5->6->7 -> NULL<br>
 * 
 * @author zhoudong
 *
 */
public class PopulatingNextRightPointersInEachNode {

	// Definition for binary tree with next pointer.
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	// BFS
	public class Solution {

		public void connect(TreeLinkNode root) {
			if (root == null)
				return;
			Queue<TreeLinkNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeLinkNode curr = queue.poll();
					if (curr.left != null) {
						curr.left.next = curr.right;
						queue.add(curr.left);
					}
					TreeLinkNode right = curr.right;
					if (right == null)
						continue;
					if (i < size - 1)
						right.next = queue.peek().left;
					else
						right.next = null;
					queue.add(right);
				}
			}
		}

	}

	// DFS
	public class Solution1 {

		public void connect(TreeLinkNode root) {

			if (root == null)
				return;

			if (root.left != null)
				root.left.next = root.right;

			if (root.right != null) {
				if (root.next != null)
					root.right.next = root.next.left;
				else
					root.right.next = null;
			}

			connect(root.left);
			connect(root.right);
		}

	}

}
