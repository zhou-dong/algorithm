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
public class MultiStack {

	private class StackInfo {

		public int capacity;
		public int size;
		public int start;

		public StackInfo(int start, int capacity) {
			this.start = start;
			this.capacity = capacity;
		}

		public boolean isWithInStackCapacity(int index) {
			if (index < 0 || index >= values.length) {
				return false;
			}
			int contiguousIndex = index < start ? index + values.length : index;
			int end = start + capacity;
			return contiguousIndex >= start && contiguousIndex < end;
		}

		public int lastElementIndex() {
			return adjustIndex(start + size - 1);
		}

		public int lastCapacityIndex() {
			return adjustIndex(start + capacity - 1);
		}

		public boolean isFull() {
			return size == capacity;
		}

		public boolean isEmpty() {
			return size == 0;
		}
	}

	private StackInfo[] infos;
	private int[] values;

	public MultiStack(int numberOfStacks, int defaultSize) {
		values = new int[numberOfStacks * defaultSize];
		infos = new StackInfo[numberOfStacks];
		for (int i = 0; i < numberOfStacks; i++) {
			infos[i] = new StackInfo(i * defaultSize, defaultSize);
		}
	}

	public void push(int stackNum, int value) {
		if (allStacksAreFull()) {
			throw new FullStackException();
		}
		StackInfo stack = infos[stackNum];
		if (stack.isFull()) {
			expand(stackNum);
		}
		stack.size++;
		values[stack.lastElementIndex()] = value;
	}

	public int pop(int stackNum) {
		StackInfo stack = infos[stackNum];
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}
		int value = values[stack.lastElementIndex()];
		values[stack.lastElementIndex()] = 0;
		stack.size--;
		return value;
	}

	public int peek(int stackNum) {
		StackInfo stack = infos[stackNum];
		return values[stack.lastElementIndex()];
	}

	public void expand(int stackNum) {
		int next = (stackNum + 1) % infos.length;
		shift(next);
		infos[stackNum].capacity++;
	}

	public boolean allStacksAreFull() {
		return numberOfElements() == values.length;
	}

	public int numberOfElements() {
		int size = 0;
		for (StackInfo info : infos) {
			size += info.size;
		}
		return size;
	}

	private int adjustIndex(int index) {
		int max = values.length;
		return ((index % max) + max) % max;
	}

	private int nextIndex(int index) {
		return adjustIndex(index + 1);
	}

	private int previousIndex(int index) {
		return adjustIndex(index - 1);
	}

	private void shift(int stackNum) {
		StackInfo stack = infos[stackNum];
		if (stack.size >= stack.capacity) {
			int nextStack = (stackNum + 1) % infos.length;
			shift(nextStack);
			stack.capacity++;
		}
		int index = stack.lastCapacityIndex();
		while (stack.isWithInStackCapacity(index)) {
			values[index] = values[previousIndex(index)];
			index = previousIndex(index);
		}
		values[stack.start] = 0;
		stack.start = nextIndex(stack.start);
		stack.capacity--;
	}

}
