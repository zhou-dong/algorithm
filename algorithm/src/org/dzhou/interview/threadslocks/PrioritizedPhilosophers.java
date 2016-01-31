package org.dzhou.interview.threadslocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class PrioritizedPhilosophers {

	public class Philosopher extends Thread {
		private int bites = 10;
		private Chopstick lower, higher;
		private int index;

		public Philosopher(int i, Chopstick left, Chopstick right) {
			this.index = i;
			if (left.getNumber() < right.getNumber()) {
				this.lower = left;
				this.higher = right;
			} else {
				this.lower = right;
				this.higher = left;
			}
		}

		public int getIndex() {
			return index;
		}

		public void eat() {
			pickUp();
			chew();
			putDown();
		}

		public void pickUp() {
			lower.pickUp();
			higher.pickUp();
		}

		public void chew() {
		}

		public void putDown() {
			higher.putDown();
			lower.putDown();
		}

		public void run() {
			for (int i = 0; i < bites; i++) {
				eat();
			}
		}
	}

	public class Chopstick {
		private Lock lock;
		private int number;

		public Chopstick(int n) {
			lock = new ReentrantLock();
			this.number = n;
		}

		public void pickUp() {
			lock.lock();
		}

		public void putDown() {
			lock.unlock();
		}

		public int getNumber() {
			return number;
		}
	}

}