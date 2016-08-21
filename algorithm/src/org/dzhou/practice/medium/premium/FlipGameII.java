package org.dzhou.practice.medium.premium;

/**
 * You are playing the following Flip Game with your friend: Given a string that
 * contains only these two characters: + and -, you and your friend take turns
 * to flip two consecutive "++" into "--". The game ends when a person can no
 * longer make a move and therefore the other person will be the winner.
 * 
 * Write a function to determine if the starting player can guarantee a win.
 * 
 * For example, given s = "++++", return true. The starting player can guarantee
 * a win by flipping the middle "++" to become "+--+".
 * 
 * @author zhoudong
 *
 */
public class FlipGameII {

	public class Solution {
		public boolean canWin(String s) {
			for (int i = 0; i < s.length() - 1; i++) {
				if (s.startsWith("++", i)) {
					if (!canWin(s.substring(0, i) + "--" + s.substring(i + 2))) {
						return true;
					}
				}
			}
			return false;
		}
	}

	public class Solution1 {
		public boolean canWin(String s) {
			for (int i = 0; i < s.length() - 1; ++i) {
				if (s.charAt(i) == '+' && s.charAt(i + 1) == '+'
						&& !canWin(s.substring(0, i) + "--" + s.substring(i + 2))) {
					return true;
				}
			}
			return false;
		}
	}
}
