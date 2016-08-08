package org.dzhou.practice.hard;

/**
 * Convert a non-negative integer to its English words representation. Given
 * input is guaranteed to be less than 2^31 - 1.
 * 
 * For example,
 * 
 * 123 -> "One Hundred Twenty Three"
 * 
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 
 * 1234567 ->
 * "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 * Hint:
 * 
 * 1. Did you see a pattern in dividing the number into chunk of words? For
 * example, 123 and 123000.
 * 
 * 2. Group the number by thousands (3 digits). You can write a helper function
 * that takes a number less than 1000 and convert just that chunk to words.
 * 
 * 3. There are many edge cases. What are some good test cases? Does your code
 * work with input such as 0? Or 1000010? (middle chunk is zero and should not
 * be printed out)
 * 
 * @author zhoudong
 *
 */
public class IntegerToEnglishWords {

	public class Solution {

		String[] units = { "", " Thousand", " Million", " Billion" };
		String[] ten = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
		String[] hundred = { "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] twenty = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
				"Eighteen", "Nineteen" };

		public String numberToWords(int num) {
			String result = "";
			int count = 0;
			while (num > 0) {
				if (num % 1000 > 0) {
					result = chunk(num % 1000) + units[count] + " " + result;
				}
				num /= 1000;
				count++;
			}
			return result.length() == 0 ? "Zero" : result.substring(0, result.length() - 1);
		}

		private String chunk(int num) {
			if (num <= 0)
				return "";
			StringBuilder sb = new StringBuilder();
			// hundreds
			if (num > 99) {
				sb.append(ten[num / 100]).append(" Hundred ");
			}
			// tens
			num %= 100;
			if (num >= 10 && num < 20) {
				return sb.append(twenty[num % 10]).toString();
			} else if (num >= 20) {
				sb.append(hundred[(num / 10) - 1]).append(" ");
			}
			// number
			num %= 10;
			if (num == 0) {
				return sb.deleteCharAt(sb.length() - 1).toString();
			} else {
				return sb.append(ten[num]).toString();
			}
		}

	}

}
