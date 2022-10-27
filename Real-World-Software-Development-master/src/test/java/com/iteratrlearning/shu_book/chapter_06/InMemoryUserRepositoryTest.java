package com.iteratrlearning.shu_book.chapter_06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.iteratrlearning.shu_book.chapter_06.in_memory.InMemoryUserRepository;


public class InMemoryUserRepositoryTest {
	@Test
	public void successAddUserToMemory() {
		try (InMemoryUserRepository tes = new InMemoryUserRepository()) {
			byte[] pw = "ad17".getBytes();
			byte[] salt = "upw".getBytes();
			
			tes.add(new User("1", pw, salt, Position.INITIAL_POSITION));
			assertTrue(tes.get("1").isPresent());
		}
	}
	
	@Test
	public void userAlreadyExistInMemory() {
		InMemoryUserRepository tes = new InMemoryUserRepository();
		
		byte[] pw = "ad17".getBytes();
		byte[] salt = "upw".getBytes();
		
		tes.add(new User("1", pw, salt, Position.INITIAL_POSITION));
		var tes2 = tes.add(new User("1", pw, salt, Position.INITIAL_POSITION));
		
		assertFalse(tes2);
		tes.close();
	}
	
	@Test
	public void getUnknownUserShouldReturnFalse() {
		InMemoryUserRepository tes = new InMemoryUserRepository();
		assertFalse(tes.get("1").isPresent());
		tes.close();
	}
	
	@Test
	public void userSuccessToFollow() {
		InMemoryUserRepository tes = new InMemoryUserRepository();

		byte[] pw = "ad17".getBytes();
		byte[] salt = "upw".getBytes();
		
		User currUser = new User("1", pw, salt, Position.INITIAL_POSITION);
		User userToFollow = new User("2", pw, salt, Position.INITIAL_POSITION);
		
		FollowStatus res = tes.follow(userToFollow, currUser);
		assertEquals(FollowStatus.SUCCESS, res);
		tes.close();
	}
	
	@Test
	public void userHaveBeenFollowed() {
		InMemoryUserRepository tes = new InMemoryUserRepository();

		byte[] pw = "ad17".getBytes();
		byte[] salt = "upw".getBytes();
		
		User currUser = new User("1", pw, salt, Position.INITIAL_POSITION);
		User userToFollow = new User("2", pw, salt, Position.INITIAL_POSITION);
		
		tes.follow(userToFollow, currUser);
		var res = tes.follow(userToFollow, currUser);
		assertEquals(FollowStatus.ALREADY_FOLLOWING, res);
		tes.close();
	}
	
	@Test
	public void clearUser() {
		InMemoryUserRepository tes = new InMemoryUserRepository();

		byte[] pw = "ad17".getBytes();
		byte[] salt = "upw".getBytes();
		
		tes.add(new User("1", pw, salt, Position.INITIAL_POSITION));
		tes.clear();
		assertTrue(tes.get("1").isEmpty());
		
		tes.close();
	}
}
