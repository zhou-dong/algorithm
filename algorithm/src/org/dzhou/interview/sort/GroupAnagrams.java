package org.dzhou.interview.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class GroupAnagrams implements Comparator<String> {

	int index = 0;

	public String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	@Override
	public int compare(String o1, String o2) {
		return sortChars(o1).compareTo(o2);
	}

	public void sort(String[] array) {
		HashMap<String, ArrayList<String>> mapList = new HashMap<>();
		for (String s : array) {
			String key = sortChars(s);
			if (!mapList.containsKey(key))
				mapList.put(key, new ArrayList<>());
			mapList.get(key).add(s);
		}
		for (String key : mapList.keySet()) {
			ArrayList<String> list = mapList.get(key);
			for (String t : list) {
				array[index] = t;
				index++;
			}
		}
	}

}
