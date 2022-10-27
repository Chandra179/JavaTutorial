package com.multiple.parser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.json.simple.parser.ParseException;

public interface BankStatementParser {
	List<BankTransaction> readFile(Path filename) throws IOException, ParseException;
}
