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
 *         a ^ b = c -> <br>
 *         a ^ c = b -> <br>
 *         b ^ c = a
 */
public class MaximumXORofTwoNumbersInAnArray {

	public static void main(String[] args) {

		System.out.println(2 ^ 25);
		System.out.println(3 ^ 10);
		System.out.println(3 ^ 5);
		System.out.println(3 ^ 25);
		System.out.println(3 ^ 2);
		System.out.println(3 ^ 8);

		System.out.println();

		System.out.println(Integer.toBinaryString(3));
		System.out.println(Integer.toBinaryString(10));
		System.out.println(Integer.toBinaryString(5));
		System.out.println(Integer.toBinaryString(25));
		System.out.println(Integer.toBinaryString(2));
		System.out.println(Integer.toBinaryString(8));

	}
}
