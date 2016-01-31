package org.dzhou.interview.threadslocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class DiningPhilosophers {

	public class Chopstick {
		private Lock lock;

		public Chopstick() {
			lock = new ReentrantLock();
		}

		public void putDown() {
			lock.unlock();
		}

		public boolean pickUp() {
			return lock.tryLock();
		}
	}

	public class Philosopher extends Thread {
		private int bites = 10;
		private Chopstick left, right;

		public Philosopher(Chopstick left, Chopstick right) {
			this.left = left;
			this.right = right;
		}

		public void eat() {
			if (pickUp()) {
				chew();
				putDown();
			}
		}

		public boolean pickUp() {
			if (!left.pickUp()) {
				return false;
			}
			if (!right.pickUp()) {
				left.putDown();
				return false;
			}
			return true;
		}

		public void chew() {
		}

		public void putDown() {
			left.putDown();
			right.putDown();
		}

		public void run() {
			for (int i = 0; i < bites; i++) {
				eat();
			}
		}
	}

}