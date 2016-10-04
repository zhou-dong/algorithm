package org.dzhou.practice.easy;

/**
 * 405. Convert a Number to Hexadecimal
 * 
 * Difficulty: Easy
 * 
 * Given an integer, write an algorithm to convert it to hexadecimal. For
 * negative integer, two’s complement method is used.
 * 
 * Note:
 * 
 * All letters in hexadecimal (a-f) must be in lowercase. The hexadecimal string
 * must not contain extra leading 0s. If the number is zero, it is represented
 * by a single zero character '0'; otherwise, the first character in the
 * hexadecimal string will not be the zero character. The given number is
 * guaranteed to fit within the range of a 32-bit signed integer. You must not
 * use any method provided by the library which converts/formats the number to
 * hex directly. Example 1:
 * 
 * Input: 26
 * 
 * Output: "1a" Example 2:
 * 
 * Input: -1
 * 
 * Output: "ffffffff"
 * 
 * @author zhoudong
 * 
 *         reference: http://blog.csdn.net/mebiuw/article/details/52664414
 *
 *         题目的主要意思是将一个数，按照16进制的方式输出。
 * 
 *         一般来说我们会想到那个通用的做法，不停取模求余数？其实对于2^n这样的进制根本没必要这么做，我们将输入数字的每4个bit作为一个单位，
 *         不就可以直接转化成16进制了么？
 */
public class ConvertANumberToHexadecimal {

	// 直接将num当做二进制的数字去处理，然后每4位映射一次就好,然后逻辑位移就好
	char[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public String toHex(int num) {
		if (num == 0)
			return "0";
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			sb.append(map[(num & 15)]);
			num = (num >>> 4);
		}
		return sb.reverse().toString();
	}
}
