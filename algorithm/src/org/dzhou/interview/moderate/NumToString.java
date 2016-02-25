package org.dzhou.interview.moderate;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         convert(19 323 984) =
 * 
 *         convert(19)+" million, "+convert(323)+ " thousand "+convert(984)
 */
public class NumToString {

	public static String digits[] = { "One", "Two", "Three", "Four", "Five", "Six", "Seven",
			"Eight", "Nine" };
	public static String teens[] = { "Eleven", "Twelve", "ThirTteen", "Fourteen", "Fifteen",
			"Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	public static String tens[] = { "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty",
			"Seventy", "Eighty", "Ninety" };
	public static String bigs[] = { "", "Thousand,", "Million," };

	public static String numToString(int number) {
		if (number == 0) {
			return "Zero";
		} else if (number < 0) {
			return "Negative " + numToString(-1 * number);
		}

		String result = "";
		int count = 0;

		while (number > 0) {
			if (number % 1000 != 0) {
				result = numToString100(number % 1000) + bigs[count] + " " + result;
			}
			number /= 1000;
			count++;
		}

		return result;

	}

	public static String numToString100(int number) {
		String result = "";
		// 转换百位数
		if (number >= 100) {
			result += digits[number / 100 - 1] + " Hundred ";
			number %= 100;
		}
		// 转换十位数
		if (number >= 11 && number <= 19) {
			return result + teens[number - 11] + " ";
		} else if (number == 10 || number >= 20) {
			result += tens[number / 10 - 1] + " ";
			number %= 10;
		}
		// 转换个位数
		if (number >= 1 && number <= 9) {
			result += digits[number - 1] + " ";
		}
		return result;
	}

}
