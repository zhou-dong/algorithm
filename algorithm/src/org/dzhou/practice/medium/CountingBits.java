package org.dzhou.practice.medium;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤
 * i ≤ num calculate the number of 1's in their binary representation and return
 * them as an array.
 * 
 * Example:<br>
 * For num = 5 you should return [0,1,1,2,1,2].<br>
 * 
 * Follow up:<br>
 * 
 * It is very easy to come up with a solution with run time
 * O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a
 * single pass?<br>
 * Space complexity should be O(n).<br>
 * Can you do it like a boss? Do it without using any builtin function like
 * __builtin_popcount in c++ or in any other language.
 * 
 * Hint:<br>
 * 
 * You should make use of what you have produced already.<br>
 * Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to
 * generate new range from previous.<br>
 * Or does the odd/even status of the number help you in calculating the number
 * of 1s?<br>
 * 
 * 0 0000 0<br>
 * -------------<br>
 * 1 0001 1<br>
 * -------------<br>
 * 2 0010 1<br>
 * 3 0011 2<br>
 * -------------<br>
 * 4 0100 1<br>
 * 5 0101 2<br>
 * 6 0110 2<br>
 * 7 0111 3<br>
 * -------------<br>
 * 8 1000 1<br>
 * 9 1001 2<br>
 * 10 1010 2<br>
 * 11 1011 3<br>
 * 12 1100 2<br>
 * 13 1101 3<br>
 * 14 1110 3<br>
 * 15 1111 4<br>
 * 
 * dp[0] = 0;
 * 
 * dp[1] = dp[0] + 1;
 * 
 * dp[2] = dp[0] + 1;
 * 
 * dp[3] = dp[1] + 1;
 * 
 * dp[4] = dp[0] + 1;
 * 
 * dp[5] = dp[1] + 1;
 * 
 * dp[6] = dp[2] + 1;
 * 
 * dp[7] = dp[3] + 1;
 * 
 * dp[8] = dp[0] + 1; ...
 * 
 * This is the function we get, now we need find the other pattern for the
 * function to get the general function. After we analyze the above function, we
 * can get dp[0] = 0;
 * 
 * dp[1] = dp[1-1] + 1;
 * 
 * dp[2] = dp[2-2] + 1;
 * 
 * dp[3] = dp[3-2] + 1;
 * 
 * dp[4] = dp[4-4] + 1;
 * 
 * dp[5] = dp[5-4] + 1;
 * 
 * dp[6] = dp[6-4] + 1;
 * 
 * dp[7] = dp[7-4] + 1;
 * 
 * dp[8] = dp[8-8] + 1; ..
 * 
 * Obviously, we can find the pattern for above example, so now we get the
 * general function
 * 
 * dp[index] = dp[index - offset] + 1;
 * 
 * @author zhoudong
 *
 */
public class CountingBits {

	public int[] countBits(int num) {
		int[] dp = new int[num + 1];
		dp[0] = 0;
		int offset = 1;
		for (int i = 1; i < num + 1; i++) {
			if (i == (offset << 1))
				offset <<= 1;
			dp[i] = dp[i - offset] + 1;
		}
		return dp;
	}

}
