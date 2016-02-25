package org.dzhou.interview.moderate.test;

import org.dzhou.interview.moderate.NumToString;
import org.junit.Test;

public class TestNumToString {

	// convert(19 323 984) =
	// convert(19)+" million, "+convert(323)+ " thousand "+convert(984)
	@Test
	public void test() {
		String result = NumToString.numToString(19323984);
		System.out.println(result);
	}

}
