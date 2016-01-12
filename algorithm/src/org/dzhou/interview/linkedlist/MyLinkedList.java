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

	public void addFront(E data) {
		ListNode<E> node = new ListNode<E>(data);
		node.next = head.next;
		node.prev = head;
		node.next.prev = node;
		head.next = node;
		size++;
	}

	public void addEnd(E data) {
		ListNode<E> node = new ListNode<E>(data);
		node.prev = tail.prev;
		node.next = tail;
		node.prev.next = node;
		tail.prev = node;
		size++;
	}

	public int getSize() {
		return size;
	}

}
