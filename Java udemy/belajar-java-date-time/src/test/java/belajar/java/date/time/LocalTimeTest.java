package belajar.java.date.time;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

public class LocalTimeTest {

	@Test
	void create() {

		System.out.println("1------------");
		LocalTime localTime1 = LocalTime.now();
		LocalTime localTime2 = LocalTime.of(10, 10, 10);
		LocalTime localTime3 = LocalTime.parse("08:08");

		System.out.println(localTime1);
		System.out.println(localTime2);
		System.out.println(localTime3);

	}

	@Test
	void change() {

		System.out.println("2------------");
		LocalTime localTime1 = LocalTime.now();
		LocalTime localTime2 = localTime1.withHour(10);
		LocalTime localTime3 = localTime1.withHour(5).withMinute(10).withSecond(0);

		System.out.println(localTime1);
		System.out.println(localTime2);
		System.out.println(localTime3);

	}

	@Test
	void modify() {

		System.out.println("3------------");
		LocalTime localTime1 = LocalTime.now();
		LocalTime localTime2 = localTime1.plusHours(10);
		LocalTime localTime3 = localTime1.plusHours(5).minusMinutes(10).minusSeconds(5);

		System.out.println(localTime1);
		System.out.println(localTime2);
		System.out.println(localTime3);

	}

	@Test
	void get() {
		System.out.println("4------------");
		LocalTime localTime = LocalTime.now();

		System.out.println(localTime.getHour());
		System.out.println(localTime.getMinute());
		System.out.println(localTime.getSecond());
		System.out.println(localTime.getNano());
	}
}
