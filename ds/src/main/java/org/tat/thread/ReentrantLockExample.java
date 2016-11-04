package org.tat.thread;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
	private int counter;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	public void increamentByOne() throws InterruptedException {
		try {
			System.out.println("Going to the waiting state...");
			lock.lock();
			cond.await();
			for (int i = 0; i < 10000; i++) {
				counter++;
			}
			System.out.println("Woke up now..");
		} finally {
			lock.unlock();
		}
	}

	public void increamentByTwo() throws InterruptedException {
		Thread.sleep(1000);
		try {
			lock.lock();
			for (int i = 0; i < 10000; i++) {
				counter = counter + 2;
			}
			System.out.println("Press return to proceed..");
			new Scanner(System.in).nextLine();
			System.out.println("Got Return..");
			cond.signal();
		} finally {
			lock.unlock();
		}
	}

	public int getCounter() {
		return counter;
	}
}

public class ReentrantLockExample {

	private static Counter counter = new Counter();

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					counter.increamentByOne();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					counter.increamentByTwo();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Counter : " + counter.getCounter());
	}

}
