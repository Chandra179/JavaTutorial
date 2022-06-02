package com.database.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.function.Consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.iteratrlearning.shu_book.chapter_06.Twoot;
import com.iteratrlearning.shu_book.chapter_06.TwootQuery;
import com.iteratrlearning.shu_book.chapter_06.database.DatabaseTwootRepository;

public class InDatabaseMemorytest {

	@Test
	@BeforeEach
	void cleanDatabase() {
		DatabaseTwootRepository conn = new DatabaseTwootRepository();
		conn.clear();
	}

	@Test
	void successAddToDatabase() {
		DatabaseTwootRepository conn = new DatabaseTwootRepository();
		conn.add("1", "asd", "content1");
		assertTrue(conn.get("1").isPresent());
	}

	@Test
	void successCleanDatabase() {
		DatabaseTwootRepository conn = new DatabaseTwootRepository();
		conn.clear();
		assertThrows(IllegalStateException.class, () -> conn.get("1"));
	}

	@Test
	void query() throws SQLException {

		System.out.println("-----START-------");

		DatabaseTwootRepository conn = new DatabaseTwootRepository();

		var tes1 = conn.add("1", "asds", "content2asd");
		conn.add("2", "asds", "content2asd");
		conn.add("3", "asdss", "content3asd");

		Consumer<Twoot> consumer1 = tes1;

		TwootQuery lol = new TwootQuery();
		lol.inUsers("1", "asds", "3");

		conn.query(new TwootQuery(), consumer1);

		System.out.println("-----END-------");
	}
	
	@Test
	void addDuplicateDataShouldFailed() {
		DatabaseTwootRepository conn = new DatabaseTwootRepository();
		conn.add("1", "asd", "content1");
		assertThrows(IllegalStateException.class,()-> conn.add("1", "asd", "content1"));
	}
	
	@Test
	void getUnkownTwootShouldReturnEmpty() {
		DatabaseTwootRepository conn = new DatabaseTwootRepository();
		assertTrue(conn.get("2").isEmpty());
	}
	
	@Test
	void successDeleteTwoot() {
		DatabaseTwootRepository conn = new DatabaseTwootRepository();
		Twoot added = conn.add("2", "cv", "2content");
		conn.delete(added);
		assertTrue(conn.get("2").isEmpty());
	}
	
	@Test
	void successUpdateTwoot() {
		DatabaseTwootRepository conn = new DatabaseTwootRepository();

		conn.add("1", "cv", "2content");

		var before = conn.get("1").get().getContent();
		conn.update("1", "updated content");

		var after = conn.get("1").get().getContent();
		assertFalse(before.equals(after));
	}

	@Test
	void getAllDataFromDatabase() throws SQLException {
		DatabaseTwootRepository conn = new DatabaseTwootRepository();
		var result = conn.getAllTwoot();

		System.out.println("------------");

		while (result.next()) {
			System.out.println(result.getString(1));
			System.out.println(result.getString(2));
			System.out.println(result.getString(3));
			System.out.println(result.getString(4));
		}
	}
}
