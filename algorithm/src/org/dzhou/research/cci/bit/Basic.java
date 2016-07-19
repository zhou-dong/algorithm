package org.dzhou.research.cci.bit;

public class Basic {

	enum Bit {
		ZERO, ONE;
	}

	public Bit getBit(int num, int i) {
		int mask = 1 << i;
		return (num & mask) == 0 ? Bit.ZERO : Bit.ONE;
	}

	public int setBit(int num, int i) {
		int mask = 1 << i;
		return num | mask;
	}

	public int clearBit(int num, int i) {
		int mask = ~(1 << i);
		return num & mask;
	}

	public int clearBitsMSBThroughI(int num, int i) {
		int mask = (1 << i) - 1;
		return num & mask;
	}

	public int clearBitsIthrough0(int num, int i) {
		int mask = ~(-1 >>> (31 - i));
		return num & mask;
	}

	public int updateBit(int num, int i, Bit bit) {
		return (bit == Bit.ZERO) ? clearBit(num, i) : setBit(num, i);
	}

	public boolean isOnlyOneBitIsOne(int num) {
		return (num & (num - 1)) == 0 ? true : false;
	}

	// 1. 先把第i位设置为0
	// 2. 再给第i位赋值
	public int updateBit(int num, int i, boolean isOne) {
		int mask = ~(1 << i);
		num &= mask; // 把第i位设置为0
		int value = isOne ? 1 : 0;
		value = (value << i);
		num |= value; // 给第i位赋值
		return num;
	}

}
