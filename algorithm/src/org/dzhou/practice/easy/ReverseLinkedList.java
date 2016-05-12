package org.dzhou.practice.easy;

import java.util.Stack;

/**
 * Reverse a singly linked list.
 * 
 * Hint: A linked list can be reversed either iteratively or recursively. Could
 * you implement both?
 * 
 * @author zhoudong
 *
 */
public class ReverseLinkedList {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	public ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}

	public ListNode reverseList2(ListNode head) {
		if (head == null)
			return null;
		Stack<ListNode> stack = new Stack<>();
		while (head != null) {
			stack.add(head);
			head = head.next;
		}
		ListNode result = stack.pop();
		ListNode current = result;
		while (!stack.isEmpty()) {
			current.next = stack.pop();
			current = current.next;
		}
		return result;
	}

}
