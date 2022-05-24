package programmer.zaman.now.test;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomCalculatorTest extends AbstractCalculatorTest {

	@Test
	void testRandom(TestInfo info, Random random) {
		var a = random.nextInt();
		var b = random.nextInt();

		var result = calculator.add(a, b);
		var expected = a + b;

		Assertions.assertEquals(expected, result);

	}

	@DisplayName("Test random calculator")
	@RepeatedTest(value = 10, name = "{displayName} ke {currentRepetition} dari {totalRepetitions}")
	void testRandomRepeat(TestInfo info, Random random) {
		var a = random.nextInt();
		var b = random.nextInt();

		var result = calculator.add(a, b);
		var expected = a + b;

		Assertions.assertEquals(expected, result);

	}

	@DisplayName("Test random calculator")
	@RepeatedTest(value = 10, name = "{displayName}")
	void testRandomRepeatInfo(TestInfo info, Random random, RepetitionInfo repetitionInfo) {
		System.out.println(info.getDisplayName() + " ke " + repetitionInfo.getCurrentRepetition() + " dari "
				+ repetitionInfo.getTotalRepetitions());
		var a = random.nextInt();
		var b = random.nextInt();

		var result = calculator.add(a, b);
		var expected = a + b;

		Assertions.assertEquals(expected, result);

	}

	@DisplayName("Test calculator")
	@ParameterizedTest(name = "{displayName} dengan parameter {0}")
	@ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 45, 34, 56 })
	void testWithParameter(int value) {
		var expected = value + value;
		var result = calculator.add(value, value);

		Assertions.assertEquals(expected, result);
	}

	public static List<Integer> parameterSource() {
		return List.of(1, 2, 34, 56, 33, 65, 67, 35);
	}

	@DisplayName("Test calculator")
	@ParameterizedTest(name = "No. {index} - {displayName} dengan parameter {0}")
	@MethodSource({ "parameterSource" })
	void testWithMethodSource(Integer value) {
		var expected = value + value;
		var result = calculator.add(value, value);

		Assertions.assertEquals(expected, result);
	}
}
