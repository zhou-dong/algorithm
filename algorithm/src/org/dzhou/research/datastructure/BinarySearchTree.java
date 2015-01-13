package org.dzhou.research.datastructure;

public class BinarySearchTree {

	private static int[] tree = new int[100];
	private static int findIndex = -1;

	public static void main(String args[]) {
		int[] input = { 6, 5, 3, 1, 8, 7, 2, 4, 9, 9 };
		for (int i = 0; i < input.length; i++)
			insert(input[i]);
		printTree();
		int testNumber = 2;
		find(testNumber);
		System.out.println("[" + findIndex + ": " + testNumber + "] ");
	}

	// TODO
	static void traversal(int index) {
	}

	public static void find(int value) {
		findIndex = -1;
		recursiveFind(0, value);
	}

	private static void recursiveFind(int index, int value) {
		if (tree[index] == value) {
			findIndex = index;
			return;
		}
		if (tree[index] > value) {
			if (leftChildValue(index) == value)
				findIndex = leftChildIndex(index);
			else
				recursiveFind(leftChildIndex(index), value);
		} else {
			if (rightChildValue(index) == value)
				findIndex = rightChildIndex(index);
			else
				recursiveFind(rightChildIndex(index), value);
		}
	}

	public static void insert(int value) {
		recursiveInsert(0, value);
	}

	private static void recursiveInsert(int index, int value) {
		if (tree[index] == value) {
			System.out.println("duplicated value");
			return;
		}
		if (tree[index] == 0) {
			tree[index] = value;
			return;
		}
		if (tree[index] < value) {
			if (rightChildValue(index) == 0)
				tree[rightChildIndex(index)] = value;
			else
				recursiveInsert(rightChildIndex(index), value);
		} else {
			if (leftChildValue(index) == 0)
				tree[leftChildIndex(index)] = value;
			else
				recursiveInsert(leftChildIndex(index), value);
		}
	}

	private static int rightChildValue(int parentIndex) {
		return tree[rightChildIndex(parentIndex)];
	}

	private static int leftChildValue(int parentIndex) {
		return tree[leftChildIndex(parentIndex)];
	}

	private static int leftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private static int rightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	private static void printTree() {
		for (int i = 0; i < tree.length; i++)
			System.out.print("[" + i + ": " + tree[i] + "] ");
		System.out.println("");
	}

}