package org.dzhou.research.algorithm.struct;

/**
 * not finished
 */
public class Stack {

	private int[] array;
	private int size;
	private int topOfStack;

	public Stack(int size) {
		this.size = size;
		array = new int[size];
	}

	public void push(int input) {
		if (topOfStack + 1 < size)
			array[topOfStack++] = input;
		else
			System.out.println("stack is full");
	}

	public int pop() {
		if (topOfStack >= 0)
			return array[topOfStack--];
		else
			return -1;
	}

	public int peek() {
		return array[topOfStack];
	}

	public void display() {
		for (int i : array)
			System.out.print(i + " ");
	}

	public static void main(String[] args) {
		Stack stack = new Stack(20);
		int[] test = { 7, 5, 9, 3, 4, 1, 2, 6, 3 };
		for (int i : test)
			stack.push(i);
		stack.display();
		for (int i = 0; i < test.length; i++)
			System.out.println(stack.pop());
	}

}