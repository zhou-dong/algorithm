package org.dzhou.research.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Two Three Tree
 *
 * Only have insert method
 * 
 */
public class BTree {

	private static final int NODE_SIZE = 2;

	public static class Node implements Comparable<Node> {

		@Override
		public int compareTo(Node node) {
			return this.datas[0].compareTo(node.datas[0]);
		}

		public Node(long data) {
			datas[0] = data;
		}

		protected int usedSize = 1;
		protected Node parent;
		protected Node[] children = new Node[NODE_SIZE + 1];
		protected Long[] datas = new Long[NODE_SIZE];

		public boolean isLeaf() {
			return (children[0] == null) ? true : false;
		}

		public Node insertData(Long data) {
			return insertData(new Node(data));
		}

		private Node insertData(Node node) {
			if (isFull())
				return createNewNode(node);
			if (isLeaf())
				leafInsert(node.datas[0]);
			return null;
		}

		private void merge(Node node) {
			merge(this, node);
		}

		private void merge(Node target, Node source) {
			target.children[1] = source.children[0];
			target.children[2] = source.children[1];
			target.children[1].parent = target;
			target.children[2].parent = target;
			target.datas[1] = source.datas[0];
			target.usedSize++;
		}

		private void leafInsert(long data) {
			datas[usedSize] = data;
			Arrays.sort(datas);
			usedSize++;
		}

		private boolean isFull() {
			return (usedSize == NODE_SIZE) ? true : false;
		}

		private Node createNewNode(Node node) {
			List<Node> tempNodes = createTempNodes(node);
			addChildren(tempNodes);
			return splitTempNodes(tempNodes);
		}

		private List<Node> createTempNodes(Node node) {
			List<Node> result = new ArrayList<BTree.Node>();
			result.add(new Node(datas[0]));
			result.add(new Node(datas[1]));
			result.add(node);
			Collections.sort(result);
			return result;
		}

		private void addChildren(List<Node> tempNodes) {
			tempNodes.get(0).children[0] = children[0];
			tempNodes.get(0).children[1] = children[1];
			tempNodes.get(2).children[0] = children[2];
		}

		private Node splitTempNodes(List<Node> nodes) {
			Node leftNode = nodes.get(0);
			Node medianNode = nodes.get(1);
			Node rightNode = nodes.get(2);
			medianNode.children[0] = leftNode;
			medianNode.children[1] = rightNode;
			leftNode.parent = medianNode;
			rightNode.parent = medianNode;
			return medianNode;
		}

	}

	protected Node root;

	public void insert(long data) {
		if (root == null)
			root = new Node(data);

	}

	public void insert(long data, Node node) {
		Node newNode = null;
		if (node.isLeaf())
			newNode = node.insertData(data);
		if (data < node.datas[0])
			insert(data, node.children[0]);
		else if (data > node.datas[1])
			insert(data, node.children[2]);
		else
			insert(data, node.children[1]);
		if (newNode == null)
			return;
		node.insertData(data);
	}

	public static void main(String[] args) {

	}

}