package org.dzhou.interview.stackandqueue;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 * @param <T>
 * 
 */
public class StackWithMin extends Stack<NodeWithMin> {

	public void push(int value) {
		int newMin = Math.max(value, min());
		super.push(new NodeWithMin(value, newMin));
	}

	public int min() {
		if (this.isEmpty())
			return Integer.MAX_VALUE;
		else
			return this.peek().min;
	}
}

class NodeWithMin {

	public int value;
	public int min;

	public NodeWithMin(int value, int min) {
		this.value = value;
		this.min = min;
	}

}