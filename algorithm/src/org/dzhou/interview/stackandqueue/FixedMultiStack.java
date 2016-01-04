package org.dzhou.interview.stackandqueue;

import java.util.EmptyStackException;

/**
 * Practice of "cracking the code interview"
 * 
 * Describe how you could use a single array to implement three stacks.
 * 
 * @author DONG ZHOU
 *
 */
public class FixedMultiStack {

	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;

	public FixedMultiStack(int stackSize) {
		this.stackCapacity = stackSize;
		sizes = new int[numberOfStacks];
		values = new int[stackSize * numberOfStacks];
	}

	public void push(int stackNum, int value) {
		if (isFull(stackNum))
			throw new FullStackException();
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}

	public int pop(int stackNum) {
		if (isEmpty(stackNum))
			throw new EmptyStackException();
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNum]--;
		return value;
	}

	public int peek(int stackNum) {
		if (isEmpty(stackNum))
			throw new EmptyStackException();
		return values[indexOfTop(stackNum)];
	}

	private boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}

	private boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}

	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}
}

class FullStackException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}