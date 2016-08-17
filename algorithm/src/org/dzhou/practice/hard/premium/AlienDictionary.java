package org.dzhou.practice.hard.premium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * There is a new alien language which uses the latin alphabet. However, the
 * order among letters are unknown to you. You receive a list of words from the
 * dictionary, where words are sorted lexicographically by the rules of this new
 * language. Derive the order of letters in this language.
 * 
 * For example, Given the following words in dictionary,
 * 
 * [ <br>
 * --"wrt", <br>
 * --"wrf", <br>
 * --"er", <br>
 * --"ett", <br>
 * --"rftt" <br>
 * ] <br>
 * 
 * The correct order is: "wertf".
 * 
 * Note:<br>
 * 1.You may assume all letters are in lowercase.<br>
 * 2.If the order is invalid, return an empty string.<br>
 * 3.There may be multiple valid order of letters, return any one of them is
 * fine.
 * 
 * @author zhoudong
 *
 */
public class AlienDictionary {

	public class Solution {

		public String alienOrder(String[] words) {
			Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
			Map<Character, Integer> degree = new HashMap<Character, Integer>();
			String result = "";
			if (words == null || words.length == 0)
				return result;
			for (String s : words) {
				for (char c : s.toCharArray()) {
					degree.put(c, 0);
				}
			}
			for (int i = 0; i < words.length - 1; i++) {
				String cur = words[i];
				String next = words[i + 1];
				int length = Math.min(cur.length(), next.length());
				for (int j = 0; j < length; j++) {
					char c1 = cur.charAt(j);
					char c2 = next.charAt(j);
					if (c1 != c2) {
						Set<Character> set = new HashSet<Character>();
						if (map.containsKey(c1))
							set = map.get(c1);
						if (!set.contains(c2)) {
							set.add(c2);
							map.put(c1, set);
							degree.put(c2, degree.get(c2) + 1);
						}
						break;
					}
				}
			}
			Queue<Character> q = new LinkedList<Character>();
			for (char c : degree.keySet()) {
				if (degree.get(c) == 0)
					q.add(c);
			}
			while (!q.isEmpty()) {
				char c = q.remove();
				result += c;
				if (map.containsKey(c)) {
					for (char c2 : map.get(c)) {
						degree.put(c2, degree.get(c2) - 1);
						if (degree.get(c2) == 0)
							q.add(c2);
					}
				}
			}
			if (result.length() != degree.size())
				return "";
			return result;
		}
	}

	// wrong answer
	public class Solution1 {

		public String alienOrder(String[] words) {
			Map<Character, Set<Character>> graph = createGraph(words);
			Stack<Character> stack = new TopologicalSort().sort(graph);
			return charCount(words) != stack.size() ? "" : stringResult(stack);
		}

		private int charCount(String[] words) {
			Set<Character> uniqueChar = new HashSet<>();
			for (String word : words) {
				for (char c : word.toCharArray()) {
					uniqueChar.add(word.charAt(c));
				}
			}
			return uniqueChar.size();
		}

		private String stringResult(Stack<Character> stack) {
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty())
				sb.append(stack.pop());
			return sb.toString();
		}

		private Map<Character, Set<Character>> createGraph(String[] words) {
			Map<Character, Set<Character>> graph = new HashMap<>();
			for (String word : words) {
				for (int i = 0; i < word.length() - 1; i++) {
					addToMap(graph, word.charAt(i), word.charAt(i + 1));
				}
			}
			return graph;
		}

		private void addToMap(Map<Character, Set<Character>> map, char key, char value) {
			if (!map.containsKey(key))
				map.put(key, new HashSet<>());
			map.get(key).add(value);
		}

		class TopologicalSort {
			Set<Character> visited = new HashSet<>();
			Stack<Character> result = new Stack<>();
			Map<Character, Set<Character>> graph = null;

			public Stack<Character> sort(Map<Character, Set<Character>> graph) {
				if (graph == null)
					return result;
				this.graph = graph;
				sort();
				return result;
			}

			private void sort() {
				for (char c : graph.keySet()) {
					if (visited.contains(c))
						continue;
					dfs(c);
				}
			}

			private void dfs(char c) {
				visited.add(c);
				for (char child : graph.get(c)) {
					if (visited.contains(child))
						continue;
					dfs(child);
				}
				result.add(c);
			}
		}
	}

}
