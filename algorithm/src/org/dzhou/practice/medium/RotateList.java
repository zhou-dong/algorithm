package org.dzhou.practice.medium;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example:
 * 
 * Given 1->2->3->4->5->NULL and k = 2,
 * 
 * return 4->5->1->2->3->NULL.
 * 
 * @author zhoudong
 *
 *
 *         参考自：http://www.cnblogs.com/springfor/p/3864411.html
 *
 *         1. 通过faster/slower双指针。
 *
 *         2.把整个list连起来变成环，找到切分点断开。
 */
public class RotateList {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {

		public ListNode rotateRight(ListNode head, int k) {

			if (head == null || k == 0)
				return head;

			int length = length(head);
			k %= length;
			if (k == 0)
				return head;

			ListNode slow = head, fast = head;
			for (int i = 0; i < k; i++)
				fast = fast.next;

			while (fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}

			ListNode newHead = slow.next;
			fast.next = head;
			slow.next = null;
			return newHead;
		}

		private int length(ListNode head) {
			int len = 0;
			while (head != null) {
				head = head.next;
				len++;
			}
			return len;
		}

	}

	// 把整个list连起来变成环，找到切分点断开。
	public class Solution1 {

		public ListNode rotateRight(ListNode head, int n) {

			if (head == null || n == 0)
				return head;

			int length = 1;
			ListNode last = head;
			while (last.next != null) {
				last = last.next;
				length++;
			}

			n %= length;
			if (n == 0)
				return head;

			last.next = head; // form a loop
			for (int i = 0; i < length - n; i++)
				last = last.next;

			head = last.next;
			last.next = null;

			return head;
		}
	}

}
