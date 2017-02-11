package com.dzhou.interview.third;

import java.util.PriorityQueue;

/**
 * 506. Relative Ranks
 * 
 * Given scores of N athletes, find their relative ranks and the people with the
 * top three highest scores, who will be awarded medals: "Gold Medal",
 * "Silver Medal" and "Bronze Medal".
 * 
 * Example 1: Input: [5, 4, 3, 2, 1] Output: ["Gold Medal", "Silver Medal",
 * "Bronze Medal", "4", "5"]
 * 
 * Explanation: The first three athletes got the top three highest scores, so
 * they got "Gold Medal", "Silver Medal" and "Bronze Medal". For the left two
 * athletes, you just need to output their relative ranks according to their
 * scores.
 * 
 * Note:
 * 
 * N is a positive integer and won't exceed 10,000.
 * 
 * All the scores of athletes are guaranteed to be unique.
 * 
 * @author zhoudong
 *
 */
public class RelativeRanks {

	class Node {
		int value;
		int index;

		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

	public String[] findRelativeRanks(int[] nums) {

		PriorityQueue<Node> heap = new PriorityQueue<>((Node n1, Node n2) -> {
			return n2.value - n1.value;
		});

		for (int i = 0; i < nums.length; i++) {
			heap.add(new Node(nums[i], i));
		}
		String[] result = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			Node curr = heap.poll();
			String content = String.valueOf(i + 1);
			if (i == 0) {
				content = "Gold Medal";
			} else if (i == 1) {
				content = "Silver Medal";
			} else if (i == 2) {
				content = "Bronze Medal";
			}
			result[curr.index] = content;
		}

		return result;
	}

}
