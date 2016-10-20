package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. Implement Trie (Prefix Tree)
 * 
 * Difficulty: Medium
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author zhoudong
 *
 */
public class ImplementTrie {

	class Trie {

		class TrieNode {
			Map<Character, TrieNode> children;
			boolean isWord;

			TrieNode() {
				isWord = false;
				children = new HashMap<>();
			}

			boolean contains(char c) {
				return this.children.containsKey(c);
			}

			void addChild(char c) {
				this.children.put(c, new TrieNode());
			}

			TrieNode getChild(char c) {
				return this.children.get(c);
			}
		}

		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			TrieNode current = root;
			for (char c : word.toCharArray()) {
				if (!current.contains(c)) {
					current.addChild(c);
				}
				current = current.getChild(c);
			}
			current.isWord = true;
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			TrieNode prefix = searchPrefix(word);
			return prefix == null ? false : prefix.isWord == true;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			return searchPrefix(prefix) != null;
		}

		private TrieNode searchPrefix(String str) {
			if (str == null || str.length() == 0)
				return null;
			TrieNode current = root;
			for (char c : str.toCharArray()) {
				if (current.contains(c)) {
					current = current.getChild(c);
				} else {
					return null;
				}
			}
			return current;
		}

	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}
