package org.dzhou.practice.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement Trie (Prefix Tree)
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lower case letters a-z.
 * 
 * @author zhoudong
 *
 */
public class ImplementTrie {

	class TrieNode {
		boolean isWord;
		Map<Character, TrieNode> children;

		// Initialize your data structure here.
		public TrieNode() {
			isWord = false;
			children = new HashMap<>();
		}
	}

	public class Trie {

		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			TrieNode curr = root;
			for (char c : word.toCharArray()) {
				if (!curr.children.containsKey(c))
					curr.children.put(c, new TrieNode());
				curr = curr.children.get(c);
			}
			curr.isWord = true;
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

		private TrieNode searchPrefix(String word) {
			if (word == null || word.length() == 0)
				return null;
			TrieNode curr = root;
			for (char c : word.toCharArray()) {
				if (!curr.children.containsKey(c))
					return null;
				curr = curr.children.get(c);
			}
			return curr;
		}
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}
