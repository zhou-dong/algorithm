package org.dzhou.practice.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You have a number of envelopes with widths and heights given as a pair of
 * integers (w, h). One envelope can fit into another if and only if both the
 * width and height of one envelope is greater than the width and height of the
 * other envelope.
 * 
 * What is the maximum number of envelopes can you Russian doll? (put one inside
 * other)
 * 
 * Example: Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of
 * envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * 
 * @author zhoudong
 *
 */
public class RussianDollEnvelopes {

	public class Solution {

		public int maxEnvelopes(int[][] envelopes) {
			if (envelopes == null || envelopes.length == 0)
				return 0;
			Arrays.sort(envelopes, new Comparator<int[]>() {
				@Override
				public int compare(int[] a, int[] b) {
					if (a[0] != b[0])
						return a[0] - b[0];
					else
						return a[1] - b[1];
				}
			});
			return lengthOfLIS(envelopes);
		}

		// dynamic programming
		private int lengthOfLIS(int[][] envelopes) {
			int max = 0;
			int[] dp = new int[envelopes.length];
			for (int i = 0; i < dp.length; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
						// dp[i] = (dp[i] > dp[j] + 1) ? dp[i] : (dp[j] + 1);
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
				max = Math.max(max, dp[i]);
			}
			return max;
		}

	}

}
