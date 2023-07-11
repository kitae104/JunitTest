package kr.inhatc.junit.mokito.todo.business;

import kr.inhatc.junit.mokito.todo.data.api.TodoService;
import kr.inhatc.junit.mokito.todo.data.api.TodoServiceStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Mock이란 무엇입니까?
 * mock은 실제 개체의 동작을 시뮬레이션하는 개체를 만드는 것입니다.
 * 스텁과 달리 모의 객체는 런타임에 코드에서 동적으로 생성될 수 있습니다.
 * mock은 stub보다 더 많은 기능을 제공합니다.
 * 메서드 호출 및 기타 여러 가지를 확인할 수 있습니다.
 */
public class TodoBusinessImplMockTest {

	@Test
	@DisplayName("mokito를 이용한 테스트")
	public void testUsingAMock() {

		TodoService todoServiceMock = Mockito.mock(TodoService.class);	// mockito를 이용한 테스트

//		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		List<String> todos = Arrays.asList();
		Mockito.when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);


		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0,  filteredTodos.size());
	}


}
