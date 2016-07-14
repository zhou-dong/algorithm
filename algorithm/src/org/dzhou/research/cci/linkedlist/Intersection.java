package org.dzhou.research.cci.linkedlist;

/**
 * Given two singly linked list, determine if the two lists intersect. Return
 * the intersecting node. Note that the intersection is defined based on
 * reference, not value. That is, if the kTh node of the first linked list is
 * the exact same node as the jTh node of the second linked list, then they are
 * intersecting.
 * 
 * @author zhoudong
 *
 */
public class Intersection {

	class LinkedListNode {
		int data;
		LinkedListNode next;
	}

	public class Solution {
		class Result {
			int size;
			LinkedListNode tail;

			Result(LinkedListNode tail, int size) {
				this.tail = tail;
				this.size = size;
			}
		}

		LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
			if (list1 == null || list2 == null)
				return null;
			Result result1 = getTailAndSize(list1);
			Result result2 = getTailAndSize(list2);
			// 如果最后一个node相等，说明有intersection.
			if (result1.tail != result2.tail)
				return null;
			LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
			LinkedListNode longer = result1.size < result2.size ? list2 : list1;
			// equal the length of two lists.
			longer = getkthNode(longer, Math.abs(result1.size - result2.size));
			while (shorter != longer) {
				shorter = shorter.next;
				longer = longer.next;
			}
			return longer;
		}

		Result getTailAndSize(LinkedListNode list) {
			if (list == null)
				return null;
			int size = 1;
			LinkedListNode current = list;
			while (current.next != null) {
				size++;
				current = current.next;
			}
			return new Result(current, size);
		}

		LinkedListNode getkthNode(LinkedListNode head, int k) {
			for (int i = 0; i < k; i++)
				head = head.next;
			return head;
		}
	}

}
