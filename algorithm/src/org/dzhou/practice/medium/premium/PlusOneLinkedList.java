package org.dzhou.practice.medium.premium;

import java.util.Stack;

/**
 * Given a non-negative number represented as a singly linked list of digits,
 * plus one to the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * Example: <br>
 * Input: 1->2->3 <br>
 * Output: 1->2->4
 * 
 * @author zhoudong
 *
 */
public class PlusOneLinkedList {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// DFS version
	public class Solution {

		public ListNode plusOne(ListNode head) {
			if (head == null)
				return null;
			dfs(head);
			if (head.val != 0) {
				return head;
			} else {
				return newHead(head);
			}
		}

		private int dfs(ListNode node) {
			if (node.next == null) {
				return update(node, 1);
			}
			int carry = dfs(node.next);
			return update(node, carry);
		}

		// update and return carry
		private int update(ListNode node, int carry) {
			int val = node.val + carry;
			node.val = val % 10;
			return val / 10;
		}

		private ListNode newHead(ListNode head) {
			ListNode newHead = new ListNode(1);
			newHead.next = head;
			return newHead;
		}

	}

	// Stack version
	public class Solution1 {

		public ListNode plusOne(ListNode head) {
			if (head == null)
				return null;
			Stack<ListNode> stack = addNodesToStack(head);
			plus(stack);
			if (head.val != 0) {
				return head;
			} else {
				return newHead(head);
			}
		}

		private Stack<ListNode> addNodesToStack(ListNode head) {
			Stack<ListNode> stack = new Stack<>();
			while (head != null) {
				stack.add(head);
				head = head.next;
			}
			return stack;
		}

		private int plus(Stack<ListNode> stack) {
			stack.peek().val++;
			int carry = 0;
			while (!stack.isEmpty()) {
				ListNode node = stack.pop();
				int val = node.val + carry;
				node.val = val % 10;
				carry = val / 10;
			}
			return carry;
		}

		private ListNode newHead(ListNode head) {
			ListNode newHead = new ListNode(1);
			newHead.next = head;
			return newHead;
		}

	}

	// Reverse plus one reverse
	public class Solution2 {

		public ListNode plusOne(ListNode head) {
			if (head == null)
				return null;
			ListNode tail = reverse(head);
			plus(tail);
			reverse(tail);
			if (head.val != 0) {
				return head;
			} else {
				return newHead(head);
			}
		}

		// 1 2 3 4 5 6 7 8
		// 2 1 3 4 5 6 7 8
		// 3 2 1 4 5 6 7 8
		// 4 3 2 1 5 6 7 8
		private ListNode reverse(ListNode head) {
			ListNode fakeHead = new ListNode(0);
			fakeHead.next = head;
			while (head != null && head.next != null) {
				ListNode temp = fakeHead.next;
				fakeHead.next = head.next;
				head.next = fakeHead.next.next;
				fakeHead.next.next = temp;
			}
			return fakeHead.next;
		}

		private int plus(ListNode head) {
			int carry = 1;
			while (head != null) {
				int val = head.val + carry;
				head.val = val % 10;
				carry = val / 10;
				head = head.next;
			}
			return carry;
		}

		private ListNode newHead(ListNode head) {
			ListNode newHead = new ListNode(1);
			newHead.next = head;
			return newHead;
		}

	}

}
