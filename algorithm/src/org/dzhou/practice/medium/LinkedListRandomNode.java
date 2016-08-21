package org.dzhou.practice.medium;

import java.util.Random;

/***
 * 382. Linked List Random Node
 * 
 * Given a singly linked list, return a random node's value from the linked
 * list. Each node must have the same probability of being chosen.
 * 
 * Follow up: What if the linked list is extremely large and its length is
 * unknown to you? Could you solve this efficiently without using extra space?
 * 
 * @author zhoudong
 *
 */
public class LinkedListRandomNode {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {

		Random random = null;
		ListNode head = null;

		/**
		 * @param head
		 *            The linked list's head. Note that the head is guaranteed
		 *            to be not null, so it contains at least one node.
		 */
		public Solution(ListNode head) {
			random = new Random();
			this.head = head;
		}

		/** Returns a random node's value. */
		public int getRandom() {
			int ans = 0;
			ListNode p = head;
			for (int cnt = 1; p != null; cnt++, p = p.next)
				if (random.nextInt(cnt) == 0)
					ans = p.val;
			return ans;
		}

	}

	// Your Solution object will be instantiated and called as such:
	// Solution obj = new Solution(head);
	// int param_1 = obj.getRandom();
}
