package org.dzhou.review.list;

public class LinkedList<T> implements List<T>{

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
		addEnd(data);
	}

	private void addEnd(T data) {
		Node current = new Node(data);
		last.prev.next = current;
		current.prev = last.prev;
		current.next = last;
		last.prev = current;
		size++;
	}

	public void addFront(T data) {
		Node current = new Node(data);
		first.next.prev = current;
		current.next = first.next;
		first.next = current;
		current.prev = first;
		size++;
	}

	public void add(int index, T data) {
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException();
		else if (index == 0)
			addFront(data);
		else if (index == size)
			addEnd(data);
		else {
			Node target = getNode(index);
			Node current = new Node(data);
			current.prev = target.prev;
			target.prev.next = current;
			current.next = target;
			target.prev = current;
			size++;
		}
	}

	public T remove(int index) {
		Node current = getNode(index);
		current.prev.next = current.next;
		current.next.prev = current.prev;
		current.prev = null;
		current.next = null ;
		size--;
		return current.data ;
	}

	public T set(int index, T element) {
		Node current = getNode(index);
		current.data = element;
		return element;
	}

	public T get(int index) {
		return getNode(index).data;
	}

	private Node getNode(int index) {
		if (index < 0 || index >= size || size == 0)
			throw new IndexOutOfBoundsException();
		Node result = first.next;
		for (int i = 0; i < index; i++)
			result = result.next;
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

}
