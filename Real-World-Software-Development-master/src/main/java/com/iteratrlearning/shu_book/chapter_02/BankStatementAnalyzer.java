package com.iteratrlearning.shu_book.chapter_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

	public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {

		final String RESOURCES = "src/main/resources/";
		final Path path = Paths.get(RESOURCES + fileName);
		final List<String> lines = Files.readAllLines(path);
		
		// checkFileExtension

		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

		collectSummary(bankStatementProcessor);

	}

	public void checkFileExtension(final String fileName) {

		// final string fileExt = path ....
		// switch (path)
		// case csv -> analyze(filename, new BankStatementReaderCSV())
		// case json -> analyze(filename, new BankStatementReaderJSON())
		// case xml -> analyze(filename, new BankStatementReaderXML())

		// bankStatementParser can be change to --> csvParser, jsonParser, etc ..
	}

	private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {

		System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
		System.out.println("The total for transactions in January is "
				+ bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		System.out.println("The total for transactions in February is "
				+ bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
		System.out
				.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
	}
}
