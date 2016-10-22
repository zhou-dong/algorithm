package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 359. Logger Rate Limiter
 * 
 * Difficulty: Easy
 * 
 * Design a logger system that receive stream of messages along with its
 * timestamps, each message should be printed if and only if it is not printed
 * in the last 10 seconds.
 * 
 * Given a message and a timestamp (in seconds granularity), return true if the
 * message should be printed in the given timestamp, otherwise returns false.
 * 
 * It is possible that several messages arrive roughly at the same time.
 * 
 * Example:
 * 
 * Logger logger = new Logger();
 * 
 * // logging string "foo" at timestamp 1 <br>
 * logger.shouldPrintMessage(1, "foo"); returns true;
 * 
 * // logging string "bar" at timestamp 2 <br>
 * logger.shouldPrintMessage(2,"bar"); returns true;
 * 
 * // logging string "foo" at timestamp 3 <br>
 * logger.shouldPrintMessage(3,"foo"); returns false;
 * 
 * // logging string "bar" at timestamp 8 <br>
 * logger.shouldPrintMessage(8,"bar"); returns false;
 * 
 * // logging string "foo" at timestamp 10 <br>
 * logger.shouldPrintMessage(10,"foo"); returns false;
 * 
 * // logging string "foo" at timestamp 11 <br>
 * logger.shouldPrintMessage(11,"foo"); returns true;
 * 
 * @author zhoudong
 *
 */
public class LoggerRateLimiter {

	public class Logger {

		Map<String, Integer> map;

		/** Initialize your data structure here. */
		public Logger() {
			map = new HashMap<>();
		}

		/**
		 * Returns true if the message should be printed in the given timestamp,
		 * otherwise returns false. If this method returns false, the message
		 * will not be printed. The timestamp is in seconds granularity.
		 */
		public boolean shouldPrintMessage(int timestamp, String message) {
			if (!map.containsKey(message)) {
				map.put(message, timestamp);
				return true;
			}

			if (timestamp - map.get(message) < 10) {
				return false;
			}

			map.put(message, timestamp);
			return true;
		}

	}

	/**
	 * Your Logger object will be instantiated and called as such: Logger obj =
	 * new Logger(); boolean param_1 =
	 * obj.shouldPrintMessage(timestamp,message);
	 */

}
