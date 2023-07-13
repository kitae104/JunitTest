package kr.inhatc.junit.mokito.todo.data.api;

import java.util.List;

// 1. TodoServiceStub 만들기
// 2. TodoServiceStub을 사용하여 TodoBusinessImpl 테스트하기
public interface TodoService {
	public List<String> retrieveTodos(String user);
	
	public List<String> configureSomething(String user);

	/**
	 * 삭제 메소드
	 * @param todo
	 */
	public void deleteTodo(String todo);
}
