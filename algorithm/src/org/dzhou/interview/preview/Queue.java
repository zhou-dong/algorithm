package org.dzhou.interview.preview;

import java.util.NoSuchElementException;

/**
 * 
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 * @param <T>
 */
public class Queue<T> {

	static class Node<T> {

		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
		}

	}

	Node<T> first;
	Node<T> last;

	public void add(T item) {
		Node<T> node = new Node<T>(item);
		if (last != null)
			last.next = node;
		last = node;
		if (first == null)
			first = last;
	}

	public T remove() {
		if (first == null)
			throw new NoSuchElementException();
		T result = first.data;
		first = first.next;
		if (first == null)
			last = null;
		return result;
	}

	public T peek() {
		if (first == null)
			throw new NoSuchElementException();
		return first.data;
	}

	public boolean isEmpty() {
		return first == null;
	}

}
