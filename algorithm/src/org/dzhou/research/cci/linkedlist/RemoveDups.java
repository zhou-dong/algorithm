package org.dzhou.research.cci.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * 
 * FOLLOW UP:
 * 
 * How would you solve this problem if a temporary buffer is not allowed?
 * 
 * @author zhoudong
 *
 */
public class RemoveDups {

	class LinkedListNode {
		int data;
		LinkedListNode next;
	}

	// runtime is O(N), and space complexity is O(N)
	public class Solution {
		void deleteDups(LinkedListNode n) {
			Set<Integer> set = new HashSet<>();
			LinkedListNode prev = null;
			while (n != null) {
				if (set.contains(n.data)) {
					prev.next = n.next;
				} else {
					set.add(n.data);
					prev = n;
				}
				n = n.next;
			}
		}
	}

	// runtime is O(N^2), and space complexity is O(1)
	public class Solution1 {
		void deleteDups(LinkedListNode n) {
			LinkedListNode current = n;
			while (current != null) {
				LinkedListNode runner = current;
				while (runner.next != null) {
					if (runner.next.data == current.data) {
						runner.next = runner.next.next;
					} else {
						runner = runner.next;
					}
				}
				current = current.next;
			}
		}
	}

}
