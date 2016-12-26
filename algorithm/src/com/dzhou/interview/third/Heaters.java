package com.dzhou.interview.third;

import java.util.Arrays;

/**
 * 475. Heaters
 * 
 * Winter is coming! Your first job during the contest is to design a standard
 * heater with fixed warm radius to warm all the houses.
 * 
 * Now, you are given positions of houses and heaters on a horizontal line, find
 * out minimum radius of heaters so that all houses could be covered by those
 * heaters.
 * 
 * So, your input will be the positions of houses and heaters seperately, and
 * your expected output will be the minimum radius standard of heaters.
 * 
 * Note:
 * 
 * Numbers of houses and heaters you are given are non-negative and will not
 * exceed 25000.
 * 
 * Positions of houses and heaters you are given are non-negative and will not
 * exceed 10^9.
 * 
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * 
 * All the heaters follow your radius standard and the warm radius will the
 * same.
 * 
 * Example 1: Input: [1,2,3],[2] Output: 1
 * 
 * Explanation: The only heater was placed in the position 2, and if we use the
 * radius 1 standard, then all the houses can be warmed.
 * 
 * Example 2: Input: [1,2,3,4],[1,4] Output: 1
 * 
 * Explanation: The two heater was placed in the position 1 and 4. We need to
 * use radius 1 standard, then all the houses can be warmed.
 * 
 * @author zhoudong
 *
 */
public class Heaters {

	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int result = 0;
		for (int house : houses) {
			int nearestIndex = nearest(heaters, house);
			result = Math.max(result, min(heaters, house, nearestIndex));
		}
		return result;
	}

	private int nearest(int[] heaters, int house) {
		if (house <= heaters[0])
			return 0;
		if (house >= heaters[heaters.length - 1])
			return heaters.length - 1;
		int left = 0, right = heaters.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (heaters[mid] == house) {
				return mid;
			} else if (heaters[mid] < house) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	private int min(int[] heaters, int house, int index) {
		int len = heaters.length;
		int left = (index == 0) ? heaters[index] - house : heaters[index - 1] - house;
		int mid = heaters[index] - house;
		int right = (index == len - 1) ? heaters[index] - house : heaters[index + 1] - house;
		left = Math.abs(left);
		mid = Math.abs(mid);
		right = Math.abs(right);
		return Math.min(mid, Math.min(left, right));
	}

}
