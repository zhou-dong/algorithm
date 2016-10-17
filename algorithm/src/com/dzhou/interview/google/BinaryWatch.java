package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. Binary Watch
 * 
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and
 * the 6 LEDs on the bottom represent the minutes (0-59).
 * 
 * Each LED represents a zero or one, with the least significant bit on the
 * right.
 * 
 * Given a non-negative integer n which represents the number of LEDs that are
 * currently on, return all possible times the watch could represent.
 * 
 * Note:
 * 
 * The order of output does not matter.
 * 
 * The hour must not contain a leading zero, for example "01:00" is not valid,
 * it should be "1:00".
 * 
 * The minute must be consist of two digits and may contain a leading zero, for
 * example "10:2" is not valid, it should be "10:02".
 * 
 * @author zhoudong
 *
 */
public class BinaryWatch {

	public List<String> readBinaryWatch(int num) {
		List<String> result = new ArrayList<>();
		helper(result, num, new int[10], 0, 0);
		return result;
	}

	private void helper(List<String> result, int num, int[] timecode, int index, int count) {
		if (count == num) {
			String time = decodeToTime(timecode);
			if (time != null)
				result.add(time);
			return;
		}
		for (int i = index; i < timecode.length; i++) {
			timecode[i] = 1;
			helper(result, num, timecode, i + 1, count + 1);
			timecode[i] = 0;
		}
	}

	private String decodeToTime(int[] timecode) {
		int hours = 0;
		for (int i = 0; i < 4; i++) {
			if (timecode[i] == 1) {
				hours += Math.pow(2, i);
			}
		}
		int minutes = 0;
		for (int i = 4; i < 10; i++) {
			if (timecode[i] == 1) {
				minutes += Math.pow(2, i - 4);
			}
		}
		return timeToString(hours, minutes);
	}

	private String timeToString(int hours, int minutes) {
		if (hours >= 12 || minutes >= 60)
			return null;
		StringBuilder sb = new StringBuilder();
		sb.append(hours);
		sb.append(":");
		if (minutes < 10)
			sb.append("0");
		sb.append(minutes);
		return sb.toString();
	}

}
