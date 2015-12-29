package org.dzhou.interview.linkedlist;

import java.util.HashSet;

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

		int data;
		Node next = null;

		public Node(int data) {
			this.data = data;
		}

		void appendToTail(int data) {
			Node tmp = this;
			while (tmp.next != null)
				tmp = tmp.next;
			tmp.next = new Node(data);
		}

	}

	public static Node deleteNode(Node head, int data) {

		if (head.data == data)
			return head.next;

		Node tmp = head;

		while (tmp.next != null) {
			if (tmp.next.data == data) {
				tmp.next = tmp.next.next;
				return head;
			}
			tmp = tmp.next;
		}

		return head;

	}

	public static void deleteDups(Node head) {
		HashSet<Object> set = new HashSet<>();
		Node previous = null;
		while (head != null) {
			if (set.contains(head.data))
				previous.next = head.next;
			else {
				set.add(head.data);
				previous = head;
			}
			head = head.next;
		}
	}

	// not efficient, running time is O(n^2)
	public static void deleteDups2(Node head) {
		Node current = head;
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			current = current.next;
		}
	}

	public static void main(String[] args) {
		// initial head
		Node head = new Node(-1);
		// append elements to tail
		for (int i = 0; i < 20; i++)
			head.appendToTail(i);
		print(head);
		head = deleteNode(head, 99);
		head = deleteNode(head, -1);
		print(head);
		// append duplicate data
		for (int i = 0; i < 10; i++)
			head.appendToTail(i);
		print(head);
		deleteDups(head);
		print(head);
		for (int i = 0; i < 10; i++)
			head.appendToTail(i + 3);
		print(head);
		deleteDups2(head);
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
