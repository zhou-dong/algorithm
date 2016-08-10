package org.dzhou.practice.easy.premium;

/**
 * There is a fence with n posts, each post can be painted with one of the k
 * colors.
 * 
 * You have to paint all the posts such that no more than two adjacent fence
 * posts have the same color.
 * 
 * Return the total number of ways you can paint the fence.
 * 
 * Note: n and k are non-negative integers.
 * 
 * @author zhoudong
 *
 *         reference: http://www.lai18.com/content/4269185.html
 */
public class PaintFence {

	public class Solution {

		public int numWays(int n, int k) {
			if (n <= 0 || k <= 0) {
				return 0;
			}
			if (n == 1) {
				return k;
			}
			int sameColorLastTwo = k;
			int diffColorLastTwo = k * (k - 1);
			for (int i = 2; i < n; i++) {
				int temp = diffColorLastTwo;
				diffColorLastTwo = (sameColorLastTwo + diffColorLastTwo) * (k - 1);
				sameColorLastTwo = temp;
			}
			return diffColorLastTwo + sameColorLastTwo;
		}

	}

}
