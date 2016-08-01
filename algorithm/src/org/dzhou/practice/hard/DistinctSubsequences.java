package org.dzhou.practice.hard;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * 
 * @author zhoudong
 *
 *         “When you see string problem that is about subsequence or matching,
 *         dynamic programming method should come to your mind naturally. ”
 * 
 *         reference: http://blog.csdn.net/abcbc/article/details/8978146
 * 
 *         - - r a b b b i t <br>
 *         - 1 1 1 1 1 1 1 1 <br>
 *         r 0 1 1 1 1 1 1 1 <br>
 *         a 0 0 1 1 1 1 1 1 <br>
 *         b 0 0 0 1 2 3 3 3 <br>
 *         b 0 0 0 0 1 3 3 3 <br>
 *         i 0 0 0 0 0 0 3 3 <br>
 *         t 0 0 0 0 0 0 0 3 <br>
 */
public class DistinctSubsequences {

	public class Solution {

		public int numDistinct(String s, String t) {

			return 0;
		}

	}

}
