package org.dzhou.research.cci.treegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         A binary search tree was created by traversing through an array from
 *         left to right and inserting each element. Given a binary search tree
 *         with distinct elements, print all possible arrays that could have led
 *         to this tree.
 *
 */
public class BstSequence {

	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	public class Solution {

		public List<LinkedList<Integer>> allSequences(TreeNode node) {
			List<LinkedList<Integer>> result = new ArrayList<>();
			if (node == null) {
				result.add(new LinkedList<>());
				return result;
			}

			LinkedList<Integer> prefix = new LinkedList<>();
			prefix.add(node.data);

			List<LinkedList<Integer>> leftSeq = allSequences(node.left);
			List<LinkedList<Integer>> rightSeq = allSequences(node.right);

			for (LinkedList<Integer> left : leftSeq) {
				for (LinkedList<Integer> right : rightSeq) {
					List<LinkedList<Integer>> weaved = new ArrayList<>();
					weaveLists(left, right, weaved, prefix);
					result.addAll(weaved);
				}
			}

			return result;
		}

		void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, List<LinkedList<Integer>> results,
				LinkedList<Integer> prefix) {
			if (first.size() == 0 || second.size() == 0) {
				LinkedList<Integer> result = new LinkedList<>(prefix);
				result.addAll(first);
				result.addAll(second);
				results.add(result);
				return;
			}
			int headFirst = first.removeFirst();
			prefix.addLast(headFirst);
			weaveLists(first, second, results, prefix);
			prefix.removeLast();
			first.addFirst(headFirst);

			int headSecond = second.removeFirst();
			prefix.addLast(headSecond);
			weaveLists(first, second, results, prefix);
			prefix.removeLast();
			second.addFirst(headSecond);
		}
	}

}
