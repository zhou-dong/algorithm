package org.dzhou.practice.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Related to question Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:<br>
 * 
 * A -> 1 <br>
 * B -> 2 <br>
 * C -> 3 <br>
 * ... <br>
 * Z -> 26 <br>
 * AA -> 27 <br>
 * AB -> 28 <br>
 * 
 * @author zhoudong
 * 
 *         实现26进制
 */
public class ExcelSheetColumnNumber {

	class Solution {
		public int titleToNumber(String s) {
			if (s == null)
				return 0;
			int rst = 0;
			for (int i = 0; i < s.length(); ++i)
				rst = rst * 26 + s.charAt(i) - 'A' + 1;
			return rst;
		}
	}

	class Solution1 {
		public int titleToNumber(String s) {
			if (s == null || s.length() == 0)
				return 0;
			int result = 0;
			Map<Character, Integer> vocabulary = createVocabulary();
			for (int i = 0; i < s.length(); i++) {
				int val = vocabulary.get(s.charAt(s.length() - 1 - i));
				result += (val * Math.pow(26, i));
			}
			return result;
		}

		private Map<Character, Integer> createVocabulary() {
			char[] chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
					'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
			Map<Character, Integer> vocabulary = new HashMap<>();
			for (int i = 0; i < chars.length; i++)
				vocabulary.put(chars[i], i + 1);
			return vocabulary;
		}
	}

}