package org.tat.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeExample {
	public static void main(String[] args) {
		DateTimeExample dte = new DateTimeExample();

		dte.localDateTime();
		dte.zonedDateTime();
	}

	public void localDateTime() {
		// get the current date and time
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Current datetime : " + currentTime);

		LocalDate localDate = currentTime.toLocalDate();
		System.out.println("Local Date : " + localDate);

		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		int seconds = currentTime.getSecond();

		System.out.println("Month: " + month + " day: " + day + " seconds: "
				+ seconds);

		LocalDateTime customDate = currentTime.withDayOfMonth(10)
				.withYear(2012);
		System.out.println("Custom Date : " + customDate);

		// 12 december 2014
		LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println("date3: " + date3);

		// 22 hour 15 minutes
		LocalTime date4 = LocalTime.of(22, 15);
		System.out.println("date4: " + date4);

		// parse a string
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println("date5: " + date5);

	}

	public void zonedDateTime() {

		// Get the current date and time
		ZonedDateTime date1 = ZonedDateTime
				.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
		System.out.println("date1: " + date1);

		ZoneId id = ZoneId.of("Europe/Paris");
		System.out.println("ZoneId: " + id);

		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println("CurrentZone: " + currentZone);
	}
}
