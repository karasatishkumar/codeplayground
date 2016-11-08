package org.tat.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterExample {
	public static void main(String args[]) {
		TemporalAdjusterExample tae = new TemporalAdjusterExample();
		tae.adjustersExample();
	}

	public void adjustersExample() {

		// Get the current date
		LocalDate date1 = LocalDate.now();
		System.out.println("Current date: " + date1);

		// get the next tuesday
		LocalDate nextTuesday = date1.with(TemporalAdjusters
				.next(DayOfWeek.TUESDAY));
		System.out.println("Next Tuesday on : " + nextTuesday);

		// get the second saturday of next month
		LocalDate firstInYear = LocalDate.of(date1.getYear(), date1.getMonth(),
				1);
		LocalDate secondSaturday = firstInYear.with(
				TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).with(
				TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("Second Saturday on : " + secondSaturday);
	}
}
