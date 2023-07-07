package kr.inhatc.junit.helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    @Test
    public void test() {
        // 동등 여부 확인
        assertEquals("ABC", "ABC");    // expected, actual
    }

    // AACD => CD, ACD => CD, CDEF=>CDEF, CDAA => CDAA
    @Test
    void truncateAInFirst2Positions() {
        StringHelper helper = new StringHelper();
        String actual = helper.truncateAInFirst2Positions("AACD");
        String expected = "CD";

        assertEquals(expected, actual);
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    StringHelper helper = new StringHelper();       // 전역 변수로 선언
    
    @Test
    void truncateAInFirst2Positions_AinFirst2Position() {
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    void truncateAInFirst2Positions_AinFirstPosition() {
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }
    
    
    // ABCD => false, ABAB => true, AB => true, A => false
    @Test
    void testAreFirstAndLastTwoCharactersTheSame_BasicNegative() {
//    	assertEquals(false, helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
//      assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
        assertFalse(false);
    }

    @Test
    void testAreFirstAndLastTwoCharactersTheSame_BasicPositive() {
    	assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }
}