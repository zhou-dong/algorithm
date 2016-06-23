package org.dzhou.practice.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Add and Search Word - Data structure design
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word) bool search(word) search(word) can search a literal word
 * or a regular expression string containing only letters a-z or .. A . means it
 * can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad")<br>
 * addWord("dad")<br>
 * addWord("mad")<br>
 * search("pad") -> false<br>
 * search("bad") -> true<br>
 * search(".ad") -> true<br>
 * search("b..") -> true<br>
 * 
 * Note: You may assume that all words are consist of lowercase letters a-z.
 * 
 * @author zhoudong
 *
 */
public class AddAndSearchWord {

	public class WordDictionary {

		private TrieNode root;

		public WordDictionary() {
			root = new TrieNode();
		}

		// Adds a word into the data structure.
		public void addWord(String word) {
			TrieNode curr = root;
			for (char c : word.toCharArray()) {
				if (!curr.children.containsKey(c))
					curr.children.put(c, new TrieNode());
				curr = curr.children.get(c);
			}
			curr.isWord = true;
		}

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			return search(word, 0, root);
		}

		private boolean search(String word, int index, TrieNode curr) {
			if (index == word.length()) {
				return false;
			}

			char c = word.charAt(index);
			if (curr.children.containsKey(c)) {
				if (index == word.length() - 1) {
					if (curr.children.get(c).isWord) {
						return true;
					} else {
						return false;
					}
				}
				return search(word, index + 1, curr.children.get(c));
			} else if (c == '.') {
				boolean result = false;
				for (Map.Entry<Character, TrieNode> child : curr.children.entrySet()) {
					if (index == word.length() - 1 && child.getValue().isWord) {
						return true;
					}
					// if any path is true, set result to be true;
					if (search(word, index + 1, child.getValue())) {
						result = true;
					}
				}
				return result;
			} else {
				return false;
			}

		}
	}

	class TrieNode {
		public boolean isWord;
		public Map<Character, TrieNode> children;

		TrieNode() {
			children = new HashMap<>();
			isWord = false;
		}
	}

}
