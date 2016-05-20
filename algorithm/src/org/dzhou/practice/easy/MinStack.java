package org.dzhou.practice.easy;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack.<br>
 * pop() -- Removes the element on top of the stack.<br>
 * top() -- Get the top element.<br>
 * getMin() -- Retrieve the minimum element in the stack.<br>
 * 
 * Example:<br>
 * 
 * MinStack minStack = new MinStack();<br>
 * minStack.push(-2);<br>
 * minStack.push(0);<br>
 * minStack.push(-3);<br>
 * minStack.getMin(); --> Returns -3.<br>
 * minStack.pop();<br>
 * minStack.top(); --> Returns 0.<br>
 * minStack.getMin(); --> Returns -2.<br>
 * 
 * @author zhoudong
 *
 */
public class MinStack {

	class Node {
		int val;
		int min;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	Node top = null;

	/** initialize your data structure here. */
	public MinStack() {

	}

	public void push(int x) {
		Node node = new Node(x);
		if (top == null) {
			top = node;
			node.min = x;
		} else {
			node.next = top;
			top = node;
			node.min = Math.min(x, top.next.min);
		}
	}

	public void pop() {
		top = top.next;
	}

	public int top() {
		return top == null ? 0 : top.val;
	}

	public int getMin() {
		return top != null ? top.min : 0;
	}

}
