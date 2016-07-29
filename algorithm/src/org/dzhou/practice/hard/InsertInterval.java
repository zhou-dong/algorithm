package org.dzhou.practice.hard;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2:
 * 
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as
 * [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author zhoudong
 *
 */
public class InsertInterval {

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

	public class Solution {
		public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
			int index = findPosition(intervals, newInterval);
			intervals.add(index, newInterval);
			return merge(intervals);
		}

		private int findPosition(List<Interval> intervals, Interval newInterval) {
			int index = 0;
			for (Interval node : intervals) {
				if (node.start >= newInterval.start) {
					break;
				}
				index++;
			}
			return index;
		}

		private List<Interval> merge(List<Interval> intervals) {
			Interval current = null;
			List<Interval> result = new LinkedList<>();
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
			return result;
		}

		private boolean noOverlap(Interval current, Interval next) {
			return current.end < next.start;
		}

		private boolean isLast(List<Interval> intervals, int index) {
			return index == intervals.size() - 1;
		}

		private Interval merge(Interval current, Interval next) {
			int min = Math.min(current.start, next.start);
			int max = Math.max(current.end, next.end);
			return new Interval(min, max);
		}
	}
}
