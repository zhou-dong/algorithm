package org.dzhou.interview.preview;

public class Stack<T> {

	static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

	Node<T> top;
	int size = 0;

	public void push(T data) {
		Node<T> current = new Node<T>(data);
		current.next = top;
		top = current;
	}

	public T peek() {
		return top.data;
	}

	public T pop() {
		if (top == null) {
			return null;
		}
		T result = top.data;
		top = top.next;
		return result;
	}

}
