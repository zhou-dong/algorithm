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
public class RandomNode {

	private int data;
	public RandomNode left;
	public RandomNode right;
	private int size;

	public RandomNode(int data) {
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

	public RandomNode getRandomNode() {
		int leftSize = left == null ? 0 : left.size;
		Random random = new Random();
		int index = random.nextInt(this.size);
		if (index < leftSize)
			return left.getRandomNode();
		else if (index == leftSize)
			return this;
		else
			return right.getRandomNode();
	}

	public void insertInOrder(int data) {
		if (data <= this.data) {
			if (left == null)
				left = new RandomNode(data);
			else
				left.insertInOrder(data);
		} else {
			if (right == null)
				right = new RandomNode(data);
			else
				right.insertInOrder(data);
		}
		size++;
	}

	public RandomNode find(int data) {
		if (data == this.data)
			return this;
		else if (data <= this.data)
			return left != null ? left.find(data) : null;
		else if (data > this.data)
			return right != null ? right.find(data) : null;
		return null;
	}

}
