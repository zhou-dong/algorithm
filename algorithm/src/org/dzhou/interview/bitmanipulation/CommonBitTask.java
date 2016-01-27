package org.dzhou.interview.bitmanipulation;

public class CommonBitTask {

	public int repeatedArithmeticShift(int x, int count) {
		for (int i = 0; i < count; i++) {
			x >>= 1;
		}
		return x;
	}

	public int repeatedLogicalShift(int x, int count) {
		for (int i = 0; i < count; i++) {
			x >>>= 1;
		}
		return x;
	}

	public boolean getBit(int num, int i) {
		int tmp = 1 << i; // shifts 1 over by i bits
		int result = num & tmp; // perform AND with num
		return result != 0;
	}

	public int setBit(int num, int i) {
		int tmp = 1 << i; // shifts 1 over by i bits
		return num | tmp;
	}

}
