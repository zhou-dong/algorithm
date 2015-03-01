package org.dzhou.research.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * This java class just an example, can be improve by Object(left, data, right);
 * 
 * @author DONG ZHOU
 */
public class BinarySearchTree {

	private static int[] tree = new int[350];

	// 1.用左子树替换，选左边子树种最大的 2.用右边子树替换，选右边子树种最小的
	public static void delete(int value) {
		int index = find(value);
		if (hasChild(index) == false) {
			tree[index] = 0;
			return;
		}
		if (hasRightChild(index)) {
			replaceWithRight(index);
			return;
		}
		if (hasLeftChild(index))
			replaceWithLeft(index);
	}

	private static boolean hasChild(int index) {
		if (leftChildValue(index) != 0)
			return true;
		if (rightChildValue(index) != 0)
			return true;
		return false;
	}

	private static boolean hasLeftChild(int index) {
		if (leftChildValue(index) != 0)
			return true;
		return false;
	}

	private static void replaceWithLeft(int index) {
		int lefChildIndex = leftChildIndex(index);
		int biggestIndexInLeft = findBiggestInLeft(lefChildIndex);
		tree[index] = tree[biggestIndexInLeft];
		tree[biggestIndexInLeft] = 0;
		List<Integer> childrenIndex = postTraversal(biggestIndexInLeft);
		List<Integer> childrenValue = new ArrayList<>();
		for (int i : childrenIndex) {
			childrenValue.add(tree[i]);
			tree[i] = 0;
		}
		for (int i : childrenValue)
			insert(i);
	}

	private static int findBiggestInLeft(int index) {
		if (hasRightChild(index) == false)
			return index;
		int rightChildIndex = rightChildIndex(index);
		return findBiggestInLeft(rightChildIndex);
	}

	private static boolean hasRightChild(int index) {
		if (rightChildValue(index) != 0)
			return true;
		return false;
	}

	private static void replaceWithRight(int index) {
		int rightchildIndex = rightChildIndex(index);
		int smallestInRight = findSmallestInRight(rightchildIndex);
		tree[index] = tree[smallestInRight];
		tree[smallestInRight] = 0;
		List<Integer> childrenIndex = postTraversal(smallestInRight);
		List<Integer> childrenValue = new ArrayList<>();
		for (int i : childrenIndex) {
			childrenValue.add(tree[i]);
			tree[i] = 0;
		}
		for (int i : childrenValue)
			insert(i);
	}

	private static int findSmallestInRight(int index) {
		if (hasLeftChild(index) == false)
			return index;
		int leftChildIndex = leftChildIndex(index);
		return findSmallestInRight(leftChildIndex);
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
	public static List<Integer> postTraversal(int index) {
		List<Integer> indexs = new ArrayList<>();
		postTravel(index, indexs);
		return indexs;
	}

	public static List<Integer> postTraversalWithRoot(int index) {
		List<Integer> indexs = new ArrayList<>();
		int root = tree[index];
		postTravel(index, indexs);
		indexs.add(root);
		return indexs;
	}

	private static void postTravel(int index, List<Integer> indexs) {
		if (hasLeftChild(index)) {
			int leftChildIndex = leftChildIndex(index);
			postTravel(leftChildIndex, indexs);
			indexs.add(leftChildIndex);
		}
		if (hasRightChild(index)) {
			int rightChildIndex = rightChildIndex(index);
			postTravel(rightChildIndex, indexs);
			indexs.add(rightChildIndex);
		}
	}

	public static int find(int value) {
		return recursiveFind(0, value);
	}

	private static int recursiveFind(int index, int value) {
		if (tree[index] == value)
			return index;
		if (tree[index] > value) {
			if (leftChildValue(index) == value)
				return leftChildIndex(index);
			else
				return recursiveFind(leftChildIndex(index), value);
		} else {
			if (rightChildValue(index) == value)
				return rightChildIndex(index);
			else
				return recursiveFind(rightChildIndex(index), value);
		}
	}

	public static void insert(int value) {
		recursiveInsert(0, value);
	}

	private static void recursiveInsert(int index, int value) {
		if (tree[index] == value) {
			System.out.println("duplicated value: " + value);
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

	public static void main(String args[]) {
		int[] input = { 45, 33, 23, 78, 90, 28, 64, 98, 64, 12, 53, 20, 19 };
		for (int i = 0; i < input.length; i++)
			insert(input[i]);
		breadthFirst();
		delete(45);
		System.out.println(" ");
		breadthFirst();
	}

}