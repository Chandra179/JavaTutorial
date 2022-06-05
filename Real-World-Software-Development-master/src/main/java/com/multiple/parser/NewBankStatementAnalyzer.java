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

		String fileExtension = getFileExtension(filePath);
		
		BankStatementParser fileParser = parseFile(fileExtension);

		final List<BankTransaction> bankTransactions = fileParser.readFile(filePath);

		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

		collectSummary(bankStatementProcessor);
	}

	public BankStatementParser parseFile(final String extension) {
		final BankStatementParser parser = switch (extension) {
		case "json" -> new BankStatementReaderJSON();
		case "csv" -> new BankStatementReaderCSV();
		default -> throw new IllegalArgumentException("No file parser with this extension: " + extension);
		};
		return parser;
	}

	public String getFileExtension(final Path path) {

		final String filePath = path.toString();
		final int lastIndexOf = filePath.lastIndexOf(".");

		if (lastIndexOf == -1) {
			throw new IllegalArgumentException("No file extension");
		}

		final String extension = filePath.substring(lastIndexOf + 1);
		return extension;
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
