package org.tat.thread;

class RunnerRunnable implements Runnable{

	@Override
	public void run() {
		for(int i = 0 ; i < 10 ; i++){
			System.out.println("Hello " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

public class RunnableExample {
	public static void main(String[] args) {
		Thread t1 = new Thread(new RunnerRunnable());
		Thread t2 = new Thread(new RunnerRunnable());
		t1.start();
		t2.start();
	}
}
