package org.dzhou.interview.sort;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class MissingInt {

	long numberOfInts = (long) Integer.MAX_VALUE + 1;
	byte[] bitfield = new byte[(int) (numberOfInts / 8)];

	public int findOpenNumber(String filename) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(filename));
		while (in.hasNext()) {
			int n = in.nextInt();
			bitfield[n / 8] |= 1 << (n % 8);
		}
		in.close();
		for (int i = 0; i < bitfield.length; i++) {
			for (int j = 0; j < 8; j++) {
				if ((bitfield[i] & (1 << j)) == 0) {
					return i * 8 + j;
				}
			}
		}
		return -1;
	}

}
