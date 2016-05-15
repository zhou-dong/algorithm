package org.dzhou.practice.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * 
 * push(x) -- Push element x onto stack.<br>
 * pop() -- Removes the element on top of the stack.<br>
 * top() -- Get the top element.<br>
 * empty() -- Return whether the stack is empty.<br>
 * 
 * Notes:
 * 
 * You must use only standard operations of a queue -- which means only push to
 * back, peek/pop from front, size, and is empty operations are valid.
 * 
 * Depending on your language, queue may not be supported natively. You may
 * simulate a queue by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a queue.
 * 
 * You may assume that all operations are valid (for example, no pop or top
 * operations will be called on an empty stack).
 * 
 * @author zhoudong
 *
 */
public class ImplementStackUsingQueues {

	interface Stack {
		// Push element x onto stack.
		public void push(int x);

		// Removes the element on top of the stack.
		public void pop();

		// Get the top element.
		public int top();

		// Return whether the stack is empty.
		public boolean empty();
	}

	class Stack1 implements Stack {

		private Queue<Integer> q1 = new LinkedList<>();
		private Queue<Integer> q2 = new LinkedList<>();

		@Override
		public void push(int x) {
			q1.offer(x);
		}

		@Override
		public void pop() {
			transfer();
			q1.poll();
			swap();
		}

		@Override
		public int top() {
			transfer();
			int top = q1.peek();
			q2.offer(q1.poll());
			swap();
			return top;
		}

		@Override
		public boolean empty() {
			return q1.isEmpty();
		}

		private void transfer() {
			while (q1.size() > 1)
				q2.offer(q1.poll());
		}

		private void swap() {
			Queue<Integer> temp = q1;
			q1 = q2;
			q2 = temp;
		}

	}

	class Stack2 implements Stack {

		private Queue<Integer> q1 = new LinkedList<>();
		private Queue<Integer> q2 = new LinkedList<>();

		@Override
		public void push(int x) {
			q2.offer(x);
			while (!q1.isEmpty()) {
				q2.offer(q1.poll());
			}
			swap();
		}

		@Override
		public void pop() {
			q1.poll();
		}

		@Override
		public int top() {
			return q1.peek();
		}

		@Override
		public boolean empty() {
			return q1.isEmpty();
		}

		private void swap() {
			Queue<Integer> temp = q1;
			q1 = q2;
			q2 = temp;
		}

	}

	class Stack3 implements Stack {

		private Queue<Integer> q = new LinkedList<>();

		@Override
		public void push(int x) {
			q.offer(x);
		}

		@Override
		public void pop() {
			reAdd();
			q.poll();
		}

		@Override
		public int top() {
			reAdd();
			int top = q.peek();
			q.offer(q.poll());
			return top;
		}

		@Override
		public boolean empty() {
			return q.isEmpty();
		}

		// 把队列除最后一个元素外，逐个循环添加到队列的尾部。
		private void reAdd() {
			int size = q.size();
			for (int i = 1; i < size; i++) {
				q.offer(q.poll());
			}
		}

	}

}