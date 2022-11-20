package com.iteratrlearning.shu_book.chapter_06;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.iteratrlearning.shu_book.chapter_06.in_memory.InMemoryTwootRepository;

public class InMemoryTwootRepositoryTest {
	
	@Test
	public void SuccessAddTwootToMemory() {
		TwootRepository tes = new InMemoryTwootRepository();
		tes.add("1", "AA", "BB");
		assertTrue(tes.get("1").isPresent());
	}
	
	@Test
	public void DeleteUnkownTwootFromMemory() {
		TwootRepository tes = new InMemoryTwootRepository();
		Position currentPosition = Position.INITIAL_POSITION;
		Twoot unknown = new Twoot("9", "CC", "DD", currentPosition);
		tes.delete(unknown);
	}
	
	@Test
	public void SuccessDeleteTwootFromMemory() {
		TwootRepository tes = new InMemoryTwootRepository();
		Twoot x = tes.add("1", "AA", "BB");
		tes.delete(x);
		assertFalse(tes.get("1").isPresent());
	}
	
	@Test
	public void TwootMemoryShouldEmpty() {
		TwootRepository tes = new InMemoryTwootRepository();
		tes.add("1", "AA", "BB");
		tes.add("2", "AA", "BB");
		tes.clear();
		assertFalse(tes.get("1").isPresent());
	}
	
	@Test
	public void TwootNotExist() {
		TwootRepository tes = new InMemoryTwootRepository();
		assertFalse(tes.get("1").isPresent());
	}
}
