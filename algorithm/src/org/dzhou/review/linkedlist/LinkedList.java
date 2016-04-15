package org.dzhou.review.linkedlist;

public class LinkedList<T> {

	class Node {
		T data;
		Node prev;
		Node next;

		public Node(T data) {
			this.data = data;
		}
	}

	private Node first;
	private Node last;
	private int size;

	public LinkedList() {
		this.size = 0;
		this.last = new Node(null);
		this.first = new Node(null);
		first.next = last;
		last.prev = first;
	}

	public void add(T data) {
		addLast(data);
	}

	public void addLast(T data) {
		Node current = new Node(data);
	}

	public int getSize() {
		return size;
	}

}
