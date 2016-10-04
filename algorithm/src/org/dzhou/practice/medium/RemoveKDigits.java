package org.dzhou.practice.medium;

import java.util.Stack;

/**
 * 402. Remove K Digits
 * 
 * Difficulty: Medium
 * 
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * Note: The length of num is less than 10002 and will be ≥ k. The given num
 * does not contain any leading zero.
 * 
 * Example 1:
 * 
 * Input: num = "1432219", k = 3 Output: "1219" Explanation: Remove the three
 * digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * 
 * Example 2:
 * 
 * Input: num = "10200", k = 1 Output: "200" Explanation: Remove the leading 1
 * and the number is 200. Note that the output must not contain leading zeroes.
 * 
 * Example 3:
 * 
 * Input: num = "10", k = 2 Output: "0" Explanation: Remove all the digits from
 * the number and it is left with nothing which is 0.
 * 
 * @author zhoudong
 *
 */
public class RemoveKDigits {

	public String removeKdigits(String num, int k) {
		if (num.length() == 0 || num.length() <= k) {
			return "0";
		}

		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < num.length(); i++) {
			int cur = num.charAt(i) - '0';
			while (!stack.isEmpty() && cur < stack.peek()
					&& num.length() - i - 1 >= (num.length() - k) - stack.size()) {
				stack.pop();
			}
			if (stack.size() < num.length() - k)
				stack.push(cur);
		}

		StringBuilder res = new StringBuilder();
		while (!stack.isEmpty())
			res.insert(0, stack.pop());

		while (res.length() > 0 && res.charAt(0) == '0')
			res.deleteCharAt(0);

		if (res.length() == 0)
			return "0";
		return res.toString();
	}

}
