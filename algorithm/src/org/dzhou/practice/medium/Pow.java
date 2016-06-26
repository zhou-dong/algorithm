package org.dzhou.practice.medium;

/**
 * Implement pow(x, n).
 * 
 * @author zhoudong
 *
 *         reference:http://www.cnblogs.com/springfor/p/3870929.html
 * 
 *         pow(x,n)就是求x的n次方。
 * 
 *         x的N次方可以看做：x^n = x^(n/2)*x^(n/2)*x^(n%2)。所以利用递归求解，当n==1的时候，x^n=x。
 * 
 *         当然n是可以小于0的，2^(-3) = 1/(2^3)。按照上面那个规律就可以解决了。
 * 
 */
public class Pow {

	public class Solution {

		public double myPow(double x, int n) {
			// check boundary
			if (x == 0)
				return 0;
			if (n == 0)
				return 1;
			if (n == 1 || x == 1)
				return x;
			if (x == -1)
				return (n % 2 == 0) ? 1 : -1;
			if (n == Integer.MIN_VALUE)
				return 0;
			// main method
			if (n < 0) {
				return 1 / power(x, -n);
			} else {
				return power(x, n);
			}
		}

		private double power(double x, int n) {
			if (n == 0)
				return 1;
			// x的N次方可以看做：x^n = x^(n/2)*x^(n/2)*x^(n%2)。所以利用递归求解
			int k = n / 2;
			int l = n - k * 2;
			double t1 = myPow(x, k); // x^(n/2)
			double t2 = myPow(x, l); // x^(n%2)
			return t1 * t1 * t2;
		}
	}

}
