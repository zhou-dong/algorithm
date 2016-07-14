package org.dzhou.research.cci.stackqueue;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 * 
 *         Solution：使用双向stack
 */
public class StackOfPlates {

	class Node {
		int value;
		Node above;
		Node below;

		Node(int value) {
			this.value = value;
		}
	}

	public class Stack {

		private int capacity;
		public Node top, bottom;
		public int size = 0;

		public Stack(int capacity) {
			this.capacity = capacity;
		}

		public boolean isFull() {
			return this.size == this.capacity;
		}

		public boolean isEmpty() {
			return this.size == 0;
		}

		public boolean push(int item) {
			if (this.size >= this.capacity)
				return false;
			this.size++;
			Node n = new Node(item);
			if (size == 1)
				bottom = n;
			join(n, top);
			top = n;
			return true;
		}

		public void join(Node above, Node below) {
			if (below != null)
				below.above = above;
			if (above != null)
				above.below = below;
		}

		public int pop() {
			int value = top.value;
			top = top.below;
			size--;
			return value;
		}

		public int removeBottom() {
			int value = bottom.value;
			bottom = bottom.above;
			if (bottom != null)
				bottom.below = null;
			size--;
			return value;
		}
	}

	public class SetOfStacks<T> {

		ArrayList<Stack> stacks = new ArrayList<>();

		public int capacity;

		public SetOfStacks(int capacity) {
			this.capacity = capacity;
		}

		public Stack getLastStack() {
			if (stacks.isEmpty())
				return null;
			return stacks.get(stacks.size() - 1);
		}

		public void push(int item) {
			Stack last = getLastStack();
			if (last != null && !last.isFull())
				last.push(item);
			else {
				Stack stack = new Stack(capacity);
				stack.push(item);
				stacks.add(stack);
			}
		}

		public int pop() {
			Stack last = getLastStack();
			if (last == null)
				throw new EmptyStackException();
			int result = last.pop();
			if (last.isEmpty())
				stacks.remove(stacks.size() - 1);
			return result;
		}

		public boolean isEmpty() {
			Stack last = getLastStack();
			return (last == null || last.isEmpty());
		}

		public int popAt(int index) {
			return leftShift(index, true);
		}

		public int leftShift(int index, boolean removeTop) {
			Stack stack = stacks.get(index);
			int value = removeTop ? stack.pop() : stack.removeBottom();
			if (stack.isEmpty())
				stacks.remove(index);
			else if (stacks.size() > index + 1) {
				int v = leftShift(index + 1, false);
				stack.push(v);
			}
			return value;
		}
	}

}
