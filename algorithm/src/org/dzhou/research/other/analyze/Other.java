package org.dzhou.research.other.analyze;

public class Other {

	int f(int n) {
		if (n <= 0) {
			return 1;
		}
		return f(n - 1) + f(n - 1) + f(n - 1);
	}

}
