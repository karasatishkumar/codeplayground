package org.tat.thread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
	private String name;
	private int amount;

	public Account(int amount, String name) {
		this.amount = amount;
		this.name = name;
	}
	
	private void lock(Lock lock1, Lock lock2){
		boolean lock1Result = Boolean.FALSE;
		boolean lock2Result = Boolean.FALSE;
		while(true){
			try{
				lock1Result = lock1.tryLock();
				lock2Result = lock2.tryLock();
			}finally{
				if(lock1Result && lock2Result)
					return;
				if(lock1Result)
					lock1.unlock();
				if(lock2Result)
					lock2.unlock();
			}
		}
	}

	public void deductAmount(int amount, Lock lock1, Lock lock2) {
		try {
			// deadlock condition created
			// as the lock2 and lock1 both will be waiting for eachother
			//lock2.lock();
			//lock1.lock();
			lock(lock1, lock2);
			this.amount -= amount;
		} finally {
			lock1.unlock();
			lock2.unlock();
		}
	}

	public void addAmount(int amount, Lock lock1, Lock lock2) {
		try {
			// deadlock condition created
			// as the lock2 and lock1 both will be waiting for eachother
			//lock1.lock();
			//lock2.lock();
			lock(lock1, lock2);
			this.amount += amount;
		} finally {
			lock1.unlock();
			lock2.unlock();
		}
	}

	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", amount=" + amount + "]";
	}

}

class Bank {
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	public void transfer(Account fromAccount, Account toAccount, int amount)
			throws InterruptedException {
		fromAccount.deductAmount(amount, lock1, lock2);
		toAccount.addAmount(amount, lock1, lock2);
	}
}

public class DeadLock {
	private static Account acc1 = new Account(10000, "Acc1");
	private static Account acc2 = new Account(10000, "Acc2");

	private static Bank bank = new Bank();
	
	private static Random random = new Random();

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					for (int i = 0; i < 10000; i++) {
						bank.transfer(acc1, acc2, random.nextInt(1000));
					}
					System.out.println("After Transfer");
					System.out.println(acc1);
					System.out.println(acc2);
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
					for (int i = 0; i < 10000; i++) {
						bank.transfer(acc2, acc1, random.nextInt(1000));
					}
					System.out.println("After Transfer");
					System.out.println(acc2);
					System.out.println(acc1);
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
