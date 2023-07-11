package kr.inhatc.junit.mokito.todo.business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.inhatc.junit.mokito.todo.data.api.TodoService;
import kr.inhatc.junit.mokito.todo.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	void testUsingAStub() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2,  filteredTodos.size());
	}


}
