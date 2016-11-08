package org.tat.java8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodDurationExample {
	public static void main(String[] args) {
		PeriodDurationExample pde = new PeriodDurationExample();
		pde.periodExample();
		pde.durationExample();
	}

	public void periodExample() {
		// Get the current date
		LocalDate date1 = LocalDate.now();
		System.out.println("Current date: " + date1);

		// Add 1 month to the current date
		LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
		System.out.println("Next month: " + date2);

		Period period = Period.between(date2, date1);
		System.out.println("Period: " + period);
	}

	public void durationExample() {
		LocalTime time1 = LocalTime.now();
		Duration twoHours = Duration.ofHours(2);

		LocalTime time2 = time1.plus(twoHours);
		Duration duration = Duration.between(time1, time2);

		System.out.println("Duration: " + duration);
	}
}
