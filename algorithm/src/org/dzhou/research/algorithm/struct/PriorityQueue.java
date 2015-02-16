package org.dzhou.research.algorithm.struct;

/**
 * Not finished!
 * 
 * Why Priority Queue:
 * 
 * Normal Queue sometimes not fair to the different time complexity functions.
 * 
 * We could execute short time complexity function first.
 * 
 * Improved method:
 * 
 * could use binary tree to optimize find the simplest or biggest.
 */
public class PriorityQueue {

	private int[] array;
	private int rare = -1;
	private int front = -1;
	private int size = 0;

	public PriorityQueue(int size) {
		this.size = size;
		array = new int[size];
	}

	public void addAndSwap(int input) {
		if (add(input))
			if (isSmallerThanFirst(input))
				swap(array, front, rare);
	}

	protected boolean add(int input) {
		if (rare + 1 == size) {
			System.out.println("it is full");
			return false;
		} else {
			array[rare++] = input;
			return true;
		}
	}

	protected boolean isSmallerThanFirst(int input) {
		if (input < array[front])
			return true;
		else
			return false;
	}

	protected void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public int popTheSmallest() {
		if (isEmpty())
			return -1;
		smallestToFirst();
		return pop();
	}

	protected void smallestToFirst() {
		int smallestIndex = findSmallest();
		if (smallestIndex != front)
			swap(array, smallestIndex, front);
	}

	// o(n) = n
	// Use binary tree to optimize to log(n)
	protected int findSmallest() {
		int result = 0;
		for (int i = 0; i < array.length; i++)
			if (array[result] > array[i])
				result = i;
		return result;
	}

	protected int pop() {
		if (front > -1)
			return array[front--];
		else {
			System.out.println("it is empty");
			return -1;
		}
	}

	protected boolean isEmpty() {
		return front == rare;
	}

}