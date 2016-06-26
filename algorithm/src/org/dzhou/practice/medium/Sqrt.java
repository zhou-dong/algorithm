package org.dzhou.practice.medium;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * @author zhoudong
 *
 *         http://www.cnblogs.com/AnnieKim/archive/2013/04/18/3028607.html
 */
public class Sqrt {

	// 二分搜索
	public class Solution {
		public int mySqrt(int x) {
			// 对于一个非负数n，它的平方根不会大于（n/2+1）
			long i = 0, j = x / 2 + 1;
			while (i <= j) {
				long mid = (i + j) / 2;
				long sq = mid * mid;
				if (sq == x)
					return (int) mid;
				else if (sq < x)
					i = mid + 1;
				else
					j = mid - 1;
			}
			return (int) j;
		}
	}

	// 牛顿迭代法
	public class Solution1 {

		/*
		 * 判断xi是否是f(x)=0的解有两种方法：
		 * 
		 * 一是直接计算f(xi)的值判断是否为0，
		 * 
		 * 二是判断前后两个解xi和xi-1是否无限接近。
		 * 
		 * 经过(xi, f(xi))这个点的切线方程为f(x) = f(xi) + f’(xi)(x - xi)，
		 * 
		 * 其中f'(x)为f(x)的导数，本题中为2x。
		 * 
		 * 令切线方程等于0，即可求出xi+1=xi - f(xi) / f'(xi)。
		 * 
		 * 继续化简，xi+1=xi - (xi2 - n) / (2xi) = xi - xi / 2 + n / (2xi) = xi / 2 +
		 * n / 2xi = (xi + n/xi) / 2。
		 */
		public int mySqrt(int x) {
			if (x == 0)
				return 0;
			double last = 0;
			double res = 1;
			while (res != last) {
				last = res;
				res = (res + x / res) / 2;
			}
			return (int) res;
		}

	}

}
