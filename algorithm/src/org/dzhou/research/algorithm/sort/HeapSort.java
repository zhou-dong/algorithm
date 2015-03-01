package org.dzhou.research.algorithm.sort;

/**
 * @author DONG ZHOU
 */
public class HeapSort {

	private static int index = 0;
	private static int[] tree;
	private static int[] result;

	// phase one: create Complete Binary Tree
	public static void insertIntoTree(int value) {
		tree[index] = value;
		recursiveAscentSort(index);
		index++;
	}

	private static void recursiveAscentSort(int childIndex) {
		if (isParentExist(childIndex) == false)
			return;
		if (parentValue(childIndex) >= tree[childIndex])
			return;
		swap(childIndex, parentIndex(childIndex));
		recursiveAscentSort(parentIndex(childIndex));
	}

	private static boolean isParentExist(int childIndex) {
		if (parentIndex(childIndex) < 0)
			return false;
		else
			return true;
	}

	private static int parentValue(int childIndex) {
		return tree[parentIndex(childIndex)];
	}

	private static int parentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	// phase two: heap-sort the tree
	public static void sort() {
		index--;
		while (true) {
			swapHeadTail();
			insertTailIntoResult(index);
			if (index == 0)
				break;
			index--;
			recursiveDescentSortFromTop();
		}
	}

	private static void swapHeadTail() {
		swap(index, 0);
	}

	private static void insertTailIntoResult(int index) {
		result[index] = tree[index];
	}

	private static void recursiveDescentSortFromTop() {
		recursiveDescentSort(0);
	}

	private static void recursiveDescentSort(int parentIndex) {
		if (isChildExist(parentIndex) == false)
			return;
		if (tree[parentIndex] >= biggerChildValue(parentIndex))
			return;
		int biggerChildIndex = biggerChildIndex(parentIndex);
		swap(parentIndex, biggerChildIndex);
		recursiveDescentSort(biggerChildIndex);
	}

	private static boolean isChildExist(int parentIndex) {
		if (leftChildIndex(parentIndex) > index)
			return false;
		else
			return true;
	}

	private static int biggerChildValue(int parentIndex) {
		return tree[biggerChildIndex(parentIndex)];
	}

	private static int biggerChildIndex(int parentIndex) {
		if (isChildExist(parentIndex) == false)
			throw new RuntimeException("no child");
		if (leftChildIndex(parentIndex) == index)
			return leftChildIndex(parentIndex);
		if (leftChildVal(parentIndex) > rightChildVal(parentIndex))
			return leftChildIndex(parentIndex);
		else
			return rightChildIndex(parentIndex);
	}

	private static int leftChildVal(int parentIndex) {
		return tree[leftChildIndex(parentIndex)];
	}

	private static int rightChildVal(int parentIndex) {
		return tree[rightChildIndex(parentIndex)];
	}

	private static int leftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private static int rightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	private static void swap(int i, int j) {
		if (i == j)
			return;
		int temp = tree[i];
		tree[i] = tree[j];
		tree[j] = temp;
	}

	public static void main(String[] args) {
		int[] input = { 6, 5, 3, 1, 8, 7, 2, 4, 9, 15, 44, 2, 11, 9, 8 };
		tree = new int[input.length];
		result = new int[tree.length];
		// phase one: create Complete Binary Tree
		for (int i : input)
			insertIntoTree(i);
		print(tree);
		System.out.println("");
		// phase two: heap sort the tree
		sort();
		print(result);
	}

	private static void print(int[] input) {
		for (int i : input)
			System.out.print(i + " ");
	}

}