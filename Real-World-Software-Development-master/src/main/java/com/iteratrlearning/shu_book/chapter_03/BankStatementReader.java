package com.iteratrlearning.shu_book.chapter_03;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface BankStatementReader {
	public final String RESOURCES = "src/main/resources/";

	List<String> readFileFrom(Path path) throws IOException;
}
