package kr.inhatc.junit.mokito.todo.business;

import java.util.ArrayList;
import java.util.List;

import kr.inhatc.junit.mokito.todo.data.api.TodoService;

// TodoBusinessImpl : SUT(System Under Test)
// TodoService : Dependency
public class TodoBusinessImpl {

	private TodoService todoService;

	// 생성자를 통한 의존성 주입
	public TodoBusinessImpl(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> todos = todoService.retrieveTodos(user);
		
		for (String todo : todos) {
			if(todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}

	/**
	 * Spring 문자열이 포함되지 않은 것만 삭제하는 메소드
	 * @param user
	 */
	public void deleteTodosNotRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> todos = todoService.retrieveTodos(user);

		for (String todo : todos) {
			if(!todo.contains("Spring")) {			// Spring이 포함되지 않은 것만 삭제
				todoService.deleteTodo(todo);
			}
		}
	}
}
