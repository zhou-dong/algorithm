package org.dzhou.research.algorithm.struct;

/**
 * not finished, could by improved by:
 * 
 * 1. recursive the array.
 * 
 * 2. implement by linked list
 */
public class Queue {

	private int[] array;
	private int front = -1;
	private int rare = -1;
	private int size = 0;

	Queue(int size) {
		this.size = size;
		array = new int[size];
	}

	public void add(int input) {
		if (rare + 1 == size)
			System.out.println("it is full");
		else
			array[rare++] = input;
	}

	public int pop() {
		if (front > -1)
			return array[front--];
		else {
			System.out.println("it is empty");
			return -1;
		}
	}

}