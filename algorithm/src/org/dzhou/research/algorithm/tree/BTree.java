package org.dzhou.research.algorithm.tree;

/**
 * Two Three Tree
 *
 * Only have insert method
 * 
 */
public class BTree {

	private static final int NODE_SIZE = 2;

	public static class Node {

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

		public Node insert(Long data) {
			if (isLeaf()) {
				if (isFull())
					return split(bubbleSort(createArray(data)));
				datas[usedSize] = data;
				gnomeSort(datas);
				usedSize++;
			}
			return null;
		}

		public void merge(Node target, Node source) {
			target.children[1] = source.children[0];
			target.children[2] = source.children[1];
			target.children[1].parent = target;
			target.children[2].parent = target;
			target.datas[1] = source.datas[0];
			target.usedSize++;
		}

		public boolean isFull() {
			return (usedSize == NODE_SIZE) ? true : false;
		}

		private Node split(Node[] array) {
			Node left = array[0];
			Node median = array[1];
			Node right = array[2];
			median.children[0] = left;
			median.children[1] = right;
			left.parent = median;
			right.parent = median;
			return median;
		}

		private Node[] createArray(long data) {
			Node[] array = new Node[3];
			array[0] = new Node(datas[0]);
			array[1] = new Node(datas[1]);
			array[2] = new Node(data);
			return array;
		}

		private void gnomeSort(Long[] array) {
			for (int i = 1; i < array.length; i++)
				recursiveSort(i, array);
		}

		private void recursiveSort(int i, Long[] array) {
			if (i == 0)
				return;
			if (array[i] > array[i - 1])
				return;
			swap(i, array);
			recursiveSort(i - 1, array);
		}

		private void swap(int i, Long[] array) {
			swap(i, i - 1, array);
		}

		private void swap(int i, int j, Long[] array) {
			long temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}

		private Node[] bubbleSort(Node[] array) {
			for (int i = array.length - 1; i > 0; i--)
				for (int j = 0; j < i; j++)
					if (firstData(array[j]) > firstData(array[j + 1]))
						swap(j, array);
			return array;
		}

		private void swap(int i, Node[] array) {
			swap(i, i + 1, array);
		}

		private void swap(int i, int j, Node[] array) {
			Node temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}

		private long firstData(Node node) {
			return node.datas[0];
		}

	}

	public static void main(String[] args) {

	}

}