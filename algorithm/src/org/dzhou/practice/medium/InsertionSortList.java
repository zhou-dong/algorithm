package org.dzhou.practice.medium;

/**
 * Sort a linked list using insertion sort.
 * 
 * @author zhoudong
 *
 */
public class InsertionSortList {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {

		public ListNode insertionSortList(ListNode head) {

			if (head == null || head.next == null)
				return head;

			ListNode fakeHead = new ListNode(0);
			while (head != null) {
				ListNode next = head.next;
				ListNode pre = fakeHead;
				while (pre.next != null && pre.next.val < head.val)
					pre = pre.next;
				head.next = pre.next;
				pre.next = head;
				head = next;
			}

			return fakeHead.next;
		}

	}

}
