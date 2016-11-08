package org.tat.java8;

import java.util.Optional;

public class OptionalExample {
	public static void main(String[] args) {
		OptionalExample oe = new OptionalExample();
		
		Integer value1 = null;
		Integer value2 = new Integer(10);
		
		//Optional.ofNullable - allows passed param to be null
		Optional<Integer> a = Optional.ofNullable(value1);
		
		//Optional.of throws NullPointerException, if passed param null
		Optional<Integer> b = Optional.of(value2);
		
		System.out.println("Sum : " + oe.sum(a, b));
	}
	
	public Integer sum(Optional<Integer> a, Optional<Integer> b){
		//Optional.isPresent - checks the value is present or not
		
		System.out.println("First param is present : " + a.isPresent());
		System.out.println("Second param is present : " + b.isPresent());
		
		//Optional.orElse - returns the value if present otherwise returns
		//The default value are passed
		Integer value1 = a.orElse(new Integer(0));
		
		//Optional.get - get the value, value should be present
		Integer value2 = b.get();
		
		return value1+value2;
	}
}
