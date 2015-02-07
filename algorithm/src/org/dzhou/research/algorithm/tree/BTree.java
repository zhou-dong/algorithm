package org.dzhou.research.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Two Three Tree
 *
 * Only finish insert
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
			datas[1] = -1l;
		}

		protected int usedSize = 1;
		protected Node parent;
		protected Node[] children = new Node[NODE_SIZE + 1];
		protected Long[] datas = new Long[NODE_SIZE];

		public boolean isLeaf() {
			return (children[0] == null) ? true : false;
		}

		private boolean isFull() {
			return (usedSize == NODE_SIZE) ? true : false;
		}

		private Node insertNode(Node node) {
			if (node == null)
				return null;
			if (isFull())
				return createNewNode(node);
			merge(node);
			return null;
		}

		private void merge(Node source) {
			datas[usedSize] = source.datas[0];
			Arrays.sort(datas);
			usedSize++;
			if (isLeaf())
				return;
			children[1] = source.children[0];
			children[2] = source.children[1];
			children[1].parent = this;
			children[2].parent = this;
		}

		private Node createNewNode(Node node) {
			List<Node> tempNodes = createTempNodes(node);
			Collections.sort(tempNodes);
			addConnection(tempNodes);
			addChildren(tempNodes, createChildList(node));
			return splitTempNodes(tempNodes);
		}

		private List<Node> createTempNodes(Node node) {
			List<Node> result = new ArrayList<>();
			result.add(new Node(datas[0]));
			result.add(new Node(datas[1]));
			result.add(node);
			return result;
		}

		private void addConnection(List<Node> tempNodes) {
			tempNodes.get(1).children[0] = tempNodes.get(0);
			tempNodes.get(1).children[1] = tempNodes.get(2);
			tempNodes.get(0).parent = tempNodes.get(1);
			tempNodes.get(2).parent = tempNodes.get(1);
		}

		private List<Node> createChildList(Node node) {
			List<Node> result = new ArrayList<>();
			for (Node child : children)
				if (child != null)
					result.add(child);
			for (Node child : node.children)
				if (child != null)
					result.add(child);
			Collections.sort(result);
			return result;
		}

		private void addChildren(List<Node> tempNodes, List<Node> childList) {
			Node left = tempNodes.get(0);
			Node right = tempNodes.get(2);
			if (childList.size() > 0)
				left.children[0] = childList.get(0);
			if (childList.size() > 1)
				left.children[1] = childList.get(1);
			if (childList.size() > 2)
				right.children[0] = childList.get(3);
			if (childList.size() > 3)
				right.children[1] = childList.get(4);
		}

		private Node splitTempNodes(List<Node> nodes) {
			return nodes.get(1);
		}

	}

	protected Node root;

	public void insert(long data) {
		Node node = new Node(data);
		if (root == null) {
			root = node;
			return;
		}
		Node result = insert(node, root);
		if (result != null)
			root = result;
	}

	public Node insert(Node node, Node root) {
		if (root.isLeaf())
			return root.insertNode(node);
		return root.insertNode(insert(node, findNode(node, root)));
	}

	private Node findNode(Node node, Node root) {
		if (root.datas[1] == -1)
			if (node.datas[0] < root.datas[0])
				return root.children[0];
			else
				return root.children[1];
		if (node.datas[0] < root.datas[0])
			return root.children[0];
		else if (node.datas[0] > root.datas[1])
			return root.children[2];
		else
			return root.children[1];
	}

	public static void main(String[] args) {
		BTree tree = new BTree();
		for (long i = 1l; i < 16l; i++)
			tree.insert(i);
		System.out.println(" " + tree);
	}

}