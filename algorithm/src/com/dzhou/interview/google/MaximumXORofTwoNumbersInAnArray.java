package com.dzhou.interview.google;

/**
 * 421. Maximum XOR of Two Numbers in an Array
 * 
 * Difficulty: Medium
 * 
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * 
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * 
 * Could you do this in O(n) runtime?
 * 
 * Example:
 * 
 * Input: [3, 10, 5, 25, 2, 8]
 * 
 * Output: 28
 * 
 * Explanation: The maximum result is 5 ^ 25 = 28.
 * 
 * @author zhoudong
 *
 *         我不会用hashtable，只会用Trie
 * 
 */
public class MaximumXORofTwoNumbersInAnArray {

	class TrieNode {
		TrieNode[] children = new TrieNode[2];

		TrieNode addChild(int child) {
			if (children[child] == null)
				children[child] = new TrieNode();
			return children[child];
		}

		boolean contains(int bit) {
			return children[bit] != null;
		}
	}

	class Trie {
		TrieNode root = new TrieNode();

		Trie(int[] nums) {
			for (int num : nums) {
				insert(num);
			}
		}

		void insert(int num) {
			TrieNode current = root;
			for (int i = 31; i >= 0; i--) {
				int bit = getBit(num, i);
				current = current.addChild(bit);
			}
		}
	}

	private int getBit(int num, int index) {
		int mask = 1 << index;
		return (num & mask) == 0 ? 0 : 1;
	}

	public int findMaximumXOR(int[] nums) {

		Trie trie = new Trie(nums);
		int max = Integer.MIN_VALUE;

		for (int num : nums) {
			TrieNode node = trie.root;
			int value = 0;
			for (int i = 31; i >= 0; i--) {
				int bit = getBit(num, i);
				if (bit == 1) {
					if (node.contains(0)) {
						value |= 1 << i;
						node = node.children[0];
					} else {
						node = node.children[1];
					}
				} else {
					if (node.contains(1)) {
						value |= 1 << i;
						node = node.children[1];
					} else {
						node = node.children[0];
					}
				}
				max = Math.max(max, value);
			}
		}

		return max;
	}

}
