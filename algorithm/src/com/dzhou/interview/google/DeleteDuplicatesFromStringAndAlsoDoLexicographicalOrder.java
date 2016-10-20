package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Given a string which only contains lowercase. You need delete the repeated
 * letters only leave one, and try to make the lexicographical order of new
 * string is smallest.
 * 
 * i.e: bcabc
 * 
 * You need delete 1 'b' and 1 'c', so you delete the first 'b' and first 'c',
 * the new string will be abc which is smallest.
 * 
 * If you try to use greedy algorithm to solve this problem, you must sure that
 * you could pass this case:
 * 
 * cbacdcbc. answer is acdb not adcb
 * 
 * @author zhoudong
 *
 */
public class DeleteDuplicatesFromStringAndAlsoDoLexicographicalOrder {

	public String removeDuplicateLetters(String s) {
		Map<Character, Integer> charCount = createHashTable(s);
		Stack<Character> stack = new Stack<>();
		Set<Character> visited = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (visited.contains(c)) {
				subtractCount(charCount, c);
				continue;
			}
			while (!stack.isEmpty() && stack.peek() > c && charCount.get(stack.peek()) > 0) {
				visited.remove(stack.peek());
				stack.pop();
			}
			addCharacter(stack, visited, charCount, c);
		}
		return readFromStack(stack);
	}

	private void addCharacter(Stack<Character> stack, Set<Character> visited, Map<Character, Integer> charCount,
			char c) {
		stack.push(c);
		visited.add(c);
		subtractCount(charCount, c);
	}

	private String readFromStack(Stack<Character> stack) {
		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty())
			result.append(stack.pop());
		return result.reverse().toString();
	}

	private void subtractCount(Map<Character, Integer> map, char key) {
		map.put(key, map.get(key) - 1);
	}

	private Map<Character, Integer> createHashTable(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}

}
