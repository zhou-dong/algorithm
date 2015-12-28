package org.dzhou.interview.linkedlist;

/**
 * 
 * Simple implement of Linked List
 * 
 * @author DONG ZHOU
 *
 */
public class LinkedList {

	/**
	 * When use this kind of method to implement Linked List, should careful of
	 * if multiple objects need a reference to the linked list, if the head of
	 * linked list has changed.
	 * 
	 * @author DONG ZHOU
	 *
	 */

	static class Node {

		Object data = null;
		Node next = null;

		public Node(Object data) {
			this.data = data;
		}

		void appendToTail(Object data) {
			Node tmp = this;
			while (tmp.next != null)
				tmp = tmp.next;
			tmp.next = new Node(data);
		}

	}

	static Node deleteNode(Node head, Object data) {

		if (head.data.equals(data))
			return head.next;

		Node tmp = head;

		while (tmp.next != null) {
			if (tmp.next.data.equals(data)) {
				tmp.next = tmp.next.next;
				return head;
			}
			tmp = tmp.next;
		}

		return head;

	}

	public static void main(String[] args) {
		// initial head
		Node head = new Node("head");
		// append elements to tail
		for (int i = 0; i < 100; i++)
			head.appendToTail(i * 100);
		print(head);
		head = deleteNode(head, 9900);
		head = deleteNode(head, "head");
		print(head);
	}

	static void print(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

}
