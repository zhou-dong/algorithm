package org.dzhou.practice.medium.premium;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.
 * 
 * Example:
 * 
 * Given word = "word", return the following list (order does not matter):
 * 
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1",
 * "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 
 * @author zhoudong
 *
 *         http://www.cnblogs.com/grandyang/p/5261569.html
 * 
 *         0000 word <br>
 *         0001 wor1 <br>
 *         0010 wo1d <br>
 *         0011 wo2 <br>
 *         0100 w1rd <br>
 *         0101 w1r1 <br>
 *         0110 w2d <br>
 *         0111 w3 <br>
 *         1000 1ord <br>
 *         1001 1or1 <br>
 *         1010 1o1d <br>
 *         1011 1o2 <br>
 *         1100 2rd <br>
 *         1101 2r1 <br>
 *         1110 3d <br>
 *         1111 4 <br>
 */
public class GeneralizedAbbreviation {

	public class Solution1 {
		public List<String> generateAbbreviations(String word) {
			List<String> res = new ArrayList<String>();
			backtrack(res, word, 0, "", 0);
			return res;
		}

		private void backtrack(List<String> res, String word, int pos, String cur, int count) {
			if (pos == word.length()) {
				if (count > 0)
					cur += count;
				res.add(cur);
			} else {
				backtrack(res, word, pos + 1, cur, count + 1);
				backtrack(res, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
			}
		}
	}
}
