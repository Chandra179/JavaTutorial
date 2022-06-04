package com.multiple.parser;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

public interface BankStatementReader {
	List<BankTransaction> readFile(String path) throws IOException, ParseException;
}
