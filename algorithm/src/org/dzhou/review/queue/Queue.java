package org.dzhou.review.queue;

import java.util.NoSuchElementException;

public class Queue<T> {

	class Node {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
		}
	}

	private Node first;
	private Node last;

	public void push(T data) {
		Node current = new Node(data);
		if (last != null)
			last.next = current;
		last = current;
		if (first == null)
			first = last;
	}

	public T peek() {
		if (first == null)
			throw new NoSuchElementException();
		return first.data;
	}

	public T pop() {
		if (first == null)
			throw new NoSuchElementException();
		T val = first.data;
		first = first.next;
		if (first == null)
			last = null;
		return val;
	}

	public boolean isEmpty() {
		return first == null;
	}

}
