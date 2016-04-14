package org.dzhou.review.stack;

import java.util.EmptyStackException;

public class Stack<T> {

	class Node {
		T data;
		Node next;

		public Node(T data) {
			this.data = data;
		}
	}

	private Node top;
	private int size = 0;

	public void push(T data) {
		Node current = new Node(data);
		current.next = top;
		top = current;
		size++;
	}

	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		return top.data;
	}

	public T pop() {
		if (top == null)
			throw new EmptyStackException();
		T val = top.data;
		top = top.next;
		size--;
		return val;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return top == null;
	}

}
