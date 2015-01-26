package org.dzhou.research.algorithm.tree;

public class BinarySearchTree {

	private static int[] tree = new int[350];
	private static int findIndex = -1;

	public static void main(String args[]) {
		int[] input = { 45, 33, 23, 78, 90, 28, 64, 98, 64, 12, 53, 20, 19 };
		for (int i = 0; i < input.length; i++)
			insert(input[i]);
		printTree();
		int testNumber = 33;
		find(testNumber);
		System.out.println("[" + findIndex + ": " + testNumber + "] ");

		inorderTraversal(0);

	}

	public static void breadthFirst() {
		int level = 0;
		while (true) {
			int[] dataInOneLevel = traversalInLevel(level);
			if (hasNumber(dataInOneLevel) == false)
				return;
			System.out.print("level: " + level + " data:");
			for (int i : dataInOneLevel)
				if (i != 0)
					System.out.print(" " + i);
			System.out.println(" ");
			level++;
		}
	}

	private static boolean hasNumber(int[] input) {
		for (int i : input)
			if (i != 0)
				return true;
		return false;
	}

	private static int[] traversalInLevel(int level) {
		int beginIndex = findBeginIndexInOneLevel(level);
		int numbers = countNumbersInOneLevel(level);
		int[] result = new int[numbers];
		for (int i = 0; i < numbers; i++)
			result[i] = tree[beginIndex++];
		return result;
	}

	private static int findBeginIndexInOneLevel(int level) {
		int result = 1;
		for (int i = 0; i < level; i++)
			result *= 2;
		return result - 1;
	}

	private static int countNumbersInOneLevel(int level) {
		int result = 1;
		for (int i = 0; i < level; i++)
			result *= 2;
		return result;
	}

	// <root> <left> <right>
	public static void preTraversal(int index) {
		int root = tree[index];
		System.out.print(root + " ");
		int left = tree[leftChildIndex(index)];
		int right = tree[rightChildIndex(index)];
		if (left != 0)
			preTraversal(leftChildIndex(index));
		if (right != 0)
			preTraversal(rightChildIndex(index));
	}

	// <left> <root> <right>
	public static void inorderTraversal(int index) {
		int root = tree[index];
		int left = tree[leftChildIndex(index)];
		int right = tree[rightChildIndex(index)];
		if (left != 0)
			inorderTraversal(leftChildIndex(index));
		System.out.print(root + " ");
		if (right != 0)
			inorderTraversal(rightChildIndex(index));
	}

	// <left> <right> <root>
	public static void postTraversal(int index) {
		int root = tree[index];
		postTravel(index);
		System.out.println(root);
	}

	private static void postTravel(int index) {
		int left = tree[leftChildIndex(index)];
		int right = tree[rightChildIndex(index)];
		if (left != 0) {
			postTraversal(leftChildIndex(index));
			System.out.print(left + " ");
		}
		if (right != 0) {
			postTraversal(rightChildIndex(index));
			System.out.print(right + " ");
		}
	}

	// 1.用左子树替换，选左边子树种最大的 2.用右边子树替换，选右边子树种最小的
	public static void delete(int value) {

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

	private static int parentIndexFromLeft(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private static int parentIndexFromRight(int childIndex) {
		return (childIndex - 2) / 2;
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