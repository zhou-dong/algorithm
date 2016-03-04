package org.dzhou.interview.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Practice of "cracking the code interview"
 * 
 * 给定一组单词，编写一个程序，找出其中最长的单词，且该单词由这组单词中的其它单词组合而成。
 * 
 * @author DONG ZHOU
 *
 */
public class LongestWord {

	public String getLongestWord(String[] list) {
		String[] array = sortByLength(list);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		for (String str : array) {
			map.put(str, true);
		}
		for (String str : array) {
			for (int i = 1; i < str.length(); i++) {
				String left = str.substring(0, i);
				String right = str.substring(i);
				if (map.get(left) && map.get(right)) {
					return str;
				}
			}
		}
		return null;
	}

	public String getLongestWord2(String[] list) {
		String[] array = sortByLength(list);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		for (String str : array) {
			map.put(str, true);
		}
		for (String str : array) {
			if (canBuildWord(str, true, map)) {
				return str;
			}
		}
		return "";
	}

	private boolean canBuildWord(String str, boolean isOriginalWord, Map<String, Boolean> map) {
		if (map.containsKey(str) && isOriginalWord == false) {
			return map.get(str);
		}
		for (int i = 1; i < str.length(); i++) {
			String left = str.substring(0, i);
			String right = str.substring(i);
			if (map.containsKey(left) && map.get(left) == true && canBuildWord(right, false, map)) {
				return true;
			}
		}
		map.put(str, false);
		return false;
	}

	// TODO
	public String[] sortByLength(String[] list) {
		return null;
	}
}
