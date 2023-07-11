package kr.inhatc.junit.mokito.todo.business;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

    @Test
    @DisplayName("리스트 테스트")
    public void testMockListSizeMethod(){
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
    }

    @Test
    @DisplayName("리스트 테스트")
    public void testMockListSize_ReturnMultipleValues(){
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
    }
}