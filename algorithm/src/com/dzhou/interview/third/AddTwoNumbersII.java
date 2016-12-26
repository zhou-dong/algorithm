package com.dzhou.interview.third;

import java.util.Stack;

/**
 * 445. Add Two Numbers II
 * 
 * You are given two linked lists representing two non-negative numbers. The
 * most significant digit comes first and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up: What if you cannot modify the input lists? In other words,
 * reversing the lists is not allowed.
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * Output: 7 -> 8 -> 0 -> 7
 * 
 * @author zhoudong
 *
 */
public class AddTwoNumbersII {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}

		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}

		int carry = 0;
		ListNode top = new ListNode(1);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			int sum = carry;
			if (!s1.isEmpty()) {
				sum += s1.pop();
			}
			if (!s2.isEmpty()) {
				sum += s2.pop();
			}
			ListNode current = new ListNode(sum % 10);
			carry = sum / 10;
		}
		return top;
	}

}
