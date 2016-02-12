package org.dzhou.interview.math;

public class ReverseInteger {

	public int reverse(int x) {

		// flag marks if x is negative
		boolean flag = false;
		if (x < 0) {
			x = 0 - x;
			flag = true;
		}

		int res = 0;
		int p = x;

		int max = Integer.MAX_VALUE;
		while (p > 0) {
			int mod = p % 10;
			p = p / 10;
			res = res * 10 + mod;

			if (res != 0 && max / res < 10 && max / res > -10)
				return 0;
		}

		if (flag) {
			res = 0 - res;
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println("1534236469 " + Integer.MAX_VALUE);

		ReverseInteger reverseInteger = new ReverseInteger();
		System.out.println(reverseInteger.reverse(15342364));
		System.out.println(reverseInteger.reverse(1534236469));
		System.out.println(reverseInteger.reverse(153423641));
		System.out.println(reverseInteger.reverse(-2147483412));
	}

}
