package org.dzhou.interview.stackandqueue;

/**
 * Practice of "cracking the code interview"
 * 
 * Implement a MyQueue class with implements a queue using two stacks.
 * 
 * @author DONG ZHOU
 * 
 */
public class MyQueue<T> {

	java.util.Stack<T> stackNewest;
	java.util.Stack<T> stackOldest;

	public MyQueue() {
		stackNewest = new java.util.Stack<T>();
		stackOldest = new java.util.Stack<T>();
	}

	public int size() {
		return stackNewest.size() + stackOldest.size();
	}

	public void add(T value) {
		stackNewest.push(value);
	}

	public T peek() {
		shiftStacks();
		return stackOldest.peek();
	}

	public T remove() {
		shiftStacks();
		return stackOldest.pop();
	}

	private void shiftStacks() {
		if (stackOldest.isEmpty()) {
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}

}
