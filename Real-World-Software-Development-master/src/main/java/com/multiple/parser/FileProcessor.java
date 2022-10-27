package com.multiple.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import com.iteratrlearning.shu_book.chapter_04.UnknownFileTypeException;

public class FileProcessor {
	private final Map<String, BankStatementParser> extensionToImporter = new HashMap<>();
	final String RESOURCES = "src/test/resources/";
	String filename;

	public FileProcessor() {
		extensionToImporter.put("csv", new BankStatementParserCSV());
		extensionToImporter.put("json", new BankStatementParserJSON());
	}

	public List<BankTransaction> parseFile(final String fileName) throws IOException, ParseException {
		final String filePath = RESOURCES + fileName;
		final File file = new File(filePath);
		final Path path = Paths.get(filePath);

		if (!file.exists()) {
			throw new FileNotFoundException(fileName);
		}

		final int separatorIndex = fileName.lastIndexOf('.');

		if (separatorIndex != -1) {
			if (separatorIndex == fileName.length()) {
				throw new UnknownFileTypeException("No extension found For file: " + fileName);
			}
			final String extension = fileName.substring(separatorIndex + 1);

			final BankStatementParser importer = extensionToImporter.get(extension);
			if (importer == null) {
				throw new UnknownFileTypeException("For file: " + fileName);
			}

			final List<BankTransaction> bankTransactions = importer.readFile(path);
			return bankTransactions;
		} else {
			throw new UnknownFileTypeException("No extension found For file: " + fileName);
		}
	}
}
