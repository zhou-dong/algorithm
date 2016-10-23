package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 56. Merge Intervals
 * 
 * Difficulty: Hard
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * @author zhoudong
 *
 */
public class MergeIntervals {

	// Definition for an interval.
	public static class Interval {
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

		@Override
		public String toString() {
			return "[" + start + ", " + end + "]";
		}
	}

	public static class Solution {

		public List<Interval> merge(List<Interval> intervals) {
			if (intervals == null)
				return Collections.emptyList();
			List<Interval> result = new LinkedList<>();
			Collections.sort(intervals, new IntervalComparator());
			merge(intervals, result);
			return result;
		}

		private void merge(List<Interval> intervals, List<Interval> result) {
			Interval current = null;
			for (int i = 0; i < intervals.size(); i++) {
				if (current == null) {
					current = intervals.get(i);
				}
				if (isLast(intervals, i) || noOverlap(current, intervals.get(i + 1))) {
					result.add(current);
					current = null;
				} else {
					current = merge(current, intervals.get(i + 1));
				}
			}
		}

		private boolean noOverlap(Interval current, Interval next) {
			return current.end < next.start;
		}

		private boolean isLast(List<Interval> intervals, int index) {
			return index == intervals.size() - 1;
		}

		private Interval merge(Interval current, Interval next) {
			// int min = Math.min(current.start, next.start);
			int max = Math.max(current.end, next.end);
			return new Interval(current.start, max);
		}

		public class IntervalComparator implements Comparator<Interval> {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		}

	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(1, 4));
		System.out.println(new Solution().merge(intervals));
	}
}
