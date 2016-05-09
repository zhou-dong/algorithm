package org.dzhou.practice.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @author DONG ZHOU
 *
 */
public class LinkedListCycle {

	// Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		ListNode speed = head;
		while (speed != null && speed.next != null) {
			head = head.next;
			speed = speed.next.next;
			if (head == speed)
				return true;
		}
		return false;
	}

	public boolean hasCycle1(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while (head != null) {
			if (set.contains(head))
				return true;
			set.add(head);
			head = head.next;
		}
		return false;
	}

}
