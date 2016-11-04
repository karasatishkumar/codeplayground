package org.tat.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor1 implements Runnable{
	
	private int id;
	
	public Processor1(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting : "+ id);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed : " + id);
		
	}
	
}

public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		for(int i = 0 ;  i< 5 ; i++){
			es.submit(new Processor1(i));
		}
		
		es.shutdown();
		try {
			es.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Submitted..");
	}
}
