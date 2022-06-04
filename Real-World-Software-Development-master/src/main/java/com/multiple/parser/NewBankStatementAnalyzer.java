package com.multiple.parser;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import org.json.simple.parser.ParseException;

public class NewBankStatementAnalyzer {

	public void analyze(final String fileName) throws IOException, ParseException {

		final String RESOURCES = "src/test/resources/";
		final String path = Paths.get(RESOURCES + fileName).toString();
		System.out.println(path);

		BankStatementReader fileReader = checkFileExtension(path);

		final List<BankTransaction> bankTransactions = fileReader.readFile(path);

		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

		collectSummary(bankStatementProcessor);

	}

	public BankStatementReader checkFileExtension(final String path) {

		final String fileExt = "json";
		BankStatementReader fileReader = null;

		switch (fileExt) {
		case "json":
			fileReader = new BankStatementReaderJSON();
		default:
			System.out.println("default");
		}

		return fileReader;
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
