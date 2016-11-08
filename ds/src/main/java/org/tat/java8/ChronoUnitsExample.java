package org.tat.java8;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChronoUnitsExample {
	public static void main(String[] args) {
		ChronoUnitsExample cue = new ChronoUnitsExample();
		cue.chronoUnitsExample();
	}
	
	public void chronoUnitsExample(){
		//Get the current date
		LocalDate today = LocalDate.now();
		System.out.println("Current Date : " + today);
		
		//add 1 week to the current date
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Next Week : " + nextWeek);
		
		//add 1 month to the current date
		LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
		System.out.println("Next Month : " + nextMonth);
		
		//add 1 year to the current date
		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Next Year : " + nextYear);
		
		//add 10 years to the current date
		LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
		System.out.println("Next decade : " + nextDecade);
	}
}
