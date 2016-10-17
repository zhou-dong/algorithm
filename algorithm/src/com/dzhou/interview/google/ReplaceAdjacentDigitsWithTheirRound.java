package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个 int，范围是从10到100000000（减少了很多corner case的考虑）。
 * 
 * 要做的是选两个相邻的数，把这两个数换成它们平均值的round（四舍五入）使得到的新的int 的值最大。
 * 
 * 要注意的是 Math.round 输入是double 输出是long.
 * 
 * @author zhoudong
 *
 */
public class ReplaceAdjacentDigitsWithTheirRound {

	public int Solution(int x) {
		int min = x;
		List<Integer> digits = convertIntegerToList(x);
		for (int i = 1; i < digits.size(); i++) {
			int[] temp = { digits.get(i - 1), digits.get(i) };
			int round = (temp[0] + temp[1]) / 2;
			replace(digits, i, round);
			min = Math.min(min, convertListToInteger(digits));
			recovery(digits, i, temp);
		}
		return min;
	}

	private void replace(List<Integer> digits, int index, int round) {
		digits.set(index - 1, -1);
		digits.set(index, round);
	}

	private void recovery(List<Integer> digits, int index, int[] values) {
		digits.set(index - 1, values[0]);
		digits.set(index, values[1]);
	}

	private int convertListToInteger(List<Integer> list) {
		int result = 0;
		for (int digit : list) {
			if (digit != -1) {
				result = result * 10 + digit;
			}
		}
		return result;
	}

	private List<Integer> convertIntegerToList(int x) {
		List<Integer> result = new ArrayList<>();
		while (x > 0) {
			result.add(0, x % 10);
			x /= 10;
		}
		return result;
	}

}
