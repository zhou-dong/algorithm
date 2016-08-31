package org.dzhou.practice.medium;

import java.util.List;
import java.util.Stack;

/**
 * Given a nested list of integers represented as a string, implement a parser
 * to deserialize it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Note: You may assume that the string is well-formed:
 * 
 * 1.String is non-empty. <br>
 * 2.String does not contain white spaces. <br>
 * 3.String contains only digits 0-9, [, - ,, ]. <br>
 * 
 * Example 1:
 * 
 * Given s = "324",
 * 
 * You should return a NestedInteger object which contains a single integer 324.
 * Example 2:
 * 
 * Given s = "[123,[456,[789]]]",
 * 
 * Return a NestedInteger object containing a nested list with 2 elements:
 * 
 * 1. An integer containing value 123. <br>
 * 2. A nested list containing two elements: <br>
 * ---i. An integer containing value 456. <br>
 * ---ii. A nested list with one element: <br>
 * ------ a. An integer containing value 789. <br>
 * 
 * @author zhoudong
 *
 */
public class MiniParser {

	public class Solution {

		public NestedInteger deserialize(String s) {
			if (s == null || s.length() == 0)
				return null;
			if (s.charAt(0) != '[')
				return new NestedInteger(Integer.parseInt(s));

			Stack<NestedInteger> stack = new Stack<NestedInteger>();
			StringBuilder sb = new StringBuilder();

			for (char c : s.toCharArray()) {
				if (c == '[') {
					stack.push(new NestedInteger());
				} else if (c == ']') {
					NestedInteger top = stack.pop();
					if (sb.length() != 0) {
						top.add(createNestedInteger(sb));
						sb = new StringBuilder();
					}
					if (stack.isEmpty())
						return top;
					stack.peek().add(top);
				} else if (c == ',') {
					if (sb.length() != 0) {
						stack.peek().add(createNestedInteger(sb));
						sb = new StringBuilder();
					}
				} else {
					sb.append(c);
				}
			}

			return null;
		}

		private NestedInteger createNestedInteger(StringBuilder sb) {
			return new NestedInteger(Integer.parseInt(sb.toString()));
		}

	}

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	public class NestedInteger {
		// Constructor initializes an empty nested list.
		public NestedInteger() {
		};

		// Constructor initializes a single integer.
		public NestedInteger(int value) {
		};

		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger() {
			return false;
		};

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger() {
			return -1;
		};

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value) {
		};

		// Set this NestedInteger to hold a nested list and adds a nested
		// integer to it.
		public void add(NestedInteger ni) {
		};

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList() {
			return null;
		};
	}

}
