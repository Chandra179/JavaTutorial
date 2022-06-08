package com.multiple.parser;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BankStatementParserJSON implements BankStatementParser {

	private static BankTransaction parseEmployeeObject(JSONObject data) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date = (String) data.get("date");

		LocalDate formattedDate = LocalDate.parse(date, formatter);
		Double amount = Double.parseDouble((String) data.get("amount"));
		String category = (String) data.get("category");

		return new BankTransaction(formattedDate, amount, category);
	}

	@Override
	public List<BankTransaction> readFile(Path path) throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();

		FileReader reader = new FileReader(path.toString());
		Object obj = jsonParser.parse(reader);

		JSONArray transactionList = (JSONArray) obj;

		List<BankTransaction> myList = new ArrayList<>();

		for (Object o : transactionList) {
			JSONObject data = (JSONObject) o;
			myList.add(parseEmployeeObject(data));
		}

		return myList;

//		return (List<BankTransaction>) transactionList.stream().map(t -> parseEmployeeObject((JSONObject) t))
//				.collect(Collectors.toList());
	}
}
