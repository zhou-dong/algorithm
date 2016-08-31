package org.dzhou.practice.hard;

import java.util.Arrays;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to
 * two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = "great":
 * 
 * To scramble the string, we may choose any non-leaf node and swap its two
 * children.
 * 
 * For example, if we choose the node "gr" and swap its two children, it
 * produces a scrambled string "rgeat".
 * 
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it
 * produces a scrambled string "rgtae".
 * 
 * We say that "rgtae" is a scrambled string of "great".
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a
 * scrambled string of s1.
 * 
 * @author zhoudong
 *
 *         这道题我没有思路，google以后发现有个博客写的特别好：
 * 
 *         reference: http://www.cnblogs.com/yuzhangcmu/p/4189152.html
 */

public class ScrambleString {

	/**
	 * 1. Brute Force 递归。<br>
	 * 基本的思想就是：在S1上找到一个切割点，左边长度为i, 右边长为len - i。 有2种情况表明它们是IsScramble <br>
	 * (1). S1的左边和S2的左边是IsScramble， S1的右边和S2的右边是IsScramble <br>
	 * (2). S1的左边和S2的右边是IsScramble， S1的右边和S2的左边是IsScramble （实际上是交换了S1的左右子树）<br>
	 * 而i的取值可以是1 ~ len-1。
	 */
	public class Solution1 {

		public boolean isScramble(String s1, String s2) {
			if (s1 == null || s2 == null) {
				return false;
			}
			if (s1.length() != s2.length()) {
				return false;
			}
			return rec(s1, s2);
		}

		// Solution 1: The recursion version.
		public boolean rec(String s1, String s2) {
			int len = s1.length();
			// the base case.
			if (len == 1) {
				return s1.equals(s2);
			}
			for (int i = 1; i < len; i++) {
				// we have two situation;
				// the left-left right-right
				if (rec(s1.substring(0, i), s2.substring(0, i)) && rec(s1.substring(i, len), s2.substring(i, len))) {
					return true;
				}
				// left-right right-left
				if (rec(s1.substring(0, i), s2.substring(len - i, len))
						&& rec(s1.substring(i, len), s2.substring(0, len - i))) {
					return true;
				}
			}
			return false;
		}

	}

	/**
	 * 2. 递归加剪枝
	 * 感谢unieagle的提示，我们可以在递归中加适当的剪枝，也就是说在进入递归前，先把2个字符串排序，再比较，如果不相同，则直接退出掉。
	 * 这样也能有效地减少复杂度，具体多少算不清。但能通过leetcode的检查。
	 */
	public class Solution2 {
		public boolean isScramble(String s1, String s2) {
			if (s1 == null || s2 == null) {
				return false;
			}
			if (s1.length() != s2.length()) {
				return false;
			}
			return rec(s1, s2);
		}

		// Solution 2: The recursion version with sorting.
		public boolean rec(String s1, String s2) {
			int len = s1.length();
			// the base case.
			if (len == 1) {
				return s1.equals(s2);
			}

			// sort to speed up.
			char[] s1ch = s1.toCharArray();
			Arrays.sort(s1ch);
			String s1Sort = new String(s1ch);
			char[] s2ch = s2.toCharArray();
			Arrays.sort(s2ch);
			String s2Sort = new String(s2ch);
			if (!s1Sort.equals(s2Sort)) {
				return false;
			}

			for (int i = 1; i < len; i++) {
				// we have two situation;
				// the left-left right-right & left-right right-left
				if (rec(s1.substring(0, i), s2.substring(0, i)) && rec(s1.substring(i, len), s2.substring(i, len))) {
					return true;
				}
				if (rec(s1.substring(0, i), s2.substring(len - i, len))
						&& rec(s1.substring(i, len), s2.substring(0, len - i))) {
					return true;
				}
			}

			return false;
		}
	}

	/**
	 * 3. 递归加Memory
	 * 
	 * 我们在递归中加上记忆矩阵，也可以减少重复运算，但是我们现在就改一下之前递归的结构以方便加上记忆矩阵，我们用index1记忆S1起始地址，
	 * index2记忆S2起始地址，len
	 * 表示字符串的长度。这样我们可以用一个三维数组来记录计算过的值，同样可以通过leetcode的检查。这个三维数组一个是N^3的复杂度，在每一个递归中
	 * ，要从1-len地计算一次所有的子串，所以一共的复杂度是N^4
	 */

	public class Solution3 {

		// Solution 3: The recursion version with memory.
		public boolean isScramble(String s1, String s2) {
			if (s1 == null || s2 == null) {
				return false;
			}
			int len1 = s1.length();
			int len2 = s2.length();
			// the two strings should be the same length.
			if (len1 != len2) {
				return false;
			}
			int[][][] mem = new int[len1][len1][len1];
			for (int i = 0; i < len1; i++) {
				for (int j = 0; j < len1; j++) {
					for (int k = 0; k < len1; k++) {
						// -1 means unseted.
						mem[i][j][k] = -1;
					}
				}
			}
			return recMem(s1, 0, s2, 0, len1, mem);
		}

		// Solution 3: The recursion version with memory.
		public boolean recMem(String s1, int index1, String s2, int index2, int len, int[][][] mem) {
			// the base case.
			if (len == 1) {
				return s1.charAt(index1) == s2.charAt(index2);
			}
			// LEN: 1 - totalLen-1
			int ret = mem[index1][index2][len - 1];
			if (ret != -1) {
				return ret == 1 ? true : false;
			}
			ret = 0;
			for (int i = 1; i < len; i++) {
				// we have two situation;
				// the left-left right-right & left-right right-left
				if (recMem(s1, index1, s2, index2, i, mem) && recMem(s1, index1 + i, s2, index2 + i, len - i, mem)) {
					ret = 1;
					break;
				}
				if (recMem(s1, index1, s2, index2 + len - i, i, mem)
						&& recMem(s1, index1 + i, s2, index2, len - i, mem)) {
					ret = 1;
					break;
				}
			}
			mem[index1][index2][len - 1] = ret;
			return ret == 1 ? true : false;
		}
	}

	public class Solution4 {

		public boolean isScramble(String s1, String s2) {
			if (s1 == null || s2 == null) {
				return false;
			}

			int len = s1.length();

			if (s2.length() != len) {
				return false;
			}

			boolean[][][] D = new boolean[len][len][len + 1];

			// D[i][j][k] = D[i][]
			for (int k = 1; k <= len; k++) {
				// 注意这里的边界选取。 如果选的不对，就会发生越界的情况.. orz..
				// attention: should use "<="
				for (int i = 0; i <= len - k; i++) {
					for (int j = 0; j <= len - k; j++) {
						if (k == 1) {
							D[i][j][k] = s1.charAt(i) == s2.charAt(j);
							continue;
						}

						D[i][j][k] = false;
						for (int l = 1; l <= k - 1; l++) {
							if (D[i][j][l] && D[i + l][j + l][k - l] || D[i][j + k - l][l] && D[i + l][j][k - l]) {
								D[i][j][k] = true;
								break;
							}
						}
					}
				}
			}

			return D[0][0][len];
		}
	}
}
