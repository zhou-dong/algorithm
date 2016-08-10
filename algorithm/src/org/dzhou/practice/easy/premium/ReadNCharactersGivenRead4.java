package org.dzhou.practice.easy.premium;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 * 
 * Note: The read function will only be called once for each test case.
 * 
 * @author zhoudong
 *
 *         这道题关键是读懂题！而且感觉这道题是为了检验c++出的，真的想不出来，用Java实现这种题有什么意义！
 * 
 *         用Java这么实现，简直丑爆了！~_~ :)
 */
public class ReadNCharactersGivenRead4 {

	abstract class Reader4 {
		int read4(char[] buf) {
			return 0;
		}

		abstract int read(char[] buf, int n);
	}

	// The read4 API is defined in the parent class Reader4.
	// int read4(char[] buf);
	public class Solution extends Reader4 {
		/**
		 * @param buf
		 *            Destination buffer
		 * @param n
		 *            Maximum number of characters to read
		 * @return The number of characters read
		 */
		@Override
		public int read(char[] buf, int n) {
			int index = 0;
			while (index < n) {
				char[] temp = new char[4];
				int k = read4(temp);
				for (int i = 0; i < k && index < n; i++) {
					buf[index++] = temp[i];
				}
				if (k < 4) {
					return index;
				}
			}
			return index;
		}

	}
}
