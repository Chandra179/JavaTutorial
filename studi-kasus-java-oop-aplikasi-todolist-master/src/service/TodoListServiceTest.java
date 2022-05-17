package service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entity.Todolist;
import repository.TodoListRepositoryImpl;

class TodoListServiceTest {

	@Test
	void testShowTodoListEqual() {

		TodoListRepositoryImpl todo = new TodoListRepositoryImpl();
		Todolist[] model = todo.getAll();
		assertArrayEquals(model, new Todolist[10]);
	}

	@Test
	void testShowTodoListIndexOutOfBounds() {
		ArrayList<Todolist> data = new ArrayList<>(10);
		assertThrows(IndexOutOfBoundsException.class, () -> data.get(12));
	}
}
