package org.dzhou.practice.hard.premium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

	class TrieNode {
		List<Character> order;
		Map<Character, TrieNode> children;

		TrieNode() {
			this.order = new ArrayList<>();
			this.children = new HashMap<>();
		}

		TrieNode addChild(char ch) {
			if (!this.children.containsKey(ch)) {
				this.children.put(ch, new TrieNode());
				this.order.add(ch);
			} else {
				if (order.get(order.size() - 1) != ch) {
					return null;
				}
			}
			return this.children.get(ch);
		}

		int size() {
			return children.size();
		}
	}

	class Trie {
		boolean isValid;
		TrieNode root;
		Set<Character> characters;

		Trie(String[] words) {
			this.isValid = true;
			root = new TrieNode();
			characters = new HashSet<>();
			for (String word : words) {
				if (!insert(word)) {
					isValid = false;
					break;
				}
			}
		}

		boolean insert(String word) {
			TrieNode current = root;
			for (char ch : word.toCharArray()) {
				current = current.addChild(ch);
				if (current == null) {
					return false;
				}
				characters.add(ch);
			}
			return current.size() == 0;
		}
	}

	class TopologicalSort {
		Stack<Character> stack;
		Map<Character, Set<Character>> graph;

		public StringBuilder sort(Map<Character, Set<Character>> graph) {
			stack = new Stack<>();
			this.graph = graph;
			Set<Character> visiting = new HashSet<>();
			Set<Character> visited = new HashSet<>();
			for (char key : graph.keySet()) {
				if (!dfs(visiting, visited, key)) {
					return null;
				}
			}
			return result();
		}

		private boolean dfs(Set<Character> visiting, Set<Character> visited, char start) {
			if (visited.contains(start)) {
				return true;
			}
			if (visiting.contains(start)) {
				return false;
			}
			if (!graph.containsKey(start)) {
				stack.push(start);
				visited.add(start);
				return true;
			}
			visiting.add(start);
			for (char connect : graph.get(start)) {
				if (!dfs(visiting, visited, connect)) {
					return false;
				}
			}
			stack.push(start);
			visiting.remove(start);
			visited.add(start);
			return true;
		}

		private StringBuilder result() {
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty())
				sb.append(stack.pop());
			return sb;
		}
	}

	public String alienOrder(String[] words) {
		if (words.length == 1) {
			return words[0];
		}
		Trie trie = new Trie(words);
		if (trie.isValid == false) {
			return "";
		}
		Set<Character> characters = trie.characters;
		Map<Character, Set<Character>> graph = createGraph(trie);
		StringBuilder sb = new TopologicalSort().sort(graph);
		if (sb == null)
			return "";
		if (characters.size() == sb.length()) {
			return sb.toString();
		}
		for (char ch : characters) {
			if (sb.indexOf(ch + "") == -1) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	private Map<Character, Set<Character>> createGraph(Trie trie) {
		Map<Character, Set<Character>> graph = new HashMap<>();
		traverse(trie.root, graph);
		return graph;
	}

	private void traverse(TrieNode trieNode, Map<Character, Set<Character>> graph) {
		addEdges(trieNode.order, graph);
		for (TrieNode child : trieNode.children.values()) {
			traverse(child, graph);
		}
	}

	private void addEdges(List<Character> order, Map<Character, Set<Character>> graph) {
		for (int i = 0; i < order.size() - 1; i++) {
			addToMap(graph, order.get(i), order.get(i + 1));
		}
	}

	private void addToMap(Map<Character, Set<Character>> map, char key, char value) {
		if (!map.containsKey(key))
			map.put(key, new HashSet<>());
		map.get(key).add(value);
	}

}
