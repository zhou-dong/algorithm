package org.dzhou.practice.hard.premium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a non-empty binary search tree and a target value, find k values in the
 * BST that are closest to the target.
 * 
 * Note: <br>
 * 1.Given target value is a floating point. <br>
 * 2.You may assume k is always valid, that is: k ≤ total nodes. <br>
 * 3.You are guaranteed to have only one unique set of k values in the BST that
 * are closest to the target.
 * 
 * Follow up: <br>
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime
 * (where n = total nodes)?
 * 
 * @author zhoudong
 *
 */
public class ClosestBinarySearchTreeValueII {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * Hint:
	 * 
	 * 1.Consider implement these two helper functions: <br>
	 * ---I.getPredecessor(N), which returns the next smaller node to N.<br>
	 * ---II.getSuccessor(N), which returns the next larger node to N.<br>
	 * 2.Try to assume that each node has a parent pointer, it makes the problem
	 * much easier.<br>
	 * 3.Without parent pointer we just need to keep track of the path from the
	 * root to the current node using a stack.<br>
	 * 4.You would need two stacks to track the path in finding predecessor and
	 * successor node separately.<br>
	 * 
	 * @author zhoudong
	 *
	 */
	public class Solution {

	}

	public class Solution1 {
		class HeapNode implements Comparable<HeapNode> {
			int value;
			double distance;

			public HeapNode(int value, double target) {
				this.value = value;
				this.distance = Math.abs(value - target);
			}

			@Override
			public int compareTo(HeapNode node) {
				if (this.distance > node.distance)
					return 1;
				else if (this.distance < node.distance)
					return -1;
				else
					return 0;
			}
		}

		public List<Integer> closestKValues(TreeNode root, double target, int k) {
			PriorityQueue<HeapNode> heap = new PriorityQueue<>(Collections.reverseOrder());
			inOrderTraversal(root, target, k, heap);
			List<Integer> result = new ArrayList<>(k);
			while (!heap.isEmpty()) {
				result.add(heap.poll().value);
			}
			return result;
		}

		private void inOrderTraversal(TreeNode root, double target, int k, PriorityQueue<HeapNode> heap) {
			if (root == null)
				return;
			inOrderTraversal(root.left, target, k, heap);
			addToHeap(heap, root.val, target, k);
			inOrderTraversal(root.right, target, k, heap);
		}

		private void addToHeap(PriorityQueue<HeapNode> heap, int value, double target, int k) {
			heap.add(new HeapNode(value, target));
			if (heap.size() > k) {
				heap.poll();
			}
		}

	}

}
