package com.exercise;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ReorderDataInLogFiles {

	@Test
	public void shouldAnswerWithTrue() {

		String[] expected = { "let5 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6" };
		String[] logs = { "dig1 8 1 5 1", "let5 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };

		System.out.println(Arrays.deepToString(logs));

		Arrays.sort(logs, (s1, s2) -> {
			String[] split1 = s1.split(" ", 2);
			String[] split2 = s2.split(" ", 2);

			System.out.println(Arrays.deepToString(split1));
			System.out.println(Arrays.deepToString(split2));
			System.out.println("----------");

			boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
			boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

			if (!isDigit1 && !isDigit2) {
				// both letter-logs.
				int comp = split1[1].compareTo(split2[1]);

				System.out.println("letter logs");
				System.out.println(split1[1]);
				System.out.println(split2[1]);
				System.out.println("____");
				System.out.println(split1[0]);
				System.out.println(split1[0]);
				System.out.println("letter logs");

				if (comp == 0)
					return split1[0].compareTo(split2[0]);
				else
					return comp;
			} else if (isDigit1 && isDigit2) {
				// both digit-logs. So keep them in original order
				return 0;
			} else if (isDigit1 && !isDigit2) {
				// first is digit, second is letter. bring letter to forward.
				return 1;
			} else {
				// first is letter, second is digit. keep them in this order.
				return -1;
			}
		});

		System.out.println(Arrays.deepToString(logs));
		assertTrue(Arrays.equals(logs, expected));
	}
}
