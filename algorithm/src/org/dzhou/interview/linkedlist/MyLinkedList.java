package org.dzhou.interview.linkedlist;

/**
 * @author DONG ZHOU
 *
 * @param <E>
 */
public class MyLinkedList<E> {

	private ListNode<E> head;
	private ListNode<E> tail;
	private int size;

	public MyLinkedList() {
		size = 0;
		head = new ListNode<E>(null);
		tail = new ListNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	public int getSize() {
		return size;
	}

}
