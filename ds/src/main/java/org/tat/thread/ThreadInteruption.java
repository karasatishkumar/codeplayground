package org.tat.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadInteruption {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting...");
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<Integer> f = es.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				for (int i = 0; i < 10E8; i++) {
					if(Thread.currentThread().isInterrupted()){
						System.out.println("Interupted....");
						break;
					}
				}
				return 1;
			}
		});
		es.shutdown();
		Thread.sleep(1000);
		f.cancel(true);
		es.awaitTermination(1, TimeUnit.DAYS);
		System.out.println("Finished..");
	}
}
