package org.dzhou.research.cci.linkedlist;

/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1's digit
 * is at the head of the list. Write a function that adds two numbers and
 * returns the sum as a linked list.
 * 
 * FOLLOW UP: Suppose the digits are stored in forward order. Repeat the above
 * problem.
 * 
 * @author zhoudong
 *
 */
public class SumLists {

	class LinkedListNode {
		int data;
		LinkedListNode next;

		LinkedListNode(int data) {
			this.data = data;
		}
	}

	public class Solution {
		LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
			LinkedListNode dummy = new LinkedListNode(0);
			LinkedListNode current = dummy;
			int carry = 0;
			while (l1 != null || l2 != null) {
				int val = carry;
				if (l1 == null) {
					val += l2.data;
					l2 = l2.next;
				} else if (l2 == null) {
					val += l1.data;
					l1 = l1.next;
				} else {
					val += l1.data + l2.data;
					l1 = l1.next;
					l2 = l2.next;
				}
				current.next = new LinkedListNode(val % 10);
				carry = val / 10;
				current = current.next;
			}
			if (carry != 0)
				current.next = new LinkedListNode(1);
			return dummy.next;
		}
	}

	public class Solution1 {
		LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
			return addLists(l1, l2, 0);
		}

		LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
			if (l1 == null && l2 == null && carry == 0)
				return null;
			int value = carry;
			if (l1 != null)
				value += l1.data;
			if (l2 != null)
				value += l2.data;
			LinkedListNode result = new LinkedListNode(value % 10);
			if (l1 != null || l2 != null)
				result.next = addLists(l1 == null ? null : l1.next, l2 == null ? l2 : l2.next, carry / 10);
			return result;
		}
	}

}
