package org.dzhou.interview.stackandqueue;

import java.util.EmptyStackException;

/**
 * 
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 * @param <T>
 */
public class Stack<T> {

	static class Node<T> {

		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
		}

	}

	private Node<T> top;

	public void push(T item) {
		Node<T> node = new Node<T>(item);
		node.next = top;
		top = node;
	}

	public T pop() {
		if (top == null)
			throw new EmptyStackException();
		Node<T> result = top;
		top = top.next;
		return result.data;
	}

	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

}
