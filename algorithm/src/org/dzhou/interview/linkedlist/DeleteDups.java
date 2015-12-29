package org.dzhou.interview.linkedlist;

import java.util.HashSet;

public class DeleteDups {

	public static void deleteDups(Node head) {
		HashSet<Integer> set = new HashSet<>();
		Node previous = head;
		while (head != null) {
			if (set.contains(head.data)) {
				previous.next = head.next;
			} else {
				set.add(head.data);
				previous = head;
			}
			head = head.next;
		}
	}

	// not efficient, running time is O(n^2)
	public static void deleteDups2(Node head) {
		while (head != null) {
			Node next = head.next;
			Node previous = next;
			while (next != null) {
				if (head.data == next.data)
					previous.next = next.next;
				else
					previous = next;
				next = next.next;
			}
			head = head.next;
		}
	}

}
