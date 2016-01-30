package org.dzhou.interview.linkedlist;

/**
 * Practice of "cracking the code interview"
 * 
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
		if (data == null)
			throw new NullPointerException();
		ListNode<E> node = new ListNode<E>(data);
		node.prev = tail.prev;
		node.next = tail;
		node.prev.next = node;
		tail.prev = node;
		size++;
	}

	public E get(int index) {
		return getNode(index).data;
	}

	private ListNode<E> getNode(int index) {
		if (size == 0)
			throw new IndexOutOfBoundsException();
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException();
		ListNode<E> result = head.next;
		for (int i = 0; i < index; i++) {
			result = result.next;
		}
		return result;
	}

	public void add(int index, E element) {
		if (element == null)
			throw new NullPointerException();
		if (index == size) {
			addEnd(element);
			return;
		}
		ListNode<E> current = getNode(index);
		ListNode<E> node = new ListNode<E>(element);
		node.prev = current.prev;
		node.next = current;
		current.prev = node;
		node.prev.next = node;
		size++;
	}

	public E remove(int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException();
		ListNode<E> current = getNode(index);
		current.prev.next = current.next;
		current.next.prev = current.prev;
		current.prev = null;
		current.next = null;
		size--;
		return current.data;
	}

	public E set(int index, E element) {
		if (element == null)
			throw new NullPointerException();
		ListNode<E> current = getNode(index);
		current.data = element;
		return element;
	}

	public int getSize() {
		return size;
	}

}
