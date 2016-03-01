package org.dzhou.interview.hard.test;

import org.dzhou.interview.hard.Add;
import org.junit.Assert;
import org.junit.Test;

public class TestAdd {

	@Test
	public void test() {
		Assert.assertEquals(7, Add.add(5, 2));
		Assert.assertEquals(7, Add.add(2, 5));
		Assert.assertEquals(7, Add.add(0, 7));
		Assert.assertEquals(7, Add.add(7, 0));
	}

}
