package org.dzhou.practice.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author zhoudong
 *
 */
public class ValidParentheses {

	static Map<Character, Character> map = new HashMap<>();
	static Set<Character> set = new HashSet<>();
	static {
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		set.add('(');
		set.add('{');
		set.add('[');
	}

	public boolean isValid(String s) {
		if (s.length() % 2 != 0)
			return false;

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i)))
				stack.add(s.charAt(i));
			else {
				if (stack.size() == 0)
					return false;
				if (stack.pop() != map.get(s.charAt(i)))
					return false;
			}
		}

		return stack.isEmpty();
	}

}
