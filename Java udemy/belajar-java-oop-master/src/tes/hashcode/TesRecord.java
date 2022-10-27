package tes.hashcode;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class TesRecord {
	public static void main(String[] args) {
		MyRecord tes1 = new MyRecord("a", "b");
		System.out.println(tes1);
		System.out.println(tes1.name());
		Level tes2 = Level.MEDIUM;
		System.out.print(Arrays.asList(Level.values()));
		int a[] = null;

		try {
			System.out.print(a[10]);
		} catch (Throwable err) {
			err.printStackTrace();
		}
	}

	public record MyRecord(String name, String lastName) {

	}

	public enum Level {
		SMALL, MEDIUM, LARGE
	}

	@Retention(RetentionPolicy.RUNTIME)
	public @interface OnlyFans {

	}
}
