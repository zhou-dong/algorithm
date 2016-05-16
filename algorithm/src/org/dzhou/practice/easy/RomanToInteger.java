package org.dzhou.practice.easy;

/**
 * Given a Roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author zhoudong
 *
 *         计数规则：<br>
 *         1. 相同的数字连写，所表示的数等于这些数字相加得到的数，例如：III = 3<br>
 *         2. 小的数字在大的数字右边，所表示的数等于这些数字相加得到的数，例如：VIII = 8<br>
 *         3. 小的数字，限于（I、X和C）在大的数字左边，所表示的数等于大数减去小数所得的数，例如：IV = 4<br>
 *         4. 正常使用时，连续的数字重复不得超过三次<br>
 *         5. 在一个数的上面画横线，表示这个数扩大1000倍（本题只考虑3999以内的数，所以用不到这条规则<br>
 * 
 *         解题方法：<br>
 *         从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。反之，减去前一个数的两倍然后加上该数
 * 
 */
public class RomanToInteger {

	public static int charToInt(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}

	public int romanToInt(String s) {
		int result = charToInt(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			int pre = charToInt(s.charAt(i - 1));
			int cur = charToInt(s.charAt(i));
			if (pre < cur)
				result -= 2 * pre;
			result += cur;
		}
		return result;
	}

}
