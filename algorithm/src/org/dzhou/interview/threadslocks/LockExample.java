package org.dzhou.interview.threadslocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class LockExample {

	private Lock lock;
	private int balance = 100;

	public LockExample() {
		lock = new ReentrantLock();
	}

	public int withDraw(int value) {
		lock.lock();
		int temp = balance;
		try {
			Thread.sleep(100);
			temp = temp - value;
			Thread.sleep(100);
			balance = temp;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();
		return temp;
	}

	public int deposit(int value) {
		lock.lock();
		int temp = balance;
		try {
			Thread.sleep(100);
			temp = temp + value;
			Thread.sleep(300);
			balance = temp;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();
		return temp;
	}

}
