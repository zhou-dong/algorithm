package org.dzhou.review.stack;

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
		if (top == null) {
			top = current;
		} else
			top.next = current;
	}

	public int getSize() {
		return size;
	}
}
