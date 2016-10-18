package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 316. Remove Duplicate Letters
 * 
 * Difficulty: Hard
 * 
 * Given a string which contains only lowercase letters, remove duplicate
 * letters so that every letter appear once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible
 * results.
 * 
 * Example: Given "bcabc" Return "abc"
 * 
 * Given "cbacdcbc" Return "acdb"
 * 
 * 本题主要是来考察： stack 和 greedy
 * 
 * @author zhoudong
 *
 *         reference: http://www.jianshu.com/p/05f9c13acef4
 * 
 *         上面链接中讲的很棒，看上面的讲解就够了！
 * 
 *         下面是引用他的话：
 * 
 *         首先，为什么拿Stack来做呢？他的什么特性复合这道题木呢？我们需要拿后面的字母和前面的作比较，进行操作，
 *         而不需要拿前面的字母和后面的字母作比较。所以，栈很合适。
 * 
 */

public class RemoveDuplicateLetters {

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
