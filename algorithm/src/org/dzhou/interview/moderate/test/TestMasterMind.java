package org.dzhou.interview.moderate.test;

import org.dzhou.interview.moderate.MasterMind;
import org.dzhou.interview.moderate.MasterMind.Color;
import org.dzhou.interview.moderate.MasterMind.Result;
import org.junit.Assert;
import org.junit.Test;

public class TestMasterMind {

	@Test
	public void test1() {
		// "RGBY","GGRR" 返回：[1,1]
		Color[] guess = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW };
		Color[] solution = { Color.GREEN, Color.GREEN, Color.RED, Color.RED };
		Result result = getResult(guess, solution);
		assertResult(1, 1, result);
	}

	private void assertResult(int hits, int pseudoHits, Result result) {
		Assert.assertEquals(hits, result.hits);
		Assert.assertEquals(pseudoHits, result.pseudoHits);
	}

	private Result getResult(Color[] guess, Color[] solution) {
		MasterMind masterMind = new MasterMind();
		return masterMind.estimate(guess, solution);
	}

}
