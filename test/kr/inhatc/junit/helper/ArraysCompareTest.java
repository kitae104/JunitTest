package kr.inhatc.junit.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.sql.DriverManager;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class ArraysCompareTest {

    // Arrays.sort

    @Test
    @DisplayName("배열 정렬 테스트")
    public void testArraySort_RandomArray() {
        int[] numbers = {12, 3, 4, 1};
        int[] expected = {1, 3, 4, 12};

        Arrays.sort(numbers);
        //assertEquals(expected, numbers);
        assertArrayEquals(expected, numbers);       // 배열의 동등 여부 확인
    }

    @Test
    @DisplayName("NullPointerException 테스트")
    public void testArraySort_NullArray() {
        int[] numbers = null;
        try {
            Arrays.sort(numbers);
        } catch (NullPointerException e) {
            assertThrows(NullPointerException.class, () -> Arrays.sort(numbers));
            return;
        }
    }

    @Test //(expected = NullPointerException.class)        // expected를 사용한 예외 처리 -> Junit5에서 불가 !!
    @DisplayName("NullPointerException 테스트2")
    public void testArraySort_NullArray2() {
        int[] numbers = null;
        assertThrows(NullPointerException.class, () -> Arrays.sort(numbers));
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)      // 100ms 이내에 수행되어야 함
    @DisplayName("배열 비교 테스트")
    public void testSort_Performance() {
        int[] array = {12, 23, 4, 5, 20, 2};

        for (int i = 1; i <= 1000000; i++) {
            array[0] = i;
            Arrays.sort(array);
        }
    }
}