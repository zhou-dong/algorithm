package org.dzhou.practice.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 * 
 * @author zhoudong
 *
 */
public class LargestNumber {

	public class Solution {

		public String largestNumber(int[] nums) {
			if (nums == null || nums.length == 0)
				return "";

			// 把数组转化为字符串数组
			String[] strs = new String[nums.length];
			for (int i = 0; i < nums.length; i++)
				strs[i] = Integer.toString(nums[i]);

			// sort by: (s2 + s1).compareTo(s1 + s2);
			Arrays.sort(strs, new NumbersComparator());

			// add result
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < strs.length; i++)
				sb.append(strs[i]);

			// 去掉数字开头的0，如输入[0, 0]
			while (sb.length() > 0 && sb.charAt(0) == '0')
				sb.deleteCharAt(0);
			return 0 == sb.length() ? "0" : sb.toString();
		}

		// key idea
		class NumbersComparator implements Comparator<String> {
			@Override
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		}

	}

}
