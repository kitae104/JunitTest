package kr.inhatc.junit.helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    @Test
    public void test() {
        // 동등 여부 확인
        assertEquals("ABC", "ABC");    // expected, actual
    }

    @Test
    void truncateAInFirst2Positions() {
        StringHelper helper = new StringHelper();
        String actual = helper.truncateAInFirst2Positions("AACD");
        String expected = "CD";

        // AACD => CD, ACD => CD, CDEF=>CDEF, CDAA => CDAA
        assertEquals(expected, actual);
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    void areFirstAndLastTwoCharactersTheSame() {
    }
}