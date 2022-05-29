package belajar.java.date.time;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;

public class TimeZoneTest {

	@Test
	void create() {

		System.out.println("-------");

		TimeZone timeZoneDefault = TimeZone.getDefault();
		System.out.println(timeZoneDefault);

		TimeZone timeZoneGMT = TimeZone.getTimeZone("GMT");
		System.out.println(timeZoneGMT);

		String[] availableIDs = TimeZone.getAvailableIDs();
		for (String i : availableIDs) {
			System.out.println(i);
		}
		// Arrays.asList(availableIDs).forEach(zoneId -> System.out.println(zoneId));

	}

	@Test
	void date() {
		System.out.println("-------");

		Date date = new Date();
		System.out.println(date.toString());
		System.out.println(date.toGMTString());
	}

	@Test
	void calendar() {

		System.out.println("-------");
		Calendar calendarJakarta = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));
		Calendar calendarFrench = Calendar.getInstance(Locale.GERMANY);
		Calendar calendarGMT = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

		System.out.println("Jakarta " + calendarJakarta.get(Calendar.HOUR_OF_DAY));
		System.out.println("Germany " + calendarFrench.get(Calendar.HOUR_OF_DAY));
		System.out.println(calendarGMT.get(Calendar.HOUR_OF_DAY));

		calendarJakarta.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println(calendarJakarta.get(Calendar.HOUR_OF_DAY));

	}
}
