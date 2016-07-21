package org.dzhou.research.cci.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         Write a method to return all subsets of a set.
 *
 */
public class PowerSet {

	public List<List<Integer>> getSubsets(List<Integer> set, int index) {
		List<List<Integer>> allsubsets;
		if (set.size() == index) {
			allsubsets = new ArrayList<>();
			allsubsets.add(new ArrayList<>());
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			List<List<Integer>> moresubsets = new ArrayList<>();
			for (List<Integer> subset : allsubsets) {
				List<Integer> newsubset = new ArrayList<>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}

}
