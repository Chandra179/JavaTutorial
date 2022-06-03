package com.json.test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.iteratrlearning.shu_book.chapter_03.BankStatementReader;
import com.iteratrlearning.shu_book.chapter_03.BankStatementReaderJSON;

public class JsonTest {

	@Test
	void loadJsonFile() throws IOException {
		BankStatementReaderJSON tes = new BankStatementReaderJSON();

		Path path = Paths.get(BankStatementReader.RESOURCES + "bank-data-simple.csv");

		List<String> result = tes.readFileFrom(path);
		System.out.println(result);
	}
}
