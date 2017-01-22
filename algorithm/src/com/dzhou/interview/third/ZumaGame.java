package com.dzhou.interview.third;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 488. Zuma Game
 * 
 * Think about Zuma Game. You have a row of balls on the table, colored red(R),
 * yellow(Y), blue(B), green(G), and white(W). You also have several balls in
 * your hand.
 * 
 * Each time, you may choose a ball in your hand, and insert it into the row
 * (including the leftmost place and rightmost place). Then, if there is a group
 * of 3 or more balls in the same color touching, remove these balls. Keep doing
 * this until no more balls can be removed.
 * 
 * Find the minimal balls you have to insert to remove all the balls on the
 * table. If you cannot remove all the balls, output -1.
 * 
 * Examples:
 * 
 * Input: "WRRBBW", "RB" Output: -1 <br>
 * Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW
 * 
 * Input: "WWRRBBWW", "WRBRW" Output: 2 <br>
 * Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
 * 
 * Input:"G", "GGGGG" Output: 2 <br>
 * Explanation: G -> G[G] -> GG[G] -> empty
 * 
 * Input: "RBYYBBRRB", "YRBGB" Output: 3 <br>
 * Explanation: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] ->
 * BB[B] -> empty
 * 
 * Note:
 * 
 * You may assume that the initial row of balls on the table won’t have any 3 or
 * more consecutive balls with the same color.
 * 
 * The number of balls on the table won't exceed 20, and the string represents
 * these balls is called "board" in the input.
 * 
 * The number of balls in your hand won't exceed 5, and the string represents
 * these balls is called "hand" in the input.
 * 
 * Both input strings will be non-empty and only contain characters
 * 'R','Y','B','G','W'.
 * 
 * @author zhoudong
 *
 */
public class ZumaGame {

	public int findMinStep(String board, String hand) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : hand.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		return -1;
	}

	private boolean clean(List<Character> board) {

		return false;
	}
}
