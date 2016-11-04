package org.tat.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Bucket {

	private LinkedList<Integer> bucket = new LinkedList<Integer>();
	private Object lock = new Object();
	private static final int CAPACITY = 10;
	private Random random = new Random();

	public void producer() throws InterruptedException {
		while (true) {
			Thread.sleep(random.nextInt(1000));
			synchronized (lock) {
				if (bucket.size() == CAPACITY) {
					System.out.println("Bucket is full. We have to wait now.");
					lock.wait();
				}else{
					int v = random.nextInt(100);
					System.out.println("Putting the value : " + v);
					bucket.add(v);
					System.out.println("Notify thread to remove value..");
					lock.notify();
				}
			}
		}
	}

	public void consumer() throws InterruptedException {
		while (true) {
			Thread.sleep(random.nextInt(1000));
			synchronized (lock) {
				if (bucket.size() > 0) {
					int v = bucket.removeFirst();
					System.out.println("Removing the value : " + v);
					lock.notify();
					System.out.println("notifying threads to fill the bucket.");
				}else{
					System.out.println("No item, let's wait..");
					lock.wait();
				}
			}
		}
	}

}

public class WaitNotifyPubSubExample {
	private static Bucket b = new Bucket();

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					b.consumer();
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
					b.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}
