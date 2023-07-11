package kr.inhatc.junit.mokito.todo.data.api;

import java.util.Arrays;
import java.util.List;

/**
 * Stub 테스트를 할 때는 실제 데이터를 작성해서 사용해야 한다.<br />
 * 하지만 테스트를 위해 늘 실제 데이터를 생성하는 것은 쉽지 않음.<br />
 * 서비스가 변경될 때마다 매번 같이 변경해서 테스트를 수행해야 하는 버거로움이 있음.<br />
 */
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
