package org.dzhou.practice.medium;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example,
 * 
 * Given 1->4->3->2->5->2 and x = 3,
 * 
 * return 1->2->2->4->3->5.
 * 
 * @author zhoudong
 *
 *         reference: http://www.cnblogs.com/springfor/p/3862392.html
 * 
 *         new两个新链表，一个用来创建所有大于等于x的链表，一个用来创建所有小于x的链表。
 */
public class PartitionList {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {

		public ListNode partition(ListNode head, int x) {

			if (head == null || head.next == null)
				return head;

			ListNode smaller = new ListNode(0);
			ListNode biggerOrEqual = new ListNode(0);
			ListNode sHead = smaller;
			ListNode bHead = biggerOrEqual;

			while (head != null) {
				if (head.val < x) {
					sHead.next = head;
					sHead = sHead.next;
				} else {
					bHead.next = head;
					bHead = bHead.next;
				}
				head = head.next;
			}

			bHead.next = null;
			sHead.next = biggerOrEqual.next;

			return smaller.next;
		}

	}

}
