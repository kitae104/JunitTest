package kr.inhatc.junit.mokito.todo.business;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class ListTest {

    @Test
    @DisplayName("리스트 테스트")
    public void testMockListSizeMethod(){
        // Given - setup
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);

        // When - actual method call

        // Then - assert
        assertEquals(2, listMock.size());
    }

    @Test
    @DisplayName("여러값 반환 테스트")
    public void testMockListSize_ReturnMultipleValues(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);  // 2, 3 순서대로 반환

        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    @DisplayName("리스트 Get 테스트")
    public void testMockListGet(){
        List listMock = Mockito.mock(List.class);
        // Argument Matcher
        when(listMock.get(anyInt())).thenReturn("test"); // 인자값이 어떤 정수든 test 반환

        assertEquals("test", listMock.get(0));  // 0번째 인덱스에 test가 있는지 확인
        assertEquals("test", listMock.get(1));    // 1번째 인덱스에 값이 없는지 확인
    }

    @Test
    @DisplayName("리스트 Get 테스트")
    public void testMockListGet_usingBDD(){
        // Given
        List<String> listMock = Mockito.mock(List.class);
        // Argument Matcher
        when(listMock.get(anyInt())).thenReturn("test"); // 인자값이 어떤 정수든 test 반환

        // When
        String firstElement = listMock.get(0);

        // Then
        assertThat(firstElement, is("test"));
        assertEquals("test", listMock.get(0));  // 0번째 인덱스에 test가 있는지 확인
        assertEquals("test", listMock.get(1));    // 1번째 인덱스에 값이 없는지 확인
    }

    @Test
    @DisplayName("예외 테스트")
    public void testMockList_throwAnException(){
        List listMock = Mockito.mock(List.class);
        // Argument Matcher
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something")); // 인자값이 어떤 정수든 예외 발생
        assertThrows(RuntimeException.class, ()->{
            listMock.get(0);
        });
    }

    @Test
    @DisplayName("예외 테스트2")
    public void testMockList_mixingUp(){
        List listMock = Mockito.mock(List.class);
        // Argument Matcher
        when(listMock.subList(anyInt(), 5)).thenThrow(new RuntimeException("Something"));
        assertThrows(RuntimeException.class, ()->{
            listMock.get(0);
        });
    }
}