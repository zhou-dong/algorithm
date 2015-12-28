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
		// initial head
		Node head = new Node("head");
		// append elements to tail
		for (int i = 0; i < 100; i++)
			head.appendToTail(i * 100);
		// print all the elements
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

}