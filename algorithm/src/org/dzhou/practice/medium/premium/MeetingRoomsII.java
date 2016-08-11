package org.dzhou.practice.medium.premium;

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

	// [0, 7] [5, 8], [6, 9]
	public class Solution {

		public int minMeetingRooms(Interval[] intervals) {

			return 0;
		}

	}

}
