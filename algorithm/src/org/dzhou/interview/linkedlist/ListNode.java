package org.dzhou.interview.linkedlist;

/**
 * Practice of "cracking the code interview"
 * 
 * Doubly Linked List
 * 
 * @author DONG ZHOU
 *
 * @param <E>
 */
public class ListNode<E> {

	ListNode<E> prev;
	ListNode<E> next;
	E data;

	public ListNode(E data) {
		this.data = data;
	}

}
