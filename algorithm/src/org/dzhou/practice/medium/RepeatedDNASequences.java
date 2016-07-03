package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * @author zhoudong
 *
 */
public class RepeatedDNASequences {

	public class Solution {

		public List<String> findRepeatedDnaSequences(String s) {
			if (s == null || s.length() < 11)
				return Collections.emptyList();

			List<String> result = new ArrayList<>();
			Map<String, Integer> map = new HashMap<>();
			StringBuilder sb = new StringBuilder();

			for (char c : s.toCharArray()) {
				sb.append(c);
				if (sb.length() < 10)
					continue;
				String temp = sb.toString();
				if (!map.containsKey(temp)) {
					map.put(temp, 1);
				} else {
					if (map.get(temp) == 1)
						result.add(temp);
					map.put(temp, map.get(temp) + 1);
				}
				sb.deleteCharAt(0);
			}

			return result;
		}

	}

}
