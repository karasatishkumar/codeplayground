package org.tat.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor2 implements Runnable{
	
	private CountDownLatch cdl;
	private int id;
	
	public Processor2(CountDownLatch cdl, int id) {
		// TODO Auto-generated constructor stub
		this.cdl = cdl;
		this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread : " + id);
		this.cdl.countDown();
		
	}
	
}

public class CountDownLatchExample {
	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(3);
		ExecutorService ex = Executors.newFixedThreadPool(3);
		for(int i = 0 ; i < 3 ; i++){
			ex.submit(new Processor2(cdl, i));
		}
		try {
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ended");
		ex.shutdown();
	}
}
