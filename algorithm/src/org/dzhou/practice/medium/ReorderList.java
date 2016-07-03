package org.dzhou.practice.medium;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author zhoudong
 *
 */
public class ReorderList {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {

		public void reorderList(ListNode head) {
			if (head == null || head.next == null)
				return;
			ListNode middle = findMiddle(head);
			ListNode half = reverse(middle.next);
			middle.next = null;
			merge(head, half);
		}

		private ListNode findMiddle(ListNode head) {
			if (head == null)
				return null;
			ListNode slow = head, fast = head;
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
		}

		private ListNode reverse(ListNode head) {
			if (head == null || head.next == null)
				return head;
			ListNode preHead = new ListNode(-1);
			while (head != null) {
				ListNode temp = head.next;
				head.next = preHead.next;
				preHead.next = head;
				head = temp;
			}
			return preHead.next;
		}

		private void merge(ListNode first, ListNode second) {
			while (first != null && second != null) {
				ListNode temp = second.next;
				second.next = first.next;
				first.next = second;
				first = second.next;
				second = temp;
			}
		}

	}

}
