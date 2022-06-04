package com.json.test;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import com.multiple.parser.NewBankStatementAnalyzer;

public class JsonTest {

	@Test
	void loadJsonFile() throws IOException, ParseException {

		NewBankStatementAnalyzer analyzer = new NewBankStatementAnalyzer();
		analyzer.analyze("bank-data-simple.json");
	}
}
