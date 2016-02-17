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

}
