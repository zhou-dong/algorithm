package org.dzhou.interview.moderate;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class Swap {

	// 0-------b--------------------a
	// 0-------b----|difference|----a
	public static void swap(int a, int b) {
		System.out.println(a + " " + b);
		// example a=9, b=4
		a = a - b; // difference: a = 9-4= 5
		b = b + a; // b = 5+4 = 9
		a = b - a; // a = 9-5 = 4
		System.out.println(a + " " + b);
	}

	public static void swap(int[] array, int a, int b) {
		array[a] = array[a] - array[b]; // a == difference
		array[b] = array[b] + array[a]; // update b = b + a (difference) ;
		array[a] = array[b] - array[a]; // update a = b - a (difference) ;
	}

	/*
	 * 异或
	 * 
	 * 异或是一种基于二进制的位运算，用符号XOR或者^表示，
	 * 
	 * 其运算法则是对运算符两侧数的每一个二进制位，同值取0，异值取1。
	 * 
	 * 它与布尔运算的区别在于， 当运算符两侧均为1时，布尔运算的结果为1， 异或运算的结果为0。
	 * 
	 * 简单理解就是不进位加法，如1+1=0，,0+0=0,1+0=1。
	 * 
	 * 
	 * 性质
	 * 
	 * 1. 交换律
	 * 
	 * 2. 结合律
	 * 
	 * 3. 对于任何数x，都有x^x=0，x^0=x
	 * 
	 * 4. 自反性 A XOR B XOR B = A XOR 0 = A
	 */
	public static void swap_opt(int a, int b) {
		System.out.println(a + " " + b);
		// example a=101, b = 110
		a = a ^ b; // a = 101^110 = 011
		b = a ^ b; // b = 011^110 = 101 (a^b^b) = (a^0) = a
		a = a ^ b; // a = 011^101 = 110 (a^b^a) = (b^0) = b
		System.out.println(a + " " + b);
	}

	public static void swap_opt(int[] array, int a, int b) {
		array[a] = array[a] ^ array[b]; // a = 101^110 = 011
		array[b] = array[a] ^ array[b]; // b = 011^110 = 101 (a^b^b) = (a^0) = a
		array[a] = array[a] ^ array[b]; // a = 011^101 = 110 (a^b^a) = (b^0) = b
	}

}
