package kr.inhatc.junit.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(Parameterized.class)  // JUnit4
class StringHelperParameterizedTest {

    // AACD => CD, ACD => CD, CDEF=>CDEF, CDAA => CDAA
    private StringHelper helper = new StringHelper();

    private static Stream<String[]> testConditions() {
        return Stream.of(
                new String[]{"AACD", "CD"},
                new String[]{"ACD", "CD"},
                new String[]{"CDEF", "CDEF"},
                new String[]{"CDAA", "CDAA"}
                //new String[]{"A", "B"}
        );
    }

    @ParameterizedTest                      // 파라미터 테스트 JUnit5
    @MethodSource("testConditions")         // 파라미터로 가져올 메소드
    @DisplayName("파라미터 테스트")
    public void testTruncateAInFirst2Positions(String input, String expectedOutput) {
        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
    }
}