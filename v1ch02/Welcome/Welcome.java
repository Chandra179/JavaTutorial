import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class Welcome {

	public static void main(String[] args) {

		System.out.println("---------\nSqrt <- import library");
		System.out.println("The square root of \u03C0 is " + sqrt(PI));

		// Casts
		System.out.println("---------\nCasts");
		double x = 9.997;
		int nx = (int) Math.round(x);
		System.out.println(nx);

		// && operator
		System.out.println("---------\n&& operator");
		String str = null;
		System.out.println(str != null && !str.equals(""));
		// System.out.println(str != null & !str.equals(""));

		// Enum
		enum Size {
			SMALL, MEDIUM, LARGE, EXTRA_LARGE
		}
		;

		// Switch case
		System.out.println("---------\nSwitch case");
		Size itemSize = Size.LARGE;
		String label = switch (itemSize) {
		case SMALL -> "S"; // no need to use Size.SMALL
		case MEDIUM -> "M";
		case LARGE -> "L";
		case EXTRA_LARGE -> "XL";
		};
		System.out.println("Switch case -> " + label);

		// Substring
		System.out.println("---------\nSubstring");
		String greeting = "Hello";
		String s = greeting.substring(0, 3);
		System.out.println("Substring -> " + s);

		// Concatenation
		System.out.println("---------\nConcatenation");
		String expletive = "Expletive";
		String PG13 = "deleted";
		String message = expletive + PG13;
		System.out.println("Concatenation -> " + message);

		// Is equal
		System.out.println("---------\nIs equal");
		boolean isEqual = "Hello".equals(greeting);
		System.out.println("isequal -> " + isEqual);

		/**
		 * If the virtual machine always arranges for equal strings to be shared, then
		 * you could use the == operator for testing equality. But only string literals
		 * are shared, not strings that are the result of operations like + or
		 * substring. Therefore, never use == to compare strings lest you end up with a
		 * program with the worst kind of bug
		 */
		System.out.println(greeting.substring(0, 3) == "Hel");

		// empty string
		System.out.println("---------\nEmpty string");
		System.out.println("tes".length() == 0);
		System.out.println("".equals(""));

		// string length
		System.out.println("---------\nString length");
		System.out.println(greeting.length());
		System.out.println(greeting.codePointCount(0, greeting.length()));

		// find char in string
		System.out.println("---------\nFind char in string");
		System.out.println(greeting.charAt(0)); // first is 'H'
		System.out.println(greeting.charAt(4)); // last is 'o'
		System.out.println(greeting.offsetByCodePoints(0, 3));
		System.out.println(greeting.codePointAt(1)); // by index

	}
}
