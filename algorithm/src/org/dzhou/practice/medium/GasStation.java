package org.dzhou.practice.medium;

/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * @author zhoudong
 * 
 */
public class GasStation {

	public class Solution {

		public int canCompleteCircuit(int[] gas, int[] cost) {

			int sum = 0, total = 0, j = -1;

			for (int i = 0; i < gas.length; i++) {
				sum += gas[i] - cost[i];
				total += gas[i] - cost[i];
				if (sum < 0) {
					j = i;
					sum = 0;
				}
			}

			return (total < 0) ? -1 : j + 1;
		}

	}

	public class Solution1 {
		public int canCompleteCircuit(int[] gas, int[] cost) {

			// gas减去cost，得到净油值
			for (int i = 0; i < cost.length; i++)
				gas[i] -= cost[i];

			if (gas.length == 1 && gas[0] == 0)
				return 0;

			int tank = 0;
			for (int i = 0; i < gas.length; i++) {
				if (gas[i] <= 0)
					continue;
				for (int j = i; j < i + gas.length; j++) {
					tank += gas[j % gas.length];
					if (tank < 0) {
						tank = 0;
						break;
					}
					if (j == i + gas.length - 1)
						return i;
				}
			}
			return -1;
		}
	}

}
