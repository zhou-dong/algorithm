package org.dzhou.again.regularexpressionmatching;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.<br>
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:<br>
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:<br>
 * isMatch("aa","a") → false<br>
 * isMatch("aa","aa") → true<br>
 * isMatch("aaa","aa") → false<br>
 * isMatch("aa", "a*") → true<br>
 * isMatch("aa", ".*") → true<br>
 * isMatch("ab", ".*") → true<br>
 * isMatch("aab", "c*a*b") → true
 * 
 * references:
 * 
 * http://articles.leetcode.com/regular-expression-matching
 * 
 * http://harrifeng.github.io/algo/leetcode/regular-expression-matching.html
 * 
 * @author zhoudong
 * 
 *         "匹配"这个问题,非常容易转换成"匹配了一部分",整个匹配不匹配,要看"剩下的匹配"情况.<br>
 *         这就很好的把一个大的问题转换成了规模较小的问题:递归
 */
public class RegularExpressionMatching {

	// recursive solution
	public class Solution {

		public boolean isMatch(String s, String p) {

			// recursive return condition
			if (p.length() == 0)
				return s.length() == 0;
			if (p.length() == 1)
				return s.length() == 1 && isMatch(s, p, 0);

			if (p.charAt(1) != '*') // normal compare
				return s.length() > 0 && isMatch(s, p, 0) && isMatch(s.substring(1), p.substring(1));

			// next char is *
			while (s.length() > 0 && isMatch(s, p, 0)) {
				if (isMatch(s, p.substring(2)))
					return true;
				s = s.substring(1);
			}
			return isMatch(s, p.substring(2));
		}

		private boolean isMatch(String s, String p, int index) {
			return p.charAt(index) == '.' || p.charAt(index) == s.charAt(index);
		}

	}

}
