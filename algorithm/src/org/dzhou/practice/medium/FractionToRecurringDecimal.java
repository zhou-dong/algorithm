package org.dzhou.practice.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5".<br>
 * Given numerator = 2, denominator = 1, return "2".<br>
 * Given numerator = 2, denominator = 3, return "0.(6)".<br>
 * Hint:
 * 
 * No scary math, just apply elementary math knowledge. Still remember how to
 * perform a long division?<br>
 * Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do
 * you see a pattern?<br>
 * Be wary of edge cases! List out as many test cases as you can think of and
 * test your code thoroughly.<br>
 * 
 * @author zhoudong
 * 
 *         reference: http://blog.csdn.net/u012162613/article/details/41998617
 * 
 *         题意：<br>
 *         给定两个整型数，一个代表分子numerator，一个代表分母denominator，以小数的形式返回它们的结果result，
 *         当有循环小数时，以括号形式表示。比如5/3=1.666666...以“1.(6)”的形式返回，返回的类型是字符串。
 * 
 *         解题要点：<br>
 *         1、负数的处理<br>
 *         2、INT_MIN的处理，将INT_MIN转化为正数会溢出，因此要使用long long int来计算。<br>
 *         3、分为整数部分和小数部分，重点在于小数部分的处理，因为小数部分有可能会出现循环。观察下面的除法：<br>
 *
 */
public class FractionToRecurringDecimal {

	public class Solution {

		public String fractionToDecimal(int numerator, int denominator) {

			if (numerator == 0)
				return "0";

			StringBuilder sb = new StringBuilder();

			if ((numerator >> 31 ^ denominator >> 31) == -1)
				sb.append("-");

			long n = Math.abs((long) numerator);
			long d = Math.abs((long) denominator);

			// 整数部分
			sb.append(n / d);

			// 余数部分
			long r = n % d;
			if (r == 0)
				return sb.toString();

			sb.append(".");

			Map<Long, Integer> map = new HashMap<Long, Integer>();
			int pos = 0;
			map.put(r, pos);
			StringBuilder frac = new StringBuilder();
			// 计算小数部分
			while (r != 0) {
				// 先把算出的小数加上，再判断余数是否重复，如果余数重复的话，小数会从下一个开始重复
				r *= 10;
				frac.append(r / d);
				r %= d;
				// 如果该余数之前出现过，说明有循环，上次出现的位置到当前位置就是循环的部分
				if (map.containsKey(r)) {
					// 将非循环部分和循环部分分开
					String pre = frac.substring(0, map.get(r));
					String loop = frac.substring(map.get(r));
					// 返回有循环的结果
					return sb.append(pre).append("(").append(loop).append(")").toString();
				}
				pos++;
				map.put(r, pos);// 记录下当前余数和他对应小数的位置
			}
			return sb.append(frac).toString();// 返回无循环有小数的结果
		}

	}

}
