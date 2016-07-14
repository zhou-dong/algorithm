package org.dzhou.research.cci.stackqueue;

import java.util.Stack;

/**
 * How would you design a stack which, in addition to push and pop, has a
 * function min which return the minimum element? Push, pop and min should all
 * operate in O(1) time.
 * 
 * @author zhoudong
 *
 *         Solution:
 *
 *         1. create new node which contains value and minimum<br>
 *         2. Use another stack to keep the minimum value
 * 
 */
public class StackMin {

	class NodeWithMin {
		public int value;
		public int min;

		public NodeWithMin(int value, int min) {
			this.value = value;
			this.min = min;
		}
	}

	public class StackWithMin extends Stack<NodeWithMin> {
		private static final long serialVersionUID = 1L;

		public void push(int value) {
			super.push(new NodeWithMin(value, Math.min(value, min())));
		}

		public int min() {
			if (this.isEmpty())
				return Integer.MAX_VALUE;
			else
				return super.peek().min;
		}
	}

	public class StackWithMin2 extends Stack<Integer> {
		private static final long serialVersionUID = 1L;
		Stack<Integer> s2;

		public StackWithMin2() {
			s2 = new Stack<>();
		}

		public void push(int value) {
			if (value < min())
				s2.push(value);
			super.push(value);
		}

		public Integer pop() {
			int value = super.pop();
			if (value == min())
				s2.pop();
			return value;
		}

		public int min() {
			if (s2.isEmpty())
				return Integer.MAX_VALUE;
			else
				return s2.peek();
		}
	}

}
