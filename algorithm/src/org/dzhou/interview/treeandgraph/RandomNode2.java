package org.dzhou.interview.treeandgraph;

import java.util.Random;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         You are implementing a binary search tree class from scratch, which,
 *         in addition to insert, find and delete, has a method getRandomNode()
 *         which returns a random node from the tree. All nodes should be
 *         equally likely to be chosen. Design and implement an algorithm for
 *         getRandomNode, and explain how you would implement the rest of the
 *         methods.
 *
 */
class RandomTree {
	RandomNode2 root;

	public int size() {
		return root == null ? 0 : root.getSize();
	}

	public RandomNode2 getRandomNode() {
		if (root == null)
			return null;
		Random random = new Random();
		int index = random.nextInt(size());
		return root.getIthNode(index);
	}

	public void insertInOrder(int data) {
		if (root == null)
			root = new RandomNode2(data);
		else
			root.insertInOrder(data);
	}
}

public class RandomNode2 {

	private int data;
	private int size;
	public RandomNode2 left;
	public RandomNode2 right;

	public RandomNode2(int data) {
		this.data = data;
		size = 1;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getSize() {
		return size;
	}

	public RandomNode2 getIthNode(int index) {
		int leftSize = left == null ? 0 : left.size;
		if (index < leftSize)
			return left.getIthNode(index);
		else if (index == leftSize)
			return this;
		else
			return right.getIthNode(index - (leftSize + 1));
	}

	public void insertInOrder(int data) {
		if (data <= this.data) {
			if (left == null)
				left = new RandomNode2(data);
			else
				left.insertInOrder(data);
		} else {
			if (right == null)
				right = new RandomNode2(data);
			else
				right.insertInOrder(data);
		}
		size++;
	}

	public RandomNode2 find(int data) {
		if (data == this.data)
			return this;
		else if (data <= this.data)
			return left != null ? left.find(data) : null;
		else if (data > this.data)
			return right != null ? right.find(data) : null;
		return null;
	}

}
