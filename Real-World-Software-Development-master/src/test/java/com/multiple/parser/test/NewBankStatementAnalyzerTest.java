package com.multiple.parser.test;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import com.multiple.parser.NewBankStatementAnalyzer;

public class NewBankStatementAnalyzerTest {

	@Test
	void analyzeFile() throws IOException, ParseException {

		NewBankStatementAnalyzer analyzer = new NewBankStatementAnalyzer();
		// analyzer.analyze("bank-data-simple"); // error
		analyzer.analyze("bank-data-simple.csv");
		analyzer.analyze("bank-data-simple.json");
	}
}
