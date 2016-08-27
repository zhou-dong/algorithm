package org.dzhou.practice.hard.premium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 158. Read N Characters Given Read4 II - Call multiple times
 * 
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 * 
 * Note: The read function may be called multiple times.
 * 
 * @author zhoudong
 *
 */
public class ReadNCharactersGivenRead4II {

	class Reader4 {
		int read4(char[] buf) {
			return -1;
		}
	}

	/*
	 * The read4 API is defined in the parent class Reader4. int read4(char[]
	 * buf);
	 */

	public class Solution extends Reader4 {

		/**
		 * @param buf
		 *            Destination buffer
		 * @param n
		 *            Maximum number of characters to read
		 * @return The number of characters read
		 */
		public int read(char[] buf, int n) {
			if (n == 0)
				return 0;
			fillQueue(n);
			int size = Math.min(queue.size(), n);
			readFromQueue(buf, size);
			return size;
		}

		Queue<Character> queue = new LinkedList<Character>();

		private void fillQueue(int n) {
			while (queue.size() < n) {
				char[] temp = new char[4];
				int count = read4(temp);
				for (int i = 0; i < count; i++)
					queue.add(temp[i]);
				if (count < 4) {
					break;
				}
			}
		}

		private int readFromQueue(char[] buf, int size) {
			for (int i = 0; i < size; i++)
				buf[i] = queue.poll();
			return size;
		}

	}

}
