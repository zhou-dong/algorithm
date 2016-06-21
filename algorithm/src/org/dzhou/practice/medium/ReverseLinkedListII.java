package org.dzhou.practice.medium;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * 
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * 
 * @author zhoudong
 *
 */
public class ReverseLinkedListII {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {

		public ListNode reverseBetween(ListNode head, int m, int n) {
			if (m >= n || head == null)
				return head;

			ListNode preHead = new ListNode(0);
			preHead.next = head;
			head = preHead;

			// head: the node previous m
			for (int i = 1; i < m; i++) {
				if (head == null)
					return null;
				head = head.next;
			}

			ListNode prev = head;
			ListNode mNode = prev.next;
			ListNode curr = mNode.next;

			// Given: 1->2->3->4->5->NULL, m = 2 and n = 4,
			// return 1->4->3->2->5->NULL.
			for (int i = m; i < n; i++) {
				if (curr == null)
					return null;
				ListNode next = curr.next;
				curr.next = prev.next;
				prev.next = curr;
				mNode.next = next;
				curr = next;
			}

			return preHead.next;
		}

	}

}
