package org.dzhou.research.cci.stackqueue;

import java.util.EmptyStackException;

/**
 * Describe how you could use a single array to implement three stacks.
 * 
 * @author zhoudong
 *
 */
public class ThreeInOne {

	class FullStackException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}

	// Fixed Division
	public class FixedMultiStack {
		private int numberOfStacks = 3;
		private int stackCapacity;
		private int[] values;
		private int[] sizes;

		public FixedMultiStack(int stackSize) {
			this.stackCapacity = stackSize;
			this.values = new int[stackCapacity * numberOfStacks];
			this.sizes = new int[numberOfStacks];
		}

		public void push(int stackNum, int value) throws FullStackException {
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

		public boolean isEmpty(int stackNum) {
			return sizes[stackNum] == 0;
		}

		public boolean isFull(int stackNum) {
			return sizes[stackNum] == stackCapacity;
		}

		private int indexOfTop(int stackNum) {
			int offset = stackNum * stackCapacity;
			int size = sizes[stackNum];
			return offset + size - 1;
		}
	}

	// Flexible Divisions
	public class MultiStack {

		private class StackInfo {
			private int start, size, capacity;

			StackInfo(int start, int capacity) {
				this.start = start;
				this.capacity = capacity;
			}

			boolean isWithinStackCapacity(int index) {
				if (index < 0 || index >= values.length)
					return false;
				int contiguousIndex = index < start ? index + values.length : index;
				int end = start + capacity;
				return start <= contiguousIndex && contiguousIndex < end;
			}

			int lastCapacityIndex() {
				return adjustIndex(start + capacity - 1);
			}

			int lastElementIndex() {
				return adjustIndex(start + size - 1);
			}

			boolean isEmpty() {
				return this.size == 0;
			}

			boolean isFull() {
				return this.size == this.capacity;
			}
		}

		private StackInfo[] info;
		private int[] values;

		public MultiStack(int numberOfStacks, int defaultSize) {
			info = new StackInfo[numberOfStacks];
			for (int i = 0; i < numberOfStacks; i++) {
				info[i] = new StackInfo(i * defaultSize, defaultSize);
			}
			values = new int[numberOfStacks * defaultSize];
		}

		public void push(int stackNum, int value) throws FullStackException {
			if (allStackAreFull())
				throw new FullStackException();
			StackInfo stack = info[stackNum];
			if (stack.isFull())
				expand(stackNum);
			stack.size++;
			values[stack.lastElementIndex()] = value;
		}

		private void expand(int stackNum) {
			int nextStack = (stackNum + 1) % info.length;
			shift(nextStack);
			info[stackNum].capacity++;
		}

		private void shift(int stackNum) {
			StackInfo stack = info[stackNum];
			if (stack.size >= stack.capacity) {
				int nextStack = (stackNum + 1) % info.length;
				shift(nextStack); // recursive shift stack
				stack.capacity++;
			}

			int index = stack.lastCapacityIndex();
			while (stack.isWithinStackCapacity(index)) {
				values[index] = values[previousIndex(index)];
				index = previousIndex(index);
			}

			values[stack.start] = 0;
			stack.start = nextIndex(stack.size);
			stack.capacity--;
		}

		public int pop(int stackNum) {
			StackInfo stack = info[stackNum];
			if (stack.isEmpty())
				throw new EmptyStackException();
			int value = values[stack.lastElementIndex()];
			values[stack.lastElementIndex()] = 0;
			stack.size--;
			return value;
		}

		public int peek(int stackNum) {
			StackInfo stack = info[stackNum];
			return values[stack.lastElementIndex()];
		}

		public int numberOfElements() {
			int result = 0;
			for (StackInfo stackInfo : info) {
				result += stackInfo.size;
			}
			return result;
		}

		public boolean allStackAreFull() {
			return numberOfElements() == values.length;
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
	}

}
