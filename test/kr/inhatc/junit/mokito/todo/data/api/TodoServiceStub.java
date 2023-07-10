package kr.inhatc.junit.mokito.todo.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
	// Dynamic Condition
	// Service Definition
	
	@Override
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
	}

	@Override
	public List<String> configureSomething(String user) {
		// TODO Auto-generated method stub
		return null;
	}	

}
