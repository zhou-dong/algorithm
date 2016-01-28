package org.dzhou.interview.bitmanipulation;

/**
 * Practice of "cracking the code interview"
 * 
 * Given a positive integer, print the next smallest and next largest number
 * that have the same number of 1 bits in their binary representation.
 * 
 * @author DONG ZHOU
 *
 */
public class NextNumber {

	public int getNext(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;
		// compute c0 and c1
		while (c != 0) {
			if ((c & 1) == 1)
				c1++;
			else
				c0++;
			c >>= 1;
		}
		if (c0 + c1 == 31 || c0 + c1 == 0)
			return -1;
		int p = c0 + c1; // position of rightmost non-trailing zero
		n |= (1 << p);
		n &= ~((1 << p) - 1);
		n |= (1 << (c1 - 1)) - 1;
		return n;
	}

	public int getPrev(int n) {
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		while (temp != 0) {
			if ((temp & 1) == 1)
				c1++;
			else
				c0++;
			temp >>= 1;
		}
		int p = c0 + c1;
		n &= ((~0) << (p + 1));
		int mask = (1 << (c1 + 1)) - 1;
		n |= mask << (c0 - 1);
		return n;
	}

	public static void main(String[] args) {
		NextNumber number2 = new NextNumber();
		System.out.println(Integer.toBinaryString(13948));
		number2.getPrev(13948);
	}

	public void print(int n) {
		System.out.println(Integer.toBinaryString(n));
	}

}
