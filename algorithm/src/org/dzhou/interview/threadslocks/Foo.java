package org.dzhou.interview.threadslocks;

import java.util.concurrent.Semaphore;

public class Foo {

	Semaphore semaphore1, semaphore2;

	public Foo() {
		semaphore1 = new Semaphore(1);
		semaphore2 = new Semaphore(1);
		try {
			semaphore1.acquire();
			semaphore2.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void first() {
		doSth();
		semaphore1.release();
	}

	public void second() {
		try {
			semaphore1.acquire();
			semaphore1.release();
			doSth();
			semaphore2.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void third() {
		try {
			semaphore2.acquire();
			semaphore2.release();
			doSth();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void doSth() {

	}

}
