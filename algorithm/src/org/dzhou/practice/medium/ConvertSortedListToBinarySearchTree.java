package org.dzhou.practice.medium;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * @author zhoudong
 * 
 *         这个解法太棒了，我自己是想不出来的。
 * 
 *         http://bangbingsyb.blogspot.com/2014/11/leetcode-convert-sorted-list-to-binary.html
 */
public class ConvertSortedListToBinarySearchTree {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

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

		ListNode current;

		public TreeNode sortedListToBST(ListNode head) {
			if (head == null)
				return null;
			current = head;
			return sortedListToBST(0, listLength(head) - 1);
		}

		private TreeNode sortedListToBST(int start, int end) {
			if (start > end)
				return null;

			int mid = (start + end) / 2;
			TreeNode left = sortedListToBST(start, mid - 1);
			TreeNode root = new TreeNode(current.val);
			root.left = left;
			current = current.next;
			TreeNode right = sortedListToBST(mid + 1, end);
			root.right = right;

			return root;
		}

		private int listLength(ListNode head) {
			int len = 0;
			while (head != null) {
				len++;
				head = head.next;
			}
			return len;
		}

	}

}
