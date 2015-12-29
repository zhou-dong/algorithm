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

}
