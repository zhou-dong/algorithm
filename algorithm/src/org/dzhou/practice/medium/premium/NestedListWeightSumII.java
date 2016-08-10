package org.dzhou.practice.medium.premium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a nested list of integers, return the sum of all integers in the list
 * weighted by their depth.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Different from the previous question where weight is increasing from root to
 * leaf, now the weight is defined from bottom up. i.e., the leaf level integers
 * have weight 1, and the root level integers have the largest weight.
 * 
 * Example 1: <br>
 * Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at
 * depth 2)
 * 
 * Example 2: <br>
 * Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2,
 * and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
 * 
 * @author zhoudong
 *
 */
public class NestedListWeightSumII {

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	public interface NestedInteger {
		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	public class Solution {

		public int depthSumInverse(List<NestedInteger> nestedList) {
			if (nestedList == null)
				return 0;
			return bfs(nestedList);
		}

		private int bfs(List<NestedInteger> nestedList) {
			Queue<Integer> sums = new LinkedList<>();

			Queue<NestedInteger> queue = new LinkedList<>();
			listAddToQueue(queue, nestedList);

			while (!queue.isEmpty()) {
				int size = queue.size();
				int sum = 0;
				for (int i = 0; i < size; i++) {
					NestedInteger nested = queue.poll();
					if (nested.isInteger()) {
						sum += nested.getInteger();
					} else {
						listAddToQueue(queue, nested.getList());
					}
				}
				sums.add(sum);
			}

			return addSums(sums);
		}

		private int addSums(Queue<Integer> sums) {
			int result = 0;
			while (!sums.isEmpty()) {
				result += sums.peek() * sums.size();
				sums.poll();
			}
			return result;
		}

		private void listAddToQueue(Queue<NestedInteger> queue, List<NestedInteger> nestedList) {
			for (NestedInteger nested : nestedList) {
				queue.add(nested);
			}
		}
	}

	// --------------------------- TEST ---------------------------
	protected void test() {
		System.out.println(new Solution().depthSumInverse(data()));
	}

	private List<NestedInteger> data() {
		List<NestedInteger> nestedList = new LinkedList<>();
		nestedList.add(new NestedInt(1, null));
		List<NestedInteger> second = new LinkedList<>();
		nestedList.add(new NestedInt(-1, second));
		second.add(new NestedInt(4, null));
		List<NestedInteger> third = new LinkedList<>();
		third.add(new NestedInt(6, null));
		second.add(new NestedInt(-1, third));
		return nestedList;
	}

	class NestedInt implements NestedInteger {
		private int value = 0;
		private List<NestedInteger> children = null;

		public NestedInt(int value, List<NestedInteger> children) {
			this.value = value;
			this.children = children;
		}

		@Override
		public boolean isInteger() {
			return this.children == null;
		}

		@Override
		public Integer getInteger() {
			return value;
		}

		@Override
		public List<NestedInteger> getList() {
			return this.children;
		}
	}

	public static void main(String[] args) {
		new NestedListWeightSumII().test();
	}

	// --------------------------- TEST ---------------------------

}
