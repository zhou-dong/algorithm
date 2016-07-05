package org.dzhou.practice.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * @author zhoudong
 *
 *         3种方法：
 *
 *         1. 逐个合并
 *
 *         2. 两两合并
 *
 *         3. 使用priority queue
 */
public class MergeKSortedLists {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {

		public ListNode mergeKLists(ListNode[] lists) {

			if (lists == null || lists.length == 0)
				return null;
			if (lists.length == 1)
				return lists[0];

			ListNode preHead = new ListNode(0);
			ListNode current = preHead;
			PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
				@Override
				public int compare(ListNode o1, ListNode o2) {
					return o1.val - o2.val;
				}
			});

			for (ListNode head : lists) {
				if (head != null)
					queue.add(head);
			}

			while (!queue.isEmpty()) {
				ListNode temp = queue.poll();
				current.next = temp;
				current = temp;
				if (temp.next != null) {
					queue.add(temp.next);
					temp.next = null;
				}
			}

			return preHead.next;
		}

	}

}
