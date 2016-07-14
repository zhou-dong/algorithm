package org.dzhou.research.cci.linkedlist;

import java.util.Stack;

/**
 * Implement a function to check if a linked list is palindrome.
 * 
 * @author zhoudong
 *
 *         1. Reverse and compare<br>
 *         2. Iterative Approach<br>
 *         3. Recursive Approach<br>
 */
public class Palindrome {

	class LinkedListNode {
		int data;
		LinkedListNode next;

		LinkedListNode(int data) {
			this.data = data;
		}
	}

	// Reverse and compare
	public class Solution {
		boolean isPalindrome(LinkedListNode head) {
			return isEqual(head, reverse(head));
		}

		LinkedListNode reverse(LinkedListNode head) {
			LinkedListNode preHead = new LinkedListNode(0);
			while (head != null) {
				LinkedListNode current = new LinkedListNode(head.data);
				LinkedListNode temp = preHead.next;
				preHead.next = current;
				current.next = temp;
				head = head.next;
			}
			return preHead.next;
		}

		boolean isEqual(LinkedListNode one, LinkedListNode two) {
			while (one != null && two != null) {
				if (one.data != two.data)
					return false;
				one = one.next;
				two = two.next;
			}
			return one == null && two == null;
		}
	}

	// Iterative Approach: use stack
	public class Solution1 {
		boolean isPalindrome(LinkedListNode head) {
			Stack<Integer> stack = new Stack<>();
			LinkedListNode fast = head;
			LinkedListNode slow = head;
			// Add first half lists value into stack
			while (fast != null && fast.next != null) {
				stack.push(slow.data);
				slow = slow.next;
				fast = fast.next.next;
			}
			// Has odd number of elements, so skip the middle element
			if (fast != null)
				slow = slow.next;
			// Compare
			while (slow != null) {
				if (slow.data != stack.pop())
					return false;
				slow = slow.next;
			}
			return true;
		}
	}

	// Recursive Approach
	public class Solution2 {
		class Result {
			LinkedListNode node;
			boolean result;

			Result(LinkedListNode node, boolean result) {
				this.node = node;
				this.result = result;
			}
		}

		boolean isPalindrome(LinkedListNode head) {
			return isPalindrome(head, lengthOfList(head)).result;
		}

		Result isPalindrome(LinkedListNode head, int length) {
			if (head == null || length <= 0)
				return new Result(head, true);
			else if (length == 1) // Odd number of nodes
				return new Result(head.next, true);
			Result result = isPalindrome(head.next, length - 2);
			if (!result.result || result.node == null)
				return result;
			result.result = (head.data == result.node.data);
			result.node = result.node.next;
			return result;
		}

		int lengthOfList(LinkedListNode node) {
			int size = 0;
			while (node != null) {
				size++;
				node = node.next;
			}
			return size;
		}
	}

}
