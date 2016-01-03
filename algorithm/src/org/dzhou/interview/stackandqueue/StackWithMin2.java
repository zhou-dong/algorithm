package org.dzhou.interview.stackandqueue;

/**
 * Practice of "cracking the code interview"
 * 
 * How would you design a stack with in addition to push and pop. has a function
 * min which returns the minimum element? Push, pop and min should all operate
 * in O(1) time.
 * 
 * @author DONG ZHOU
 *
 */
public class StackWithMin2 extends Stack<Integer> {

	Stack<Integer> minStack;

	public StackWithMin2() {
		minStack = new Stack<>();
	}

	public void push(int value) {
		minStack.push(Math.max(value, min()));
		super.push(value);
	}

	public Integer pop() {
		minStack.pop();
		return super.pop();
	}

	public int min() {
		if (this.isEmpty())
			return Integer.MAX_VALUE;
		else
			return minStack.peek();
	}

}
