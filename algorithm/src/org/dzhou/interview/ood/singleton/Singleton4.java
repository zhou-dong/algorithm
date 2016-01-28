package org.dzhou.interview.ood.singleton;

import java.util.HashMap;
import java.util.Map;

public enum Singleton4 {

	FIRST("first", 0), SECOND("second", 1), THIRD("third", 2);

	int value;
	String name;

	private Singleton4(String name, int value) {
		this.value = value;
		this.name = name;
		map.put(value, this);
	}

	Map<Integer, Singleton4> map = new HashMap<>();

	public Singleton4 getByValue(int value) {
		return map.get(value);
	}

	public static void printAll() {
		StringBuffer result = new StringBuffer();
		for (Singleton4 instance : Singleton4.values()) {
			result.append(instance.getName()).append(" ");
			result.append(instance.getValue());
			result.append(System.getProperty("line.separator"));
		}
		System.out.println(result.toString());
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		Singleton4.printAll();
	}

}
