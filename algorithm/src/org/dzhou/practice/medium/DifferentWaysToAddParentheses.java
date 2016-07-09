package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators. The
 * valid operators are +, - and *.
 * 
 * 
 * Example 1: Input: "2-1-1"
 * 
 * ((2-1)-1) = 0<br>
 * (2-(1-1)) = 2<br>
 * Output: [0, 2]
 * 
 * Example 2: Input: "2*3-4*5"
 * 
 * (2*(3-(4*5))) = -34<br>
 * ((2*3)-(4*5)) = -14<br>
 * ((2*(3-4))*5) = -10<br>
 * (2*((3-4)*5)) = -10<br>
 * (((2*3)-4)*5) = 10<br>
 * Output: [-34, -14, -10, -10, 10]
 * 
 * @author zhoudong
 *
 */
public class DifferentWaysToAddParentheses {

	enum Operator {
		PLUS('+') {
			@Override
			int execute(int x, int y) {
				return x + y;
			}
		},
		MULTIPLY('*') {
			@Override
			int execute(int x, int y) {
				return x * y;
			}
		},
		DISTRACT('-') {
			@Override
			int execute(int x, int y) {
				return x - y;
			}
		};

		private char operator;

		Operator(char operator) {
			this.operator = operator;
		}

		abstract int execute(int x, int y);

		static Map<Character, Operator> operators = new HashMap<>();
		static {
			for (Operator Operator : Operator.values()) {
				operators.put(Operator.operator, Operator);
			}
		}

		static int execution(int x, int y, char operator) {
			return operators.get(operator).execute(x, y);
		}
	}

	public class Solution {

		public List<Integer> diffWaysToCompute(String input) {

			if (input == null || input.length() == 0) {
				return Collections.emptyList();
			}

			List<Integer> result = new ArrayList<>();

			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if (!isOperator(c)) {
					continue;
				}

				List<Integer> partial1 = diffWaysToCompute(input.substring(0, i));
				List<Integer> partial2 = diffWaysToCompute(input.substring(i + 1, input.length()));

				for (int x : partial1) {
					for (int y : partial2) {
						result.add(calculate(x, y, c));
					}
				}
			}

			if (result.size() == 0) {
				result.add(Integer.parseInt(input));
			}

			return result;
		}

		private boolean isOperator(char c) {
			return c == '+' || c == '-' || c == '*';
		}

		private int calculate(int x, int y, char operator) {
			return Operator.execution(x, y, operator);
		}

	}

}
