package programmer.zaman.now.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

import programmer.zaman.now.test.generator.SimpleDisplayNameGenerator;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
// @DisplayName("Test untuk Calculator class")
public class CalculatorTest {

	private Calculator calculator = new Calculator();

	@BeforeAll
	public static void beforeAll() {
		System.out.println("Before all");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("After all");
	}

	@BeforeEach
	public void setUp() {
		System.out.println("Before each");
	}

	@AfterEach
	public void tearDown() {
		System.out.println("After each");
	}

	@Test
	// @DisplayName("Test skenario sukses untuk method add(integer, integer)")
	public void testAddSuccess() {
		var result = calculator.add(10, 10);
		assertEquals(20, result);
//    if (result != 20) {
//      throw new RuntimeException("Test gagal");
//    }

	}

	@Test
	public void testDivideSuccess() {
		var result = calculator.divide(100, 10);
		assertEquals(10, result);
	}

	@Test
	public void testDivideFailed() {
		assertThrows(IllegalArgumentException.class, () -> {
			calculator.divide(10, 0);
		});
	}

	@Test
	@Disabled
	public void testComingSoon() {

	}

	@Test
	public void testAborted() {
		var profile = System.getenv("PROFILE");
		if (!"DEV".equals(profile)) {
			throw new TestAbortedException("Test dibatalkan karena bukan DEV");
		}

		// unit test untuk DEV
	}

	@Test
	public void testAssumptions() {
		assumeTrue("DEV".equals(System.getenv("PROFILE")));

		// unit test untuk DEV
	}

}
