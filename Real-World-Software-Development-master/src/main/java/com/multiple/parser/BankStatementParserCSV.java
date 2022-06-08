package com.multiple.parser;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.json.simple.parser.ParseException;

public class BankStatementParserCSV implements BankStatementParser {
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public BankTransaction parseFrom(final String line) {
		final String[] columns = line.split(",");

		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);

		return new BankTransaction(date, amount, columns[2]);
	}

	@Override
	public List<BankTransaction> readFile(Path filename) throws IOException, ParseException {
		final List<String> lines = Files.readAllLines(filename);
		return lines.stream().map(t -> parseFrom(t)).collect(toList());
	}
}
