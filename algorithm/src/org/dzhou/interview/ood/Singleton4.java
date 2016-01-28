package org.dzhou.interview.ood;

public enum Singleton4 {

	FIRST("first", 0), SECOND("second", 1), THIRD("third", 2);

	int value;
	String name;

	private Singleton4(String name, int value) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

}
