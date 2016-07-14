package org.dzhou.research.cci.linkedlist;

/**
 * Given a circular linked list, implement an algorithm that returns the node at
 * the beginning of the loop.
 * 
 * @author zhoudong
 *
 */
public class LoopDetection {

	class LinkedListNode {
		int data;
		LinkedListNode next;
	}

	LinkedListNode findBeginning(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}

		if (fast == null || fast.next == null)
			return null;

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}

}
