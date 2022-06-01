package com.database.test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.iteratrlearning.shu_book.chapter_06.Twoot;
import com.iteratrlearning.shu_book.chapter_06.database.DatabaseTwootRepository;

public class DatabaseConnectionTest {

	@Test
	void successAddToDatabase() {
		DatabaseTwootRepository conn = new DatabaseTwootRepository();
		conn.add("1", "asd", "content1");
		conn.add("3", "asd", "content3");
		conn.add("4", "asd", "content4");
		conn.add("5", "asd", "content5");
		System.out.println(conn.get("1").get());
		assertTrue(conn.get("1").isPresent());
	}
	
	@Test
	void addDuplicateDataShouldFailed() {
		DatabaseTwootRepository conn = new DatabaseTwootRepository();
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
	void getAllDataFromDatabase() throws SQLException {
		DatabaseTwootRepository conn = new DatabaseTwootRepository();
		var result = conn.getAllTwoot();
		while (result.next()) {
			 System.out.println(result.getString(1));
			 System.out.println(result.getString(2));
			 System.out.println(result.getString(3));
			 System.out.println(result.getString(4));
		}
	}
}
