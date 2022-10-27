package com.iteratrlearning.shu_book.chapter_02;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser {

	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	@Override
	public BankTransaction parseFrom(final String line) {
		final String[] columns = line.split(",");

		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);

		return new BankTransaction(date, amount, columns[2]);
	}

	@Override
	public List<BankTransaction> parseLinesFrom(final List<String> lines) {
		return lines.stream().map(t -> parseFrom(t)).collect(toList());
	}
}
