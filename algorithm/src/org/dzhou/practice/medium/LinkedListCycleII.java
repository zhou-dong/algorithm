package org.dzhou.practice.medium;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Note: Do not modify the linked list.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @author zhoudong
 *
 *         1.遍历一一放入set中，如果已经出现过一次，说明有cycle，并且第一出线的就是cycle的起点.
 * 
 *         2.
 *         使用两个指针slow,fast。两个指针都从表头开始走，slow每次走一步，fast每次走两步，如果fast遇到null，则说明没有环，
 *         返回false；如果slow==fast，说明有环
 * 
 *         3.数学方法
 */
public class LinkedListCycleII {

	// Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class Solution {

		public ListNode detectCycle(ListNode head) {

			if (head == null || head.next == null)
				return null;

			ListNode slow = head, fast = head.next;
			while (fast != slow) {
				if (fast == null || fast.next == null)
					return null;
				fast = fast.next.next;
				slow = slow.next;
			}

			while (head != slow.next) {
				head = head.next;
				slow = slow.next;
			}
			return head;
		}

	}
}
