package org.dzhou.practice.medium.premium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Design a hit counter which counts the number of hits received in the past 5
 * minutes.
 * 
 * Each function accepts a timestamp parameter (in seconds granularity) and you
 * may assume that calls are being made to the system in chronological order
 * (ie, the timestamp is monotonically increasing). You may assume that the
 * earliest timestamp starts at 1.
 * 
 * It is possible that several hits arrive roughly at the same time.
 * 
 * Example: <br>
 * HitCounter counter = new HitCounter();
 * 
 * // hit at timestamp 1. <br>
 * counter.hit(1);
 * 
 * // hit at timestamp 2. <br>
 * counter.hit(2);
 * 
 * // hit at timestamp 3. <br>
 * counter.hit(3);
 * 
 * // get hits at timestamp 4, should return 3. <br>
 * counter.getHits(4);
 * 
 * // hit at timestamp 300. <br>
 * counter.hit(300);
 * 
 * // get hits at timestamp 300, should return 4. <br>
 * counter.getHits(300);
 * 
 * // get hits at timestamp 301, should return 3. <br>
 * counter.getHits(301);
 * 
 * Follow up: <br>
 * What if the number of hits per second could be very large? Does your design
 * scale?
 * 
 * @author zhoudong
 *
 */
public class DesignHitCounter {

	public class HitCounter {

		Queue<Integer> queue = null;

		/** Initialize your data structure here. */
		public HitCounter() {
			queue = new LinkedList<>();
		}

		/**
		 * Record a hit.
		 * 
		 * @param timestamp
		 *            - The current timestamp (in seconds granularity).
		 */
		public void hit(int timestamp) {
			queue.add(timestamp);
		}

		/**
		 * Return the number of hits in the past 5 minutes.
		 * 
		 * @param timestamp
		 *            - The current timestamp (in seconds granularity).
		 */
		public int getHits(int timestamp) {
			while (!queue.isEmpty() && (timestamp - queue.peek() >= 300)) {
				queue.poll();
			}
			return queue.size();
		}
	}

	/**
	 * Your HitCounter object will be instantiated and called as such:
	 * 
	 * HitCounter obj = new HitCounter();
	 * 
	 * obj.hit(timestamp);
	 * 
	 * int param_2 = obj.getHits(timestamp);
	 */
}
