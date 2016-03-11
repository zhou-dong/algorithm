package org.dzhou.interview.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class ChageWord {

	public static LinkedList<String> transfrom(String startWord, String stopWord,
			Set<String> dictionary) {
		startWord = startWord.toUpperCase();
		stopWord = stopWord.toUpperCase();

		Queue<String> actionQueue = new LinkedList<>();
		Set<String> visitedSet = new HashSet<>();
		Map<String, String> backtrackMap = new TreeMap<>();

		actionQueue.add(startWord);
		visitedSet.add(startWord);

		while (!actionQueue.isEmpty()) {
			String w = actionQueue.poll();
			for (String v : getOneEditWords(w)) {
				if (v.equals(stopWord)) {
					LinkedList<String> result = new LinkedList<>();
					result.add(v);
					while (w != null) {
						result.add(0, w);
						w = backtrackMap.get(w);
					}
				}
				if (dictionary.contains(v)) {
					if (!visitedSet.contains(v)) {
						actionQueue.add(v);
						visitedSet.add(v);
						backtrackMap.put(v, w);
					}
				}
			}
		}

		return null;
	}

	static Set<String> getOneEditWords(String word) {
		Set<String> words = new TreeSet<>();
		for (int i = 0; i < word.length(); i++) {
			char[] wordArray = word.toCharArray();
			for (char c = 'A'; c <= 'Z'; c++) {
				if (c != word.charAt(i)) {
					wordArray[i] = c;
					words.add(new String(wordArray));
				}
			}
		}
		return words;
	}

}
