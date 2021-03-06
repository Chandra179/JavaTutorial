package com.iteratrlearning.shu_book.chapter_04;

import static com.iteratrlearning.shu_book.chapter_04.Attributes.ADDRESS;
import static com.iteratrlearning.shu_book.chapter_04.Attributes.BODY;
import static com.iteratrlearning.shu_book.chapter_04.Attributes.PATIENT;
import static com.iteratrlearning.shu_book.chapter_04.Attributes.TYPE;

import java.io.File;
import java.io.IOException;
import java.util.Map;

class LetterImporter implements Importer {
	private static final String NAME_PREFIX = "Dear ";

	// tag::importFile[]
	@Override
	public Document importFile(final File file) throws IOException {
		final TextFile textFile = new TextFile(file);

		textFile.addLineSuffix(NAME_PREFIX, PATIENT);

		final int lineNumber = textFile.addLines(2, t -> t.isEmpty(), ADDRESS);
		textFile.addLines(lineNumber + 1, (line) -> line.startsWith("regards,"), BODY);

		final Map<String, String> attributes = textFile.getAttributes();
		attributes.put(TYPE, "LETTER");

		System.out.println(attributes);

		return new Document(attributes);
	}
	// end::importFile[]
}
