package com.dzhou.interview.google.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindRightIntervalTest {

	// Definition for an interval.
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	class Node implements Comparable<Node> {
		int start;
		int index;

		Node(int start, int index) {
			this.start = start;
			this.index = index;
		}

		@Override
		public int compareTo(Node o) {
			return this.start - o.start;
		}
	}

	public int[] findRightInterval(Interval[] intervals) {
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			list.add(new Node(intervals[i].start, i));
		}
		Collections.sort(list);

		int[] result = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			result[i] = findRightIndex(list, intervals[i].end);
		}
		return result;
	}

	private int findRightIndex(List<Node> list, int target) {
		if (target > list.get(list.size() - 1).start)
			return -1;
		int left = 0, right = list.size() - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			int value = list.get(mid).start;
			if (value == target) {
				return list.get(mid).index;
			} else if (value > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		Node node = list.get(left);
		if (node.start == target) {
			return node.index;
		}
		if (node.start < target) {
			return node.index + 1;
		} else {
			return node.index;
		}
	}

	FindRightIntervalTest instance = null;

	@Before
	public void init() {
		instance = new FindRightIntervalTest();
	}

	@Test
	public void test() {
		// [[3,4],[2,3],[1,2]]
		Interval[] intervals = new Interval[3];
		Interval f = new Interval(3, 4);
		Interval s = new Interval(2, 3);
		Interval t = new Interval(1, 2);
		intervals[0] = f;
		intervals[1] = s;
		intervals[2] = t;
		Assert.assertArrayEquals(new int[] { -1, 0, 1 }, instance.findRightInterval(intervals));
	}

}
