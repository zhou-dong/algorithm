package org.dzhou.practice.medium;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * Output: 7 -> 0 -> 8
 * 
 * @author zhoudong
 *
 */
public class AddTwoNumbers {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {

		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			if (l1 == null && l2 == null)
				return null;
			else if (l1 == null)
				return l2;
			else if (l2 == null)
				return l1;

			int carry = 0;
			ListNode head = new ListNode(0);
			ListNode curr = head;

			while (l1 != null && l2 != null) {
				int val = carry + l1.val + l2.val;
				curr.next = new ListNode(val % 10);
				carry = val / 10;
				l1 = l1.next;
				l2 = l2.next;
				curr = curr.next;
			}

			while (l1 != null) {
				int val = carry + l1.val;
				curr.next = new ListNode(val % 10);
				carry = val / 10;
				l1 = l1.next;
				curr = curr.next;
			}

			while (l2 != null) {
				int val = carry + l2.val;
				curr.next = new ListNode(val % 10);
				carry = val / 10;
				l2 = l2.next;
				curr = curr.next;
			}

			if (carry != 0) {
				curr.next = new ListNode(carry);
			}
			return head.next;
		}

	}

	public class Solution1 {

		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			if (l1 == null && l2 == null)
				return null;
			else if (l1 == null)
				return l2;
			else if (l2 == null)
				return l1;

			int carry = 0;
			ListNode head = new ListNode(0);
			ListNode curr = head;

			while (l1 != null || l2 != null) {
				int val = carry;
				if (l1 != null) {
					val += l1.val;
					l1 = l1.next;
				}
				if (l2 != null) {
					val += l2.val;
					l2 = l2.next;
				}
				curr.next = new ListNode(val % 10);
				carry = val / 10;
				curr = curr.next;
			}

			if (carry != 0) {
				curr.next = new ListNode(carry);
			}
			return head.next;
		}

	}
}
