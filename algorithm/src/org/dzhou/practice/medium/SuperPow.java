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
 *         思路: 需要用到的数学知识 <br>
 *         1. a^b % 1337 = (a%1337)^b % 1337 <br>
 *         2. xy % 1337 = ((x%1337) * (y%1337)) % 1337, 其中xy是一个数字如:45, 98等等
 * 
 */
public class SuperPow {

	public class Solution {
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
