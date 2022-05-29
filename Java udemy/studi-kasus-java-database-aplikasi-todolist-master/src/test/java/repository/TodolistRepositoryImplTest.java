package repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariDataSource;

import entity.Todolist;
import util.DatabaseUtil;

public class TodolistRepositoryImplTest {

	private HikariDataSource dataSource;

	private TodoListRepository todoListRepository;

	@BeforeEach
	void setUp() {
		dataSource = DatabaseUtil.getDataSource();
		todoListRepository = new TodoListRepositoryImpl(dataSource);
	}

	// @AfterEach
	@Disabled
	void tearDown() {
		dataSource.close();
	}

	@Test
	void testAdd() {
		Todolist todolist = new Todolist();
		todolist.setTodo("Kurniawan");
		todoListRepository.add(todolist);
	}

	@Test
	void testRemove() {
		System.out.println(todoListRepository.remove(1));
		System.out.println(todoListRepository.remove(2));
		System.out.println(todoListRepository.remove(3));
		System.out.println(todoListRepository.remove(4));
	}

	@Test
	void testGetAll() {
		todoListRepository.add(new Todolist("Eko"));
		todoListRepository.add(new Todolist("Kurniawan"));
		todoListRepository.add(new Todolist("Khannedy"));

		Todolist[] todolists = todoListRepository.getAll();
		for (var todo : todolists) {
			System.out.println(todo.getId() + " : " + todo.getTodo());
		}
	}

}
