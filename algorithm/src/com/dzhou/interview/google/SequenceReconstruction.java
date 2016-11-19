package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 444. Sequence Reconstruction
 * 
 * Total Accepted: 718
 * 
 * Total Submissions: 3837
 * 
 * Difficulty: Medium
 * 
 * Contributors: Stomach_ache
 * 
 * Check whether the original sequence org can be uniquely reconstructed from
 * the sequences in seqs. The org sequence is a permutation of the integers from
 * 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common
 * supersequence of the sequences in seqs (i.e., a shortest sequence so that all
 * sequences in seqs are subsequences of it). Determine whether there is only
 * one sequence that can be reconstructed from seqs and it is the org sequence.
 * 
 * Example 1:
 * 
 * Input: org: [1,2,3], seqs: [[1,2],[1,3]]
 * 
 * Output: false
 * 
 * Explanation: [1,2,3] is not the only one sequence that can be reconstructed,
 * because [1,3,2] is also a valid sequence that can be reconstructed.
 * 
 * Example 2:
 * 
 * Input: org: [1,2,3], seqs: [[1,2]]
 * 
 * Output: false
 * 
 * Explanation: The reconstructed sequence can only be [1,2].
 * 
 * Example 3:
 * 
 * Input: org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]
 * 
 * Output: true
 * 
 * Explanation: The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct
 * the original sequence [1,2,3].
 * 
 * Example 4:
 * 
 * Input: org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]
 * 
 * Output: true
 * 
 * @author zhoudong
 *
 *         reference: http://www.cnblogs.com/grandyang/p/6032498.html
 */
public class SequenceReconstruction {

	public boolean sequenceReconstruction(int[] org, int[][] seqs) {
		if (org == null || seqs == null || org.length == 0 || seqs.length == 0)
			return false;
		Map<Integer, Set<Integer>> graph = createGraph(seqs, org.length);
		if (graph == null) {
			return false;
		}
		for (int i = 0; i < org.length - 1; i++) {
			if (!graph.containsKey(org[i])) {
				return false;
			}
			if (!graph.get(org[i]).contains(org[i + 1])) {
				return false;
			}
		}
		return !graph.containsKey(org[org.length - 1]);
	}

	private Map<Integer, Set<Integer>> createGraph(int[][] seqs, int n) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] sequence : seqs) {
			for (int i = 0; i < sequence.length; i++) {
				if (sequence[i] < 1 || sequence[i] > n)
					return null;
				if (i == sequence.length - 1)
					continue;
				add(map, sequence[i], sequence[i + 1]);
			}
		}
		return map;
	}

	private void add(Map<Integer, Set<Integer>> map, int key, int value) {
		if (!map.containsKey(key))
			map.put(key, new HashSet<>());
		map.get(key).add(value);
	}

}
