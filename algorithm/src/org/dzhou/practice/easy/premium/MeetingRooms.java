package org.dzhou.practice.easy.premium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
 * meetings.
 * 
 * For example,
 * 
 * Given [[0, 30],[5, 10],[15, 20]],
 * 
 * return false.
 * 
 * @author zhoudong
 *
 */
public class MeetingRooms {

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

		public boolean canAttendMeetings(Interval[] intervals) {

			Arrays.sort(intervals, new Comparator<Interval>() {
				@Override
				public int compare(Interval o1, Interval o2) {
					return o1.start - o2.start;
				}
			});

			for (int i = 1; i < intervals.length; i++) {
				if (intervals[i - 1].end > intervals[i].start)
					return false;
			}

			return true;
		}

	}

}
