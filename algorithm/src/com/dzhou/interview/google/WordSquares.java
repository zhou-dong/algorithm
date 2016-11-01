package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 425. Word Squares
 * 
 * Difficulty: Hard
 * 
 * Given a set of words (without duplicates), find all word squares you can
 * build from them.
 * 
 * A sequence of words forms a valid word square if the kth row and column read
 * the exact same string, where 0 ≤ k < max(numRows, numColumns).
 * 
 * For example, the word sequence ["ball","area","lead","lady"] forms a word
 * square because each word reads the same both horizontally and vertically.
 * 
 * b a l l <br>
 * a r e a <br>
 * l e a d <br>
 * l a d y <br>
 * 
 * Note: <br>
 * There are at least 1 and at most 1000 words. <br>
 * All words will have the exact same length. <br>
 * Word length is at least 1 and at most 5. <br>
 * Each word contains only lowercase English alphabet a-z. <br>
 * 
 * Example 1:
 * 
 * Input: <br>
 * ["area","lead","wall","lady","ball"]
 * 
 * Output: <br>
 * [ <br>
 * --[ "wall", <br>
 * ----"area", <br>
 * ----"lead", <br>
 * ----"lady" <br>
 * --], <br>
 * --[ "ball", <br>
 * ----"area", <br>
 * ----"lead", <br>
 * ----"lady" <br>
 * --] <br>
 * ] <br>
 * 
 * Explanation: The output consists of two word squares. The order of output
 * does not matter (just the order of words in each word square matters).
 * 
 * Example 2:
 * 
 * Input: <br>
 * ["abat","baba","atan","atal"]
 * 
 * Output: <br>
 * [ <br>
 * --[ "baba", <br>
 * ----"abat", <br>
 * ----"baba", <br>
 * ----"atan" <br>
 * --], <br>
 * --[ "baba", <br>
 * ----"abat", <br>
 * ----"baba", <br>
 * ----"atal" <br>
 * --] <br>
 * ] <br>
 * 
 * Explanation: The output consists of two word squares. The order of output
 * does not matter (just the order of words in each word square matters). Show
 * Company Tags Show Tags Show Similar Problems
 * 
 * @author zhoudong
 *
 *         Solution: Backtracking + Trie
 *
 */
public class WordSquares {

	class TrieNode {
		Map<Character, TrieNode> children;
		boolean isWord;
		String word;

		TrieNode() {
			this.children = new HashMap<>();
			isWord = false;
			word = null;
		}

		TrieNode addChild(char ch) {
			if (!children.containsKey(ch))
				children.put(ch, new TrieNode());
			return children.get(ch);
		}

		TrieNode getChild(char ch) {
			return children.containsKey(ch) ? children.get(ch) : null;
		}

		List<String> getWords() {
			List<String> result = new ArrayList<>();
			getWords(this, result);
			return result;
		}

		private void getWords(TrieNode node, List<String> result) {
			if (node.isWord) {
				result.add(node.word);
			}
			if (node.children.isEmpty()) {
				return;
			}
			for (TrieNode child : node.children.values()) {
				getWords(child, result);
			}
		}
	}

	class Trie {
		TrieNode root;

		Trie(String[] words) {
			root = new TrieNode();
			for (String word : words) {
				insert(word);
			}
		}

		void insert(String word) {
			TrieNode current = root;
			for (char ch : word.toCharArray())
				current = current.addChild(ch);
			current.isWord = true;
			current.word = word;
		}

		List<String> search(char[] prefix) {
			TrieNode current = root;
			for (char ch : prefix) {
				current = current.getChild(ch);
				if (current == null) {
					return Collections.emptyList();
				}
			}
			return current.getWords();
		}
	}

	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> result = new ArrayList<>();
		Trie trie = new Trie(words);
		for (String word : words) {
			List<String> item = new ArrayList<>();
			item.add(word);
			backTracking(result, item, trie, word.length());
		}
		return result;
	}

	private void backTracking(List<List<String>> result, List<String> item, Trie trie, int length) {
		if (item.size() == length) {
			result.add(new ArrayList<>(item));
			return;
		}
		char[] prefix = prefix(item, item.size());
		for (String word : trie.search(prefix)) {
			item.add(word);
			backTracking(result, item, trie, word.length());
			item.remove(item.size() - 1);
		}
	}

	private char[] prefix(List<String> item, int j) {
		char[] prefix = new char[j];
		for (int i = 0; i < j; i++)
			prefix[i] = item.get(i).charAt(j);
		return prefix;
	}

}
