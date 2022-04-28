import java.util.Arrays;

public class Tutorial {

	public static void main(String[] args) {
		String greeting = "abcd";

		boolean tes = greeting == null;
		System.out.println(tes);

		// string length
		System.out.println(greeting.length() == 0);

		// string builder
		StringBuilder builder = new StringBuilder();
		builder.append('c'); // appends a single character
		builder.append("ssd"); // appends a string
		System.out.println(builder);

		// scanner
//		Scanner in = new Scanner(System.in);
//		System.out.print("What is your name? ");
//		String name = in.nextLine();
//
//		System.out.print("How old are you? ");
//		int age = in.nextInt();
//		System.out.printf("Hello %s!%d", name, age);
//		in.close();

//		Console cons = System.console();
//		String username = cons.readLine("User name: ");
//		char[] passwd = cons.readPassword("Password: ");

		System.out.printf("%8.2f\n", 3.45534534);
		int[] smallPrimes = { 2, 3, 5, 7, 11, 13 };

		int[] assi = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < assi.length; i++) {
			System.out.println(assi[i]);
		}
		System.out.println("--------------");

		int[] luckyNumbers = smallPrimes;
		luckyNumbers[5] = 12; // now smallPrimes[5] is also 12
		for (int i = 0; i < smallPrimes.length; i++) {
			System.out.println(smallPrimes[i]);
		}

		System.out.println("--------------");
		luckyNumbers = Arrays.copyOf(luckyNumbers, 2 * luckyNumbers.length);
		Arrays.sort(luckyNumbers);
		for (int i = 0; i < luckyNumbers.length; i++) {
			System.out.println(luckyNumbers[i]);
		}

	}
}
