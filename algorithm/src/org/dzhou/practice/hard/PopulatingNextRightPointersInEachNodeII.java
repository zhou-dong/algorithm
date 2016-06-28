package org.dzhou.practice.hard;

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

			TreeLinkNode p = root.next;

			// 因此，这道题目首要是找到右孩子的第一个有效的next链接节点，然后再处理左孩子。然后依次递归处理右孩子，左孩子
			while (p != null) {
				if (p.left != null) {
					p = p.left;
					break;
				}
				if (p.right != null) {
					p = p.right;
					break;
				}
				p = p.next;
			}

			if (root.right != null) {
				root.right.next = p;
			}

			if (root.left != null) {
				if (root.right != null)
					root.left.next = root.right;
				else
					root.left.next = p;
			}

			connect(root.right);
			connect(root.left);
		}

	}

}
