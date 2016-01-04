package org.dzhou.interview.stackandqueue;

/**
 * Practice of "cracking the code interview"
 * 
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy the elements
 * into any other data structure (such as an array). The stack support the
 * following operations: push, pop, peek and isEmpty.
 * 
 * 
 * @author DONG ZHOU
 *
 */
public class StackSort {

	public static Stack<Integer> sort(Stack<Integer> stack) {
		Stack<Integer> result = new Stack<>();
		while (!stack.isEmpty()) {
			Integer tmp = stack.pop();
			while (!result.isEmpty() && result.peek() < tmp) {
				stack.push(result.pop());
			}
			result.push(tmp);
		}
		return result;
	}

}
