package com.dzhou.interview.third;

import java.util.HashMap;
import java.util.Map;

public class S {

	public int solution(int[] A) {
		// write your code in Java SE 8

		Map<Integer, Integer> counts = new HashMap<>();
		for (int num : A) {
			counts.put(num, counts.getOrDefault(num, 0) + 1);
		}

		int result = 0;
		for (int num : counts.keySet()) {
			double value = Math.pow(2, num) * counts.get(num);
			if (num % 2 != 0) {
				value *= -1;
			}
			result += value;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] A = { 5, 4, 7 };
		System.out.println(new S().solution(A));
	}
}
