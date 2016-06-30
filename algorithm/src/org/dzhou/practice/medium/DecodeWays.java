package org.dzhou.practice.medium;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1<br>
 * 'B' -> 2<br>
 * ...<br>
 * 'Z' -> 26<br>
 * 
 * Given an encoded message containing digits, determine the total number of
 * ways to decode it.
 * 
 * For example,<br>
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * @author zhoudong
 *
 */
public class DecodeWays {

	public class Solution {

		public int numDecodings(String s) {

			if (s == null || s.length() == 0 || s.charAt(0) == '0')
				return 0;

			int[] dp = new int[s.length() + 1];
			dp[0] = 1;
			dp[1] = 1;

			int temp;
			for (int i = 2; i <= s.length(); i++) {
				temp = Integer.parseInt(s.substring(i - 1, i));
				if (temp != 0) // 检查当前字符是不是'0'
					dp[i] = dp[i - 1];
				if (s.charAt(i - 2) != '0') { // 检查当前字符和前一个字符组合在一起是否在1-26之间
					temp = Integer.parseInt(s.substring(i - 2, i));
					if (temp > 0 && temp <= 26)
						dp[i] += dp[i - 2];
				}
			}

			return dp[s.length()];
		}

	}

}
