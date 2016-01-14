/**
 * 
 */
package org.dzhou.interview.treeandgraph.editdistance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 *         ----------------------
 *
 *         copy for study
 *
 *         ----------------------
 */
public class NearbyWords implements SpellingSuggest {

	// THRESHOLD to determine how many words to look through when looking
	// for spelling suggestions (stops prohibitively long searching)
	// For use in the Optional Optimization in Part 2.
	protected static final int THRESHOLD = 1000;

	Dictionary dict;

	public NearbyWords(Dictionary dict) {
		this.dict = dict;
	}

	/**
	 * Return the list of Strings that are one modification away from the input
	 * string.
	 * 
	 * @param s
	 *            The original String
	 * @param wordsOnly
	 *            controls whether to return only words or any String
	 * @return list of Strings which are nearby the original string
	 */
	public List<String> distanceOne(String s, boolean wordsOnly) {
		List<String> retList = new ArrayList<String>();
		insertions(s, retList, wordsOnly);
		subsitution(s, retList, wordsOnly);
		deletions(s, retList, wordsOnly);
		return retList;
	}

	/**
	 * Add to the currentList Strings that are one character mutation away from
	 * the input string.
	 * 
	 * @param s
	 *            The original String
	 * @param currentList
	 *            is the list of words to append modified words
	 * @param wordsOnly
	 *            controls whether to return only words or any String
	 * @return
	 */
	public void subsitution(String s, List<String> currentList, boolean wordsOnly) {
		// for each letter in the s and for all possible replacement characters
		for (int index = 0; index < s.length(); index++) {
			for (int charCode = (int) 'a'; charCode <= (int) 'z'; charCode++) {
				// use StringBuffer for an easy interface to permuting the
				// letters in the String
				StringBuffer sb = new StringBuffer(s);
				sb.setCharAt(index, (char) charCode);
				// if the item isn't in the list, isn't the original string, and
				// (if wordsOnly is true) is a real word, add to the list
				if (!currentList.contains(sb.toString())
						&& (!wordsOnly || dict.isWord(sb.toString())) && !s.equals(sb.toString())) {
					currentList.add(sb.toString());
				}
			}
		}
	}

	/**
	 * Add to the currentList Strings that are one character insertion away from
	 * the input string.
	 * 
	 * @param s
	 *            The original String
	 * @param currentList
	 *            is the list of words to append modified words
	 * @param wordsOnly
	 *            controls whether to return only words or any String
	 * @return
	 */
	public void insertions(String s, List<String> currentList, boolean wordsOnly) {
		for (int index = 0; index < s.length() + 1; index++) {
			for (int charCode = (int) 'a'; charCode <= (int) 'z'; charCode++) {
				StringBuffer sb = new StringBuffer(s);
				sb.insert(index, (char) charCode);
				String result = sb.toString();
				if (!currentList.contains(result) && (!wordsOnly || dict.isWord(result))) {
					currentList.add(result);
				}
			}
		}
	}

	/**
	 * Add to the currentList Strings that are one character deletion away from
	 * the input string.
	 * 
	 * @param s
	 *            The original String
	 * @param currentList
	 *            is the list of words to append modified words
	 * @param wordsOnly
	 *            controls whether to return only words or any String
	 * @return
	 */
	public void deletions(String s, List<String> currentList, boolean wordsOnly) {
		if (s.length() == 1)
			return;
		for (int index = 0; index < s.length(); index++) {
			StringBuffer sb = new StringBuffer(s);
			sb.deleteCharAt(index);
			String result = sb.toString();
			if (!currentList.contains(result) && (!wordsOnly || dict.isWord(result))) {
				currentList.add(result);
			}
		}
	}

	/**
	 * Add to the currentList Strings that are one character deletion away from
	 * the input string.
	 * 
	 * @param word
	 *            The misspelled word
	 * @param numSuggestions
	 *            is the maximum number of suggestions to return
	 * @return the list of spelling suggestions
	 */
	@Override
	public List<String> suggestions(String word, int numSuggestions) {
		// initial variables
		Queue<String> queue = new LinkedList<String>(); // String to explore
		// to avoid exploring the same string multiple times
		HashSet<String> visited = new HashSet<String>();
		List<String> retList = new LinkedList<String>(); // words to return
		// insert first node
		queue.add(word);
		visited.add(word);
		// Implement the remainder of this method, see assignment for
		// algorithm
		boolean wordsOnly = true;
		while (!queue.isEmpty()) {
			List<String> distanceOne = distanceOne(queue.poll(), wordsOnly);
			for (String w : distanceOne) {
				if (visited.contains(w)) {
					continue;
				}
				visited.add(w);
				queue.add(w);
				if (dict.isWord(w))
					retList.add(w);
				if (retList.size() >= numSuggestions)
					return retList;
			}
		}
		return retList;
	}

	public static void main(String[] args) {
		String word = "i";
		Dictionary d = new DictionaryHashSet();
		DictionaryLoader.loadDictionary(d, "data/dict.txt");
		NearbyWords w = new NearbyWords(d);
		List<String> l = w.distanceOne(word, true);
		System.out.println("One away word Strings for for \"" + word + "\" are:");
		System.out.println(l + "\n");
		word = "tailo";
		List<String> suggest = w.suggestions(word, 10);
		System.out.println("Spelling Suggestions for \"" + word + "\" are:");
		System.out.println(suggest);

	}

}
