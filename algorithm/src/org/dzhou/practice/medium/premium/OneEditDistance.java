package org.dzhou.practice.medium.premium;

/**
 * Given two strings S and T, determine if they are both one edit distance
 * apart.
 * 
 * @author zhoudong
 *
 */
public class OneEditDistance {

	public class Solution {

		public boolean isOneEditDistance(String s, String t) {
			if (s == null || t == null)
				return false;
			if (s.length() == t.length())
				return isOneEditReplace(s, t);
			else if (s.length() + 1 == t.length())
				return isOneInsert(s, t);
			else if (s.length() - 1 == t.length())
				return isOneInsert(t, s);
			return false;
		}

		private boolean isOneInsert(String s1, String s2) {
			int index1 = 0, index2 = 0;
			while (index1 < s1.length() || index2 < s2.length()) {
				if (index1 == s1.length()) {
					index2++;
					continue;
				}
				if (index2 == s2.length()) {
					index1++;
					continue;
				}
				if (s1.charAt(index1) != s2.charAt(index2)) {
					if (index1 != index2)
						return false;
					index2++;
				} else {
					index1++;
					index2++;
				}
			}
			return index1 != index2;
		}

		private boolean isOneEditReplace(String s1, String s2) {
			boolean foundDifference = false;
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					if (foundDifference)
						return false;
					foundDifference = true;
				}
			}
			return foundDifference;
		}
	}

}
