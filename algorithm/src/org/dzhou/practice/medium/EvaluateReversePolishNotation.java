package org.dzhou.practice.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples:
 * 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9<br>
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @author zhoudong
 *
 */
public class EvaluateReversePolishNotation {

	public enum Operator {

		ADD("+") {
			@Override
			int Operation(int x, int y) {
				return y + x;
			}
		},
		SUBTRACT("-") {
			@Override
			int Operation(int x, int y) {
				return y - x;
			}
		},
		MULTIPLY("*") {
			@Override
			int Operation(int x, int y) {
				return y * x;
			}
		},
		DEVIDE("/") {
			@Override
			int Operation(int x, int y) {
				return y / x;
			}
		};

		static Map<String, Operator> instances = null;

		static {
			instances = new HashMap<>();
			for (Operator o : Operator.values()) {
				instances.put(o.operator, o);
			}
		}

		private String operator;

		Operator(String operator) {
			this.operator = operator;
		}

		abstract int Operation(int x, int y);

	}

	public class Solution {

		String operators = "+-*/";

		public int evalRPN(String[] tokens) {

			Stack<Integer> stack = new Stack<>();

			for (String token : tokens) {
				if (!operators.contains(token)) {
					stack.push(Integer.valueOf(token));
				} else {
					stack.push(execute(stack.pop(), stack.pop(), token));
				}
			}

			return stack.pop();
		}

		private int execute(int x, int y, String operator) {
			return Operator.instances.get(operator).Operation(x, y);
		}

	}

}
