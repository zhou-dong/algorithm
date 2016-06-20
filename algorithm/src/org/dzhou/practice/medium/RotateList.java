package org.dzhou.practice.medium;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example:
 * 
 * Given 1->2->3->4->5->NULL and k = 2,
 * 
 * return 4->5->1->2->3->NULL.
 * 
 * @author zhoudong
 *
 */
public class RotateList {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {

		public ListNode rotateRight(ListNode head, int k) {

			if (head == null)
				return null;

			int length = length(head);
			k %= length;
			if (k == 0)
				return head;

			ListNode slow = head, fast = head;
			for (int i = 0; i < k; i++)
				fast = fast.next;

			while (fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}

			ListNode newHead = slow.next;
			fast.next = head;
			slow.next = null;
			return newHead;
		}

		private int length(ListNode head) {
			int len = 0;
			while (head != null) {
				head = head.next;
				len++;
			}
			return len;
		}

	}

	public class Solution1 {
	}

}
