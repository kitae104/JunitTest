package kr.inhatc.junit.mokito.todo.data.api;

import java.util.List;

// 1. Create TodoServiceStub
// 2. Test TodoBusinessImpl using TodoServiceStub
public interface TodoService {
	public List<String> retrieveTodos(String user);
	
	public List<String> configureSomething(String user);
}
