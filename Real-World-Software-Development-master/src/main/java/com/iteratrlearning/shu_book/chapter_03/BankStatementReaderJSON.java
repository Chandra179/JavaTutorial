package com.iteratrlearning.shu_book.chapter_03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BankStatementReaderJSON implements BankStatementReader {

	@Override
	public List<String> readFileFrom(Path path) throws IOException {
		List<String> lines = Files.readAllLines(path);
		return lines;
	}
}
