package org.dzhou.interview.moderate;

import java.util.HashMap;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         设计一个方法，找出任意指定单词在一本书中出现的频率。
 *
 */
public class GetFrequency {

	public static HashMap<String, Integer> setDictionary(String[] book) {
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : book) {
			if (isEmpty(word))
				continue;
			word = word.trim().toLowerCase();
			if (!map.containsKey(word))
				map.put(word, 0);
			map.put(word, map.get(word) + 1);
		}
		return map;
	}

	public static int getFrequency(HashMap<String, Integer> map, String word) {
		if (map == null || word == null || isEmpty(word))
			return -1;
		word = word.toLowerCase();
		return map.containsKey(word) ? map.get(word) : 0;
	}

	public static boolean isEmpty(String word) {
		return word == null || word.length() == 0 || word.trim().length() == 0;
	}

}
