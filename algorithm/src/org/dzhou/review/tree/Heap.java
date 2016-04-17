package org.dzhou.review.tree;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap<T extends Comparable<T>> {

	private ArrayList<T> items;

	public Heap() {
		items = new ArrayList<>();
	}

	public void insert(T item) {
		items.add(item);
		siftUp();
	}

	private void siftUp() {
		int k = items.size() - 1;
		while (k > 0) {
			int parentIndex = parentIndex(k);
			T current = items.get(k);
			T parent = items.get(parentIndex);
			if (current.compareTo(parent) > 0) {
				swap(k, parentIndex);
				k = parentIndex;
			} else {
				break;
			}
		}
	}

	private int parentIndex(int k) {
		return (k - 1) / 2;
	}

	private void swap(int x, int y) {
		T temp = items.get(x);
		items.set(x, items.get(y));
		items.set(y, temp);
	}

	public T delete() {
		if (items.size() == 0) {
			throw new NoSuchElementException();
		}
		if (items.size() == 1) {
			return items.remove(0);
		}
		T result = items.get(0);
		items.set(0, items.remove(items.size() - 1));
		siftDown();
		return result;
	}

	private void siftDown() {
		int k = 0;
		int leftChildIndex = leftChildIndex(k);
		while (leftChildIndex < items.size()) {
			int biggerChildIndex = biggerChildIndex(k);
			T current = items.get(k);
			T biggerChild = items.get(biggerChildIndex);
			if (biggerChild.compareTo(current) > 0) {
				swap(k, biggerChildIndex);
				k = biggerChildIndex;
				leftChildIndex = leftChildIndex(k);
			} else {
				break;
			}
		}
	}

	private int leftChildIndex(int k) {
		return 2 * k + 1;
	}

	private int rightChildIndex(int k) {
		return 2 * k + 2;
	}

	private int biggerChildIndex(int k) {
		int leftChildIndex = leftChildIndex(k);
		int rightChildIndex = rightChildIndex(k);
		if (rightChildIndex < items.size()) {
			T leftChild = items.get(leftChildIndex);
			T rightChild = items.get(rightChildIndex);
			if (rightChild.compareTo(leftChild) > 0) {
				return rightChildIndex;
			}
		}
		return leftChildIndex;
	}

	public int size() {
		return items.size();
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

}
