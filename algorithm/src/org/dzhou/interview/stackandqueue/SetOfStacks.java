package org.dzhou.interview.stackandqueue;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 * 
 */
public class SetOfStacks<T> {

	ArrayList<FixedSizeStack<T>> stacks = new ArrayList<>();

	public int capacity;

	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}

	public FixedSizeStack<T> getLastStack() {
		if (stacks.size() == 0)
			return null;
		return stacks.get(stacks.size() - 1);
	}

	public void push(T data) {
		FixedSizeStack<T> lastStack = getLastStack();
		if (lastStack == null || lastStack.isFull()) {
			lastStack = new FixedSizeStack<T>(capacity);
			lastStack.push(data);
			stacks.add(lastStack);
		} else {
			lastStack.push(data);
		}
	}

	public T pop() {
		FixedSizeStack<T> lastStack = getLastStack();
		if (lastStack == null) {
			throw new EmptyStackException();
		}
		T result = lastStack.pop();
		if (lastStack.size == 0) {
			stacks.remove(stacks.size() - 1);
		}
		return result;
	}

	// TODO not finish
	public T removeBottom() {
		return null;
	}

}

class FixedSizeStack<T> extends Stack<T> {

	private int capacity;

	public FixedSizeStack(int capacity) {
		this.capacity = capacity;
	}

	public boolean isFull() {
		return size == capacity;
	}

}