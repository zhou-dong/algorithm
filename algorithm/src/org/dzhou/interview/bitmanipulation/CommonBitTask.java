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

}
