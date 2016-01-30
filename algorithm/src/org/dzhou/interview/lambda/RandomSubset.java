package org.dzhou.interview.lambda;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class RandomSubset {

	public List<Integer> getRandomSubset(List<Integer> list) {
		List<Integer> result = new LinkedList<>();
		Random random = new Random();
		for (int item : list)
			if (random.nextBoolean())
				result.add(item);
		return result;
	}

	public List<Integer> getRandomSubsetLambda(List<Integer> list) {
		Random random = new Random();
		return list.stream().filter(k -> {
			return random.nextBoolean();
		}).collect(Collectors.toList());
	}

	public List<Integer> getRandomSubsetLambda2(List<Integer> list) {
		Random random = new Random();
		Predicate<Object> flipCoin = o -> {
			return random.nextBoolean();
		};
		return list.stream().filter(flipCoin).collect(Collectors.toList());
	}

}
