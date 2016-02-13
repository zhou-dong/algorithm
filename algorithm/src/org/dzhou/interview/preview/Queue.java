package org.dzhou.interview.preview;

public class Queue<T> {

	static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

	Node<T> first, last;

	public void enqueue(T data) {
		Node<T> node = new Node<T>(data);
		if (first == null) {
			last = node;
			first = last;
		} else {
			last.next = node;
			last = node;
		}
	}

	public T dequeue() {
		if (first == null) {
			return null;
		}
		T result = first.data;
		first = first.next;
		if (first == null) {
			last = null;
		}
		return result;
	}

}
