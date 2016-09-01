package org.dzhou.practice.hard;

/**
 * 65. Valid Number
 * 
 * @author zhoudong
 *
 */
public class ValidNumber {

	// regular expression
	public class Solution {

		public boolean isNumber(String s) {
			String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
			return s.trim().isEmpty() ? false : s.trim().matches(regex);
		}
	}

}
