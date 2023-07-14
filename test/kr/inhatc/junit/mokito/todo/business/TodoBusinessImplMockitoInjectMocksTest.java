package kr.inhatc.junit.mokito.todo.business;

import kr.inhatc.junit.mokito.todo.data.api.TodoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

/**
 * @Mock : mockito를 이용한 테스트
 * @InjectMocks : mockito를 이용한 테스트
 * @Captor : BDD를 이용한 테스트
 */
@ExtendWith(MockitoExtension.class)
public class TodoBusinessImplMockitoInjectMocksTest {


	@Mock
	TodoService todoServiceMock;

	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;

	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;

	@Test
	@DisplayName("mokito를 이용한 테스트")
	public void testUsingAMock() {

//		TodoService todoServiceMock = mock(TodoService.class);	// mockito를 이용한 테스트

//		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		List<String> todos = Arrays.asList();
		Mockito.when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);


//		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0,  filteredTodos.size());
	}

	@Test
	@DisplayName("BDD를 이용한 테스트")
	public void testUsingBDD() {
		// Given
//		TodoService todoServiceMock = mock(TodoService.class);	// mockito를 이용한 테스트

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

//		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		// When
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		// Then
		assertThat(filteredTodos.size(), is(2));  // Hamcrest의 assertThat을 이용한 테스트
	}

	@Test
	@DisplayName("특정 메소드가 호출되는지 여부를 확인")
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {
		// Given
//		TodoService todoServiceMock = mock(TodoService.class);	// mockito를 이용한 테스트

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

//		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");	//

		// Then
		verify(todoServiceMock).deleteTodo("Learn to Dance");	// 특정 메소드가 호출되는지 여부를 확인
		then(todoServiceMock).should().deleteTodo("Learn to Dance");	// 특정 메소드가 호출되는지 여부를 확인

		verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");	// 특정 메소드가 호출되는지 여부를 확인
		verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn to Dance");	// 특정 메소드가 호출되는지 여부를 확인
		verify(todoServiceMock, atLeast(1)).deleteTodo("Learn to Dance");	// 특정 메소드가 호출되는지 여부를 확인

		verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");	// 특정 메소드가 호출되지 않는지 여부를 확인
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
	}

	@Test
	@DisplayName("아규먼트 캡쳐 확인")
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {
		// Declare Argument Captor
//		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

		// Define Argument Captor on specific method call
		// Capture the argument

		// Given
//		TodoService todoServiceMock = mock(TodoService.class);	// mockito를 이용한 테스트

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

//		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");	//

		// Then
		// 아큐먼트 캡쳐
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
	}

	@Test
	@DisplayName("아규먼트 캡쳐 확인")
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture2() {
		// Declare Argument Captor
//		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

		// Define Argument Captor on specific method call
		// Capture the argument

		// Given
//		TodoService todoServiceMock = mock(TodoService.class);	// mockito를 이용한 테스트

		List<String> todos = Arrays.asList("Learn Basic MVC", "Learn Spring", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

//		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");	//

		// Then
		// 아큐먼트 캡쳐
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
	}
}
