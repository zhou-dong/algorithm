package com.dzhou.interview.google;

import java.util.Stack;

/**
 * 439. Ternary Expression Parser
 * 
 * Difficulty: Medium
 * 
 * Given a string representing arbitrarily nested ternary expressions, calculate
 * the result of the expression. You can always assume that the given expression
 * is valid and only consists of digits 0-9, ?, :, T and F (T and F represent
 * True and False respectively).
 * 
 * Note:
 * 
 * The length of the given string is ≤ 10000.
 * 
 * Each number will contain only one digit.
 * 
 * The conditional expressions group right-to-left (as usual in most languages).
 * 
 * The condition will always be either T or F. That is, the condition will never
 * be a digit.
 * 
 * The result of the expression will always evaluate to either a digit 0-9, T or
 * F.
 * 
 * @author zhoudong
 *
 */
public class TernaryExpressionParser {

	public String parseTernary(String expression) {
		Stack<Character> stack = new Stack<>();
		for (int i = expression.length() - 1; i >= 0; i--) {
			if (expression.charAt(i) != '?') {
				stack.push(expression.charAt(i));
			} else {
				char[] unit = createOneUnit(stack, expression.charAt(--i));
				stack.push(executeOneUnit(unit));
			}
		}
		return stack.isEmpty() ? null : Character.toString(stack.pop());
	}

	private char[] createOneUnit(Stack<Character> stack, char trueOrFalse) {
		char[] unit = new char[5];
		unit[0] = trueOrFalse;
		unit[1] = '?';
		for (int i = 2; i < 5; i++)
			unit[i] = stack.pop();
		return unit;
	}

	private char executeOneUnit(char[] unit) {
		return (unit[0] == 'T') ? unit[2] : unit[4];
	}

}
