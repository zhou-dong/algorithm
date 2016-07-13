package org.dzhou.research.cci.linkedlist;

/**
 * Implement an algorithm to find the kTh to last element of a singly linked
 * list.
 * 
 * @author zhoudong
 *
 *         Solution:
 *
 *         1. slow, fast node to find<br>
 *         2. recursive
 */
public class ReturnKthToLast {

	class LinkedListNode {
		int val;
		LinkedListNode next;
	}

	// slow and fast node
	public class Solution {
		LinkedListNode nthToLast(LinkedListNode head, int k) {
			LinkedListNode slow = head;
			LinkedListNode fast = head;
			for (int i = 0; i < k; i++) {
				if (fast == null)
					return null;
				fast = fast.next;
			}
			while (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
	}

	// recursive
	public class Solution1 {
		class Index {
			public int value = 0;
		}

		LinkedListNode nthToLast(LinkedListNode head, int k) {
			return nthToLast(head, k, new Index());
		}

		LinkedListNode nthToLast(LinkedListNode head, int k, Index index) {
			if (head == null)
				return null;
			LinkedListNode node = nthToLast(head.next, k, index);
			if (++index.value == k)
				return head;
			return node;
		}
	}

}
