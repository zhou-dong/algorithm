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
				return updateReturnCarry(node, 1);
			}
			int carry = dfs(node.next);
			return updateReturnCarry(node, carry);
		}

		private int updateReturnCarry(ListNode node, int carry) {
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

	// stack version
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

		private ListNode newHead(ListNode head) {
			ListNode newHead = new ListNode(1);
			newHead.next = head;
			return newHead;
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

		private Stack<ListNode> addNodesToStack(ListNode head) {
			Stack<ListNode> stack = new Stack<>();
			while (head != null) {
				stack.add(head);
				head = head.next;
			}
			return stack;
		}

	}

}
