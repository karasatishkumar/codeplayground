package org.tat.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Generator implements Callable<Integer> {

	private Random random = new Random();
	private String name;

	public Generator(String name) {
		super();
		this.name = name;
	}

	@Override
	public Integer call() throws Exception {
		Thread.sleep(random.nextInt(3000));
		if(random.nextInt(10)%2 == 1)
			throw new RuntimeException("Invalid Number");
		return random.nextInt(1000);
	}

}

public class FeatureExample {
	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		for (int i = 0; i < 10; i++) {
			Future<Integer> task = es.submit(new Generator("Thead : " + i));
			list.add(task);
		}

		for (Future<Integer> future : list) {
			try {
				System.out.println("Result : " + future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		es.shutdown();

	}

}
