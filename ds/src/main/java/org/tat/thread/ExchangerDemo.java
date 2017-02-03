package org.tat.thread;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
	static Exchanger<Integer> exchanger = new Exchanger<Integer>();

	public static void main(String[] args) {
		class FillingLoop implements Runnable {

			@Override
			public void run() {
				int exchangeVal = 0;
				try {
							System.out
									.println("FillingLoop : exchangeVal before : " + exchangeVal);
							exchangeVal = exchanger.exchange(exchangeVal);
							System.out
									.println("FillingLoop : exchangeVal after : " + exchangeVal);
				} catch (InterruptedException ie) {
					System.out.println("filling loop thread interrupted");
				}
			}
		}

		class EmptyingLoop implements Runnable {
			@Override
			public void run() {
				int exchangeVal = 1;
				try {
							System.out
									.println("EmptyingLoop : exchangeVal before : " + exchangeVal);
							exchangeVal = exchanger.exchange(exchangeVal);
							System.out
									.println("EmptyingLoop : exchangeVal after : " + exchangeVal);
				} catch (InterruptedException ie) {
					System.out.println("filling loop thread interrupted");
				}
			}
		}

		new Thread(new EmptyingLoop()).start();
		new Thread(new FillingLoop()).start();
	}
}
