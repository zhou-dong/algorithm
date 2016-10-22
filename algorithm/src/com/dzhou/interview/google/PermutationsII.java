package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 47. Permutations II
 * 
 * Difficulty: Medium
 * 
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, <br>
 * [1,1,2] have the following unique permutations: <br>
 * [ <br>
 * --[1,1,2], <br>
 * --[1,2,1], <br>
 * --[2,1,1] <br>
 * ] <br>
 * 
 * @author zhoudong
 *
 */
public class PermutationsII {

	public List<List<Integer>> permuteUnique(int[] nums) {

	}

	private Map<Integer, Integer> countMap(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
		}
		return map;
	}

}
