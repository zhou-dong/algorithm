package org.dzhou.interview.linkedlist;

/**
 * 
 * You have two numbers represented by a linked list, where each node containers
 * a single digit. The digits are store in reverse order, such that the 1's are
 * at the head of the list. Write a function that adds two numbers and return
 * the sum as a linked list.
 * 
 * @author DONG ZHOU
 *
 */
public class SumLists {

	public static Node sumList(Node first, Node second) {
		Node result = null;
		int carry = 0;
		while (first != null || second != null) {
			int value = carry;
			if (first != null) {
				value += first.data;
				first = first.next;
			}
			if (second != null) {
				value += second.data;
				second = second.next;
			}
			int data = value % 10;
			if (result == null)
				result = new Node(data);
			else
				result.appendToTail(data);
			carry = value > 9 ? 1 : 0;
		}
		if (carry == 1)
			result.appendToTail(1);
		return result;
	}

	public static void main(String[] args) {
		Node first = new Node(7);
		first.appendToTail(1);
		first.appendToTail(6);
		print(first);
		Node second = new Node(5);
		second.appendToTail(9);
		second.appendToTail(2);
		print(second);
		Node sum = sumList(first, second);
		print(sum);
	}

	static void print(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}
