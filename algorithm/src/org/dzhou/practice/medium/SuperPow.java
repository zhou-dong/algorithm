package org.dzhou.practice.medium;

/**
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is
 * an extremely large positive integer given in the form of an array.
 * 
 * Example1: <br>
 * a = 2 <br>
 * b = [3] Result: 8 <br>
 * 
 * Example2:<br>
 * a = 2 <br>
 * b = [1,0] <br>
 * Result: 1024 <br>
 * 
 * @author zhoudong
 *
 *         reference:
 * 
 *         https://www.hrwhisper.me/leetcode-super-pow/
 * 
 *         http://www.voidcn.com/blog/xindoo/article/p-6144777.html
 * 
 *         123^4567 = ((((((123)^4)^10*(123)^5)^10)*123^6)^10)*123^7
 * 
 */
public class SuperPow {

	public class Solution {

		private int mod = 1337;

		public int superPow(int a, int[] b) {
			int ans = 1;
			a %= mod;
			for (int i = 0; i < b.length; i++) {
				ans = (powmod(ans, 10, mod) * powmod(a, b[i], mod)) % mod;
			}
			return ans;
		}

		private int powmod(int a, int b, int mod) {
			int ans = 1;
			for (int i = 0; i < b; i++) {
				ans = (ans * a) % mod;
			}
			return ans;
		}
	}

	public class Solution1 {
		private int mod = 1337;

		public int superPow(int a, int[] b) {
			int n = b.length;
			int ans = 1;
			for (int i = n - 1; i >= 0; i--) {
				ans = ans * quick_pow(a, b[i]) % mod;
				a = quick_pow(a, 10);
			}
			return ans;
		}

		int quick_pow(int a, int b) {
			int ans = 1;
			a %= mod;
			while (b > 0) {
				if ((b & 1) != 0)
					ans = ans * a % mod;
				a = a * a % mod;
				b >>= 1;
			}
			return ans;

		}
	}

}
