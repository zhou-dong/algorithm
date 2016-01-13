package org.dzhou.interview.treeandgraph.trie;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * An trie data structure that implements the Dictionary and the AutoComplete
 * ADT
 * 
 * @author Dong Zhou
 *
 */
public class AutoCompleteDictionaryTrie implements Dictionary, AutoComplete {

	private TrieNode root;
	private int size;

	public AutoCompleteDictionaryTrie() {
		root = new TrieNode();
	}

	/**
	 * Insert a word into the trie. For the basic part of the assignment (part
	 * 2), you should ignore the word's case. That is, you should convert the
	 * string to all lower case as you insert it.
	 */
	public boolean addWord(String word) {
		if (isWord(word))
			return false;
		TrieNode current = root;
		char[] chars = word.toLowerCase().toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (!current.getValidNextCharacters().contains(chars[i]))
				current.insert(chars[i]);
			current = current.getChild(chars[i]);
			if (i + 1 == chars.length)
				current.setEndsWord(true);
		}
		size++;
		return true;
	}

	/**
	 * Return the number of words in the dictionary. This is NOT necessarily the
	 * same as the number of TrieNodes in the trie.
	 */
	public int size() {
		return size;
	}

	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) {
		TrieNode current = root;
		char[] chars = s.toLowerCase().toCharArray();
		for (char c : chars) {
			if (!current.getValidNextCharacters().contains(c))
				return false;
			current = current.getChild(c);
		}
		return current.endsWord();
	}

	/**
	 * Returns up to the n "best" predictions, including the word itself, in
	 * terms of length If this string is not in the trie, it returns null.
	 * 
	 * @param text
	 *            The text to use at the word stem
	 * @param n
	 *            The maximum number of predictions desired.
	 * @return A list containing the up to n best predictions
	 */
	@Override
	public List<String> predictCompletions(String prefix, int numCompletions) {
		if (numCompletions < 1)
			return Collections.emptyList();
		prefix = prefix.toLowerCase();
		// This method should implement the following algorithm:
		// 1. Find the stem in the trie. If the stem does not appear in the
		// trie, return an empty list
		TrieNode stem = findNode(prefix);
		if (stem == null)
			return Collections.emptyList();
		// 2. Once the stem is found, perform a breadth first search to generate
		// completions using the following algorithm:
		// Create a queue (LinkedList) and add the node that completes the stem
		// to the back of the list.
		Queue<TrieNode> queue = new LinkedList<>();
		queue.add(stem);
		// Create a list of completions to return (initially empty)
		List<String> result = new LinkedList<>();
		// While the queue is not empty and you don't have enough completions:
		while (!queue.isEmpty()) {
			// remove the first Node from the queue
			TrieNode current = queue.poll();
			// If it is a word, add it to the completions list
			if (current.endsWord()) {
				result.add(current.getText());
				if (result.size() >= numCompletions)
					break;
			}
			// Add all of its child nodes to the back of the queue
			for (char c : current.getValidNextCharacters()) {
				queue.add(current.getChild(c));
			}
		}
		// Return the list of completions
		return result;
	}

	private TrieNode findNode(String stem) {
		TrieNode result = root;
		for (char c : stem.toCharArray()) {
			result = result.getChild(c);
			if (result == null)
				break;
		}
		return result;
	}

	// For debugging
	public void printTree() {
		printNode(root);
	}

	/** Do a pre-order traversal from this node down */
	public void printNode(TrieNode curr) {
		if (curr == null)
			return;
		System.out.println(curr.getText());
		TrieNode next = null;
		for (Character c : curr.getValidNextCharacters()) {
			next = curr.getChild(c);
			printNode(next);
		}
	}

}