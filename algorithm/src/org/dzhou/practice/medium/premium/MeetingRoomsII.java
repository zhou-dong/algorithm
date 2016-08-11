package org.dzhou.practice.medium.premium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 * 
 * @author zhoudong
 *
 */
public class MeetingRoomsII {

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

		public int minMeetingRooms(Interval[] intervals) {

			if (intervals == null || intervals.length == 0)
				return 0;

			Arrays.sort(intervals, new Comparator<Interval>() {
				@Override
				public int compare(Interval o1, Interval o2) {
					return o1.start - o2.start;
				}
			});

			int rooms = 1;
			PriorityQueue<Integer> heap = new PriorityQueue<>();
			heap.offer(intervals[0].end);

			for (int i = 1; i < intervals.length; i++) {
				Interval meeting = intervals[i];
				if (meeting.start < heap.peek()) {
					rooms++;
				} else {
					heap.poll();
				}
				heap.offer(meeting.end);
			}

			return rooms;
		}

	}

}
