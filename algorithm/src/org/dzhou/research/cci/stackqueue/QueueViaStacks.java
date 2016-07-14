package org.dzhou.research.cci.stackqueue;

import java.util.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 * 
 * @author zhoudong
 *
 *         只有在stackOldest empty的时候，才能shift from new to old，否则出栈的顺序会乱。<br>
 *         恰好也能使得shift的次数最少，增加效率。
 */
public class QueueViaStacks {

	public class MyQueue<T> {
		Stack<T> stackNewest, stackOldest;

		public MyQueue() {
			stackNewest = new Stack<>();
			stackOldest = new Stack<>();
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

}
