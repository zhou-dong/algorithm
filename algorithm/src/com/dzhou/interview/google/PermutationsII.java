package com.dzhou.interview.google;

import java.util.ArrayList;
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
		Map<Integer, Integer> countMap = countMap(nums);
		List<List<Integer>> result = new ArrayList<>();
		helper(result, countMap, new ArrayList<>(), nums.length);
		return result;
	}

	private void helper(List<List<Integer>> result, Map<Integer, Integer> countMap, List<Integer> item, int length) {
		if (item.size() == length) {
			result.add(new ArrayList<>(item));
			return;
		}
		for (int num : countMap.keySet()) {
			if (countMap.get(num) == 0) {
				continue;
			}
			countMap.put(num, countMap.get(num) - 1);
			item.add(num);
			helper(result, countMap, item, length);
			item.remove(item.size() - 1);
			countMap.put(num, countMap.get(num) + 1);
		}
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
