package org.dzhou.practice.medium.premium;

/**
 * We are playing the Guess Game. The game is as follows:
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * 
 * Every time you guess wrong, I'll tell you whether the number I picked is
 * higher or lower.
 * 
 * However, when you guess a particular number x, and you guess wrong, you pay
 * $x. You win the game when you guess the number I picked.
 * 
 * Example:
 * 
 * n = 10, I pick 8.
 * 
 * First round: You guess 5, I tell you that it's higher. You pay $5. <br>
 * Second round: You guess 7, I tell you that it's higher. You pay $7. <br>
 * Third round: You guess 9, I tell you that it's lower. You pay $9. <br>
 * Game over. 8 is the number I picked. <br>
 * You end up paying $5 + $7 + $9 = $21. <br>
 * 
 * Given a particular n ≥ 1, find out how much money you need to have to
 * guarantee a win.
 * 
 * Hint:
 * 
 * 1. The best strategy to play the game is to minimize the maximum loss you
 * could possibly face. Another strategy is to minimize the expected loss. Here,
 * we are interested in the first scenario.
 * 
 * 2. Take a small example (n = 3). What do you end up paying in the worst case?
 * 
 * 3. Check out this article if you're still stuck.
 * 
 * 4. The purely recursive implementation of minimax would be worthless for even
 * a small n. You MUST use dynamic programming.
 * 
 * 5. As a follow-up, how would you modify your code to solve the problem of
 * minimizing the expected loss, instead of the worst-case loss?
 * 
 * @author zhoudong
 *
 *         reference:
 *         https://www.hrwhisper.me/leetcode-guess-number-higher-lower-ii/
 * 
 *         这题要求我们在猜测数字y未知的情况下（1~n任意一个数），要我们在最坏情况下我们支付最少的钱。也就是说要考虑所有y的情况。
 * 
 *         我们假定选择了一个错误的数x，（1<=x<=n && x!=y ）那么就知道接下来应该从[1,x-1 ] 或者[x+1,n]中进行查找。
 *         假如我们已经解决了[1,x-1] 和 [x+1,n]计算问题，我们将其表示为solve(L,x-1)
 *         和solve(x+1,n)，那么我们应该选择max(solve(L,x-1),solve(x+1,n))
 *         这样就是求最坏情况下的损失。总的损失就是 f(x) = x + max(solve(L,x-1),solve(x+1,n))
 * 
 *         那么将x从1~n进行遍历，取使得 f(x) 达到最小，来确定最坏情况下最小的损失，也就是我们初始应该选择哪个数。
 * 
 *         上面的说法其实是一个自顶向下的过程（Top-down），可以用递归来解决。很容易得到如下的代码（这里用了记忆化搜索）：
 */
public class GuessNumberHigherOrLowerII {

	public class Solution {

		public int getMoneyAmount(int n) {
			int[][] dp = new int[n + 1][n + 1];
			return solve(dp, 1, n);
		}

		// dynamic programming
		int solve(int[][] dp, int low, int high) {
			if (low >= high)
				return 0;
			if (dp[low][high] != 0)
				return dp[low][high];
			dp[low][high] = Integer.MAX_VALUE;
			for (int i = low; i <= high; i++) {
				dp[low][high] = Math.min(dp[low][high], i + Math.max(solve(dp, low, i - 1), solve(dp, i + 1, high)));
			}
			return dp[low][high];
		}

	}

}
