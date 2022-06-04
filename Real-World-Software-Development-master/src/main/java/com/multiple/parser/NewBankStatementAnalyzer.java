package com.multiple.parser;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import org.json.simple.parser.ParseException;

public class NewBankStatementAnalyzer {

	public void analyze(final String fileName) throws IOException, ParseException {

		final String RESOURCES = "src/test/resources/";
		final Path filePath = Paths.get(RESOURCES + fileName);

		BankStatementParser fileReader = parseFile(filePath);

		final List<BankTransaction> bankTransactions = fileReader.readFile(filePath);

		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

		collectSummary(bankStatementProcessor);
	}

	public BankStatementParser parseFile(final Path filePath) {

		String ext = getFileExtension(filePath);

		switch (ext) {
		case "json":
			return new BankStatementReaderJSON();
		case "csv":
			return new BankStatementReaderCSV();
		default:
			return new BankStatementReaderJSON();
		}
	}

	public String getFileExtension(final Path path) {
		String filPath = path.toString();
		int lastIndexOf = filPath.lastIndexOf(".");
		if (lastIndexOf == -1) {
			return ""; // empty extension
		}
		return filPath.substring(lastIndexOf + 1);
	}

	private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {

		System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
		System.out.println("The total for transactions in January is "
				+ bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		System.out.println("The total for transactions in February is "
				+ bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
		System.out
				.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
		System.out.println("----------------------");
	}
}
