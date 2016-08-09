package org.dzhou.practice.easy.premium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size, calculate the moving average of
 * all integers in the sliding window.
 * 
 * For example,<br>
 * MovingAverage m = new MovingAverage(3);<br>
 * m.next(1) = 1<br>
 * m.next(10) = (1 + 10) / 2 <br>
 * m.next(3) = (1 + 10 + 3) / 3 <br>
 * m.next(5) = (10 + 3 + 5) / 3 <br>
 * 
 * @author zhoudong
 *
 */
public class MovingAverageFromDataStream {

	public class MovingAverage {

		Queue<Integer> queue = new LinkedList<>();

		int size, sum;

		/** Initialize your data structure here. */
		public MovingAverage(int size) {
			this.size = size;
			this.sum = 0;
		}

		public double next(int val) {
			sum += val;
			if (isFull()) {
				sum -= queue.poll();
			}
			queue.add(val);
			return (double) sum / queue.size();
		}

		private boolean isFull() {
			return this.size == queue.size();
		}

	}

	/**
	 * Your MovingAverage object will be instantiated and called as such:
	 * 
	 * MovingAverage obj = new MovingAverage(size);
	 * 
	 * double param_1 = obj.next(val);
	 */
}
