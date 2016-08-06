package org.dzhou.practice.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * For example, Given words = ["oath","pea","eat","rain"] and board =
 * 
 * [<br>
 * --['o','a','a','n'],<br>
 * --['e','t','a','e'],<br>
 * --['i','h','k','r'],<br>
 * --['i','f','l','v']<br>
 * ]<br>
 * 
 * Return ["eat","oath"].
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author zhoudong
 *
 */
public class WordSearchII {

	public class Solution {

		class TrieNode {
			Map<Character, TrieNode> children;
			boolean isWord;
			String word;

			public TrieNode() {
				isWord = false;
				word = null;
				children = new HashMap<>();
			}

			public boolean contains(char c) {
				return children.containsKey(c);
			}

			public boolean addChild(char c) {
				if (contains(c))
					return false;
				children.put(c, new TrieNode());
				return true;
			}

			public TrieNode getChild(char c) {
				return children.get(c);
			}

		}

		class Trie {
			TrieNode root;

			public Trie() {
				root = new TrieNode();
			}

			public void insert(String word) {
				TrieNode node = root;
				for (char c : word.toCharArray()) {
					node.addChild(c);
					node = node.getChild(c);
				}
				node.isWord = true;
				node.word = word;
			}

			public TrieNode search(String word) {
				TrieNode node = root;
				for (char c : word.toCharArray()) {
					if (!node.contains(c))
						return null;
					node = node.getChild(c);
				}
				return node;
			}

			public boolean isWord(String word) {
				TrieNode node = search(word);
				return node != null && node.isWord;
			}

			public boolean startWith(String word) {
				return search(word) != null;
			}
		}

		public List<String> findWords(char[][] board, String[] words) {
			if (words == null || words.length == 0 || board == null || board.length == 0 || board[0].length == 0)
				return Collections.emptyList();

			Trie trie = new Trie();
			for (String word : words) {
				trie.insert(word);
			}

			boolean[][] visited = new boolean[board.length][board[0].length];
			Set<String> result = new HashSet<>();

			for (int row = 0; row < board.length; row++) {
				for (int col = 0; col < board[row].length; col++) {
					helper(result, board, "", row, col, trie, visited);
				}
			}

			return new ArrayList<>(result);
		}

		private void helper(Set<String> result, char[][] board, String str, int row, int col, Trie trie,
				boolean[][] visited) {
			if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
				return;
			}

			str += board[row][col];

			if (!trie.startWith(str))
				return;

			if (trie.isWord(str))
				result.add(str);

			visited[row][col] = true;
			helper(result, board, str, row - 1, col, trie, visited);
			helper(result, board, str, row + 1, col, trie, visited);
			helper(result, board, str, row, col - 1, trie, visited);
			helper(result, board, str, row, col + 1, trie, visited);
			visited[row][col] = false;
		}
	}

}
