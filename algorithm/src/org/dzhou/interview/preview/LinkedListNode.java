package org.dzhou.interview.preview;

public class LinkedListNode<T> {

	private T data;
	private LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

	public void appendToTail(T data) {
		LinkedListNode<T> current = this;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new LinkedListNode<T>(data);
	}

	public LinkedListNode<T> deleteNode(T data) {
		return this.deleteNode(this, data);
	}

	public LinkedListNode<T> deleteNode(LinkedListNode<T> head, T data) {
		if (data == null) {
			throw new NullPointerException();
		}
		if (head.getData().equals(data)) {
			return head.getNext();
		}
		LinkedListNode<T> current = head;
		while (current.next != null) {
			if (data.equals(current.getNext().getData())) {
				current.next = current.next.next;
				return head;
			}
			current = current.next;
		}
		return head;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}

}
