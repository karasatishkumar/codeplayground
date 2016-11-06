package org.tat.thread;

import java.util.concurrent.Semaphore;

class Connection {
	private static Connection conn = new Connection();
	private static int count = 0;
	private static Semaphore sema = new Semaphore(10);

	private Connection() {
	}

	public static Connection getIntance() throws InterruptedException {
		try{
			sema.acquire();
		}finally{
			System.out.println("No of connection : " + count++);
			Thread.sleep(2000);
			sema.release();
			count--;
		}
		return conn;
	}
}

public class SemaphoreExample {

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						Connection.getIntance();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
