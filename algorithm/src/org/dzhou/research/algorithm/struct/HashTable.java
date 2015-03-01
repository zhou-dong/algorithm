package org.dzhou.research.algorithm.struct;

import java.util.Arrays;

/**
 * not finish
 *
 * It is an very simple hashTable, can not be used in production environment.
 *
 * Improvement: use list to store value
 * 
 * @author DONG ZHOU
 */
public class HashTable {

	private String[] array = null;
	private int size;

	public HashTable(int size) {
		this.size = size;
		array = new String[size];
		Arrays.fill(array, "-1");
	}

	public void insert(String input) {
		array[hashFunction(input)] = input;
	}

	public String get(String input) {
		return array[hashFunction(input)];
	}

	public void remove(String input) {
		array[hashFunction(input)] = "-1";
	}

	/*
	 * Good hash function:
	 * 
	 * 1.Make all the info provided by the key.
	 * 
	 * 2.Uniformly distributes output across table.
	 * 
	 * 3.Maps similar keys to very different hash values.
	 * 
	 * 4.Use only very fast operation.
	 */
	private int hashFunction(String input) {
		return strToInt(input);
	}

	public int strToInt(String input) {
		int i = 0;
		int num = 0;
		boolean isNeg = false;
		// Check for negative sign; if it's there, set the isNeg flag
		if (input.charAt(0) == '-') {
			isNeg = true;
			i = 1;
		}
		// Process each character of the string;
		while (i < input.length()) {
			num *= 10;
			// Minus the ASCII code of '0' to
			// get the value of the charAt(i++).
			num += input.charAt(i++) - '0';
		}
		if (isNeg)
			num = -num;
		while (num > size) {
			num /= 10;
		}
		return num;
	}

	public void display() {
		for (String val : array)
			if ("-1".equals(val) == false)
				System.out.print(val + " ");
	}

	public static void main(String args[]) {
		HashTable table = new HashTable(10000);
		table.insert("apple");
		table.insert("banana");
		table.insert("melon");
		table.display();
		System.out.println("");
		System.out.println("apple: " + table.get("apple"));
	}

}
