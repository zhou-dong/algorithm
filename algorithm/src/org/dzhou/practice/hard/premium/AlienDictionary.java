package org.dzhou.practice.hard.premium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
			Map<Character, Set<Character>> graph = createGraph(words);
			Stack<Character> stack = new TopologicalSort().sort(graph);
			return stringResult(stack);
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
