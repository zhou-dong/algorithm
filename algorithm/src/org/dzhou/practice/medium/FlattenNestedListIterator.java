package org.dzhou.practice.medium;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Example 1: Given the list [[1,1],2,[1,1]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,1,2,1,1].
 * 
 * Example 2: Given the list [1,[4,[6]]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,4,6].
 * 
 * @author zhoudong
 *
 */
public class FlattenNestedListIterator {

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

	public class NestedIterator implements Iterator<Integer> {

		Stack<NestedInteger> stack = new Stack<>();

		public NestedIterator(List<NestedInteger> nestedList) {
			addToStack(nestedList);
		}

		@Override
		public Integer next() {
			return stack.pop().getInteger();
		}

		@Override
		public boolean hasNext() {
			while (!stack.isEmpty()) {
				NestedInteger top = stack.peek();
				if (top.isInteger())
					return true;
				else {
					stack.pop();
					addToStack(top.getList());
				}
			}
			return false;
		}

		private void addToStack(List<NestedInteger> list) {
			if (list == null || list.isEmpty())
				return;
			for (int i = list.size() - 1; i >= 0; i--)
				stack.push(list.get(i));
		}

	}

	/**
	 * Your NestedIterator object will be instantiated and called as such:
	 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext())
	 * v[f()] = i.next();
	 */
}
