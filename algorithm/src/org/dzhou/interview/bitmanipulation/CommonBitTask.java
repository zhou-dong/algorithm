package org.dzhou.interview.bitmanipulation;

public class CommonBitTask {

	int repeatedArithmeticShift(int x, int count) {
		for (int i = 0; i < count; i++) {
			x >>= 1;
		}
		return x;
	}

	int repeatedLogicalShift(int x, int count) {
		for (int i = 0; i < count; i++) {
			x >>>= 1;
		}
		return x;
	}

}
