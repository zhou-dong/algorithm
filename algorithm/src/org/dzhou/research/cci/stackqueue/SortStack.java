package org.dzhou.research.cci.stackqueue;

import java.util.Stack;

/**
 * Practice of "cracking the code interview"
 * 
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy the elements
 * into any other data structure (such as an array). The stack support the
 * following operations: push, pop, peek and isEmpty.
 * 
 * @author DONG ZHOU
 *
 *         1. Need two more temporary stack<br>
 *         2. One more stack
 */
public class SortStack {

	Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> result = new Stack<>();
		while (!s.isEmpty()) {
			int temp = s.pop();
			while (!result.isEmpty() && result.peek() > temp) {
				s.push(result.pop());
			}
			result.push(temp);
		}
		return result;
	}

}
