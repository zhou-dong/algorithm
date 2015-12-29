package org.dzhou.interview.linkedlist;

import java.util.HashSet;

public class LinkedList {

	public static void deleteDups3(Node head) {
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
		System.out.print("Initial list: ");
		print(head);
		head = Node.deleteNode(head, 19);
		head = Node.deleteNode(head, 18);
		head = Node.deleteNode(head, -1);
		System.out.print("removed list: ");
		print(head);
		// append duplicate data
		for (int i = 0; i < 10; i++)
			head.appendToTail(i);
		System.out.print("Add dups: ");
		print(head);
		DeleteDups.deleteDups(head);
		System.out.print("Rm dups: ");
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
