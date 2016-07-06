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

	// Solution with heap (priority queue)
	public class Solution {

		public ListNode mergeKLists(ListNode[] lists) {

			if (lists == null || lists.length == 0)
				return null;
			if (lists.length == 1)
				return lists[0];

			// initial heap
			PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
				@Override
				public int compare(ListNode o1, ListNode o2) {
					return o1.val - o2.val;
				}
			});

			// construction heap with height = list.length;
			for (ListNode head : lists) {
				if (head != null) {
					queue.add(head);
				}
			}

			// create dummy head
			ListNode preHead = new ListNode(0);
			ListNode current = preHead;

			// 1. poll the minimal node from heap
			// 2. connect node result
			// 3. add the next of node into heap
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

	// merge two by two
	public class Solution1 {

		public ListNode mergeKLists(ListNode[] lists) {

			if (lists == null || lists.length == 0)
				return null;
			if (lists.length == 1)
				return lists[0];

			ListNode[] result = getNewList(lists);
			while (result.length > 1)
				result = getNewList(result);

			return result[0];
		}

		private ListNode[] getNewList(ListNode[] lists) {
			int len = lists.length / 2 + (lists.length % 2 == 0 ? 0 : 1);
			ListNode[] result = new ListNode[len];
			int left = 0, right = lists.length - 1;
			while (left <= right) {
				if (left == right)
					result[left] = lists[left];
				else
					result[left] = merge(lists[left], lists[right]);
				left++;
				right--;
			}
			return result;
		}

		private ListNode merge(ListNode node1, ListNode node2) {
			ListNode preHead = new ListNode(0);
			ListNode current = preHead;
			while (node1 != null && node2 != null) {
				if (node1.val < node2.val) {
					current.next = node1;
					node1 = node1.next;
				} else {
					current.next = node2;
					node2 = node2.next;
				}
				current = current.next;
			}
			current.next = null;
			if (node1 != null) {
				current.next = node1;
			} else if (node2 != null) {
				current.next = node2;
			}
			return preHead.next;
		}

	}

}
