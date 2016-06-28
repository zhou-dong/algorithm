package org.dzhou.practice.hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution
 * still work?
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * 
 * For example, Given the following binary tree,
 * 
 * --------1<br>
 * -------/-\<br>
 * ------2---3<br>
 * -----/-\---\<br>
 * ----4---5---7<br>
 * 
 * After calling your function, the tree should look like:
 * 
 * --------1 -> NULL <br>
 * -------/-\<br>
 * ------2-->3 -> NULL<br>
 * -----/-\---\<br>
 * ----4-->5-->7 -> NULL<br>
 * 
 * @author zhoudong
 *
 */
public class PopulatingNextRightPointersInEachNodeII {

	// Definition for binary tree with next pointer.
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

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
}
