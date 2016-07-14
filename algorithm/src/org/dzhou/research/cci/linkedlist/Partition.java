package org.dzhou.research.cci.linkedlist;

/**
 * Write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than or equal to x. If x is
 * contained within the list, the values of x only need to be after the elements
 * less than x.
 * 
 * @author zhoudong
 *
 */
public class Partition {

	class LinkedListNode {
		int data;
		LinkedListNode next;

		LinkedListNode(int data) {
			this.data = data;
		}
	}

	public class Solution {
		LinkedListNode partition(LinkedListNode node, int x) {
			LinkedListNode before = null;
			LinkedListNode current1 = null;
			LinkedListNode after = null;
			LinkedListNode current2 = null;
			while (node != null) {
				if (node.data < x) {
					if (before == null) {
						before = node;
						current1 = node;
					} else {
						current1.next = node;
						current1 = current1.next;
					}
				} else {
					if (after == null) {
						after = node;
						current2 = node;
					} else {
						current2.next = node;
						current2 = current2.next;
					}
				}
				node = node.next;
			}
			if (current2 != null)
				current2.next = null;
			if (before == null)
				return after;
			current1.next = after;
			return before;
		}
	}

	// 小于X的放在前半部分，大于等于的放在后半部分。
	public class Solution1 {
		LinkedListNode partition(LinkedListNode node, int x) {
			if (node == null || node.next == null)
				return node;
			LinkedListNode head = node;
			LinkedListNode tail = node;
			while (node != null) {
				if (node.data < x) {
					node.next = head;
					head = node;
				} else {
					tail.next = node;
					tail = node;
				}
				node = node.next;
			}
			tail.next = null;
			return head;
		}
	}

}
