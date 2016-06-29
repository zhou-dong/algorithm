package org.dzhou.practice.medium;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * @author zhoudong
 *
 */
public class SortList {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {

		public ListNode sortList(ListNode head) {

			if (head == null || head.next == null)
				return head;

			ListNode slow = head, fast = head;
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}

			ListNode firstHalf = head, secondHalf = slow.next;
			slow.next = null;

			ListNode left = null, right = null;
			if (firstHalf != secondHalf) {
				left = sortList(firstHalf);
				right = sortList(secondHalf);
			}
			return merge(left, right);
		}

		public ListNode merge(ListNode left, ListNode right) {

			if (right == null)
				return left;
			if (left == null)
				return right;

			ListNode preHead = new ListNode(0);
			ListNode current = preHead;

			while (left != null && right != null) {
				if (right.val < left.val) {
					current.next = right;
					right = right.next;
				} else {
					current.next = left;
					left = left.next;
				}
				current = current.next;
			}

			if (left != null)
				current.next = left;
			if (right != null)
				current.next = right;

			return preHead.next;
		}

	}

}
