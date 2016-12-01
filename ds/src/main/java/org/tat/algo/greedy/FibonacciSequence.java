package org.tat.algo.greedy;

abstract class a{
	public a() {
		// TODO Auto-generated constructor stub
	}
}

public class FibonacciSequence {
	
	public static int fibonacci(int n){
		Integer store[] = new Integer[n+1];
		if(n == 0){
			store[0] = 0;
			return store[0];
		}
		
		if(n == 1){
			store[1] = 1;
			return store[1];
		}
		
		if(store[n] == null){
			store[n] = fibonacci(n-1) + fibonacci(n-2);
		}
		return store[n];
	}
	
	public static final void main(String[] args) {
		System.out.println("Fibonacci 7: " + fibonacci(7));
	}
}
