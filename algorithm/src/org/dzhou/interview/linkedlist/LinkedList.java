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

	public static void main(String[] args) {

		Node head = new Node("head");

<<<<<<< HEAD
		for (int i = 0; i < 100; i++)
			head.appendToTail(i * 100);

		while (head != null) {
			System.out.println(head.data);
=======
		for (int i = 0; i < 100; i++) {
			head.appendToTail(i * 100);
		}

		while (head != null) {
			Object data = head.data;
			System.out.println(data);
>>>>>>> 9e79c8edf6629c48d492b1ccf5fd5346684a4a8f
			head = head.next;
		}

	}

}
