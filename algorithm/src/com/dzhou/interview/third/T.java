package com.dzhou.interview.third;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class T {

	public int solution(String S) {
		// write your code in Java SE 8

		Map<String, PhoneNumber> calls = new HashMap<>();
		PriorityQueue<PhoneNumber> heap = new PriorityQueue<>();

		for (String log : S.split("\n")) {
			String[] entry = log.split(",");
			String phoneNumber = entry[1];
			int duration = calDuration(entry[0]);
			addToMap(calls, phoneNumber, duration);
		}

		for (PhoneNumber call : calls.values()) {
			heap.add(call);
		}

		heap.poll();
		int total = 0;

		while (!heap.isEmpty()) {
			PhoneNumber phone = heap.poll();
			for (int duration : phone.durations) {
				total += calPrice(duration);
			}
		}

		return total;
	}

	private void addToMap(Map<String, PhoneNumber> map, String key, int value) {
		PhoneNumber call = map.getOrDefault(key, new PhoneNumber(key));
		call.durations.add(value);
		call.totalDuration += value;
		map.put(key, call);
	}

	class PhoneNumber implements Comparable<PhoneNumber> {
		String number;
		int totalDuration;
		List<Integer> durations;

		PhoneNumber(String number) {
			this.number = number;
			this.totalDuration = 0;
			this.durations = new ArrayList<>();
		}

		@Override
		public int compareTo(PhoneNumber other) {
			return other.totalDuration - this.totalDuration;
		}
	}

	private int calDuration(String time) {
		int total = 0;
		for (String entry : time.split(":")) {
			int temp = Integer.parseInt(entry);
			total = total * 60 + temp;
		}
		return total;
	}

	private int calPrice(int duration) {
		if (duration < 300) {
			return duration * 3;
		} else {
			return 150 * getMinutes(duration);
		}
	}

	private int getMinutes(int duration) {
		int minutes = duration / 60;
		return minutes % 60 == 0 ? minutes : minutes + 1;
	}

	public static void main(String[] args) {
		String S = "00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090";
		System.out.println(new T().solution(S));
	}

}
