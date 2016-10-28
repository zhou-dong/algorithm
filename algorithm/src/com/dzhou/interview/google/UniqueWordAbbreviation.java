package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 288. Unique Word Abbreviation
 * 
 * Difficulty: Easy
 * 
 * An abbreviation of a word follows the form <first letter><number><last
 * letter>. Below are some examples of word abbreviations:
 * 
 * a) it --> it (no abbreviation) <br>
 * b) d|o|g --> d1g <br>
 * c) i|nternationalizatio|n --> i18n <br>
 * d) l|ocalizatio|n --> l10n <br>
 * 
 * Assume you have a dictionary and given a word, find whether its abbreviation
 * is unique in the dictionary. A word's abbreviation is unique if no other word
 * from the dictionary has the same abbreviation.
 * 
 * Example: Given dictionary = [ "deer", "door", "cake", "card" ]
 * 
 * isUnique("dear") -> false
 * 
 * isUnique("cart") -> true
 * 
 * isUnique("cane") -> false
 * 
 * isUnique("make") -> true
 * 
 * @author zhoudong
 *
 */
public class UniqueWordAbbreviation {

	public class ValidWordAbbr {
		Map<String, Set<String>> map = null;

		public ValidWordAbbr(String[] dictionary) {
			map = new HashMap<>();
			for (String word : dictionary) {
				String abbr = wordAbbr(word);
				if (!map.containsKey(abbr))
					map.put(abbr, new HashSet<>());
				map.get(abbr).add(word);
			}
		}

		public boolean isUnique(String word) {
			String abbr = wordAbbr(word);
			if (!map.containsKey(abbr))
				return true;
			Set<String> set = map.get(abbr);
			return set.size() == 1 && set.contains(word);
		}

		private String wordAbbr(String word) {
			if (word.length() < 3)
				return word;
			StringBuilder sb = new StringBuilder();
			sb.append(word.charAt(0));
			sb.append(word.length() - 2);
			sb.append(word.charAt(word.length() - 1));
			return sb.toString();
		}
	}

	// Your ValidWordAbbr object will be instantiated and called as such:
	// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
	// vwa.isUnique("Word");
	// vwa.isUnique("anotherWord");
}
