package org.dzhou.interview.ood.singleton;

public class Singleton2 {

	private Singleton2() {
	}

	private static volatile Singleton2 instance = null;

	public static Singleton2 getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton2();
				}
			}
		}
		return instance;
	}

}
