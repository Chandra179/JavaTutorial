package com.multiple.parser;

import java.io.IOException;
import java.time.Month;
import java.util.List;

import org.json.simple.parser.ParseException;

public class NewBankStatementAnalyzer {

	public void analyze(final String fileName) throws IOException, ParseException {

		final FileProcessor fileProcessor = new FileProcessor();
		
		final List<BankTransaction> bankTransactions = fileProcessor.parseFile(fileName);

		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

		collectSummary(bankStatementProcessor);
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
