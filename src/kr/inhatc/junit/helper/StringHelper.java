package kr.inhatc.junit.helper;

public class StringHelper {

    /**
     * 처음 2개의 A 문자를 제거
     * AACD => CD, ACD => CD, CDEF=>CDEF, CDAA => CDAA
     * @param str
     * @return
     */
    public String truncateAInFirst2Positions(String str) {
        if (str.length() <= 2)
            return str.replaceAll("A", "");         // A를 제거

        String first2Chars = str.substring(0, 2);                           // 처음 2개의 문자
        String stringMinusFirst2Chars = str.substring(2);     // 2번째 문자부터 끝까지

        return first2Chars.replaceAll("A", "")      // A를 제거한 후 문자 추가
                + stringMinusFirst2Chars;
    }

    /**
     * 처음 2개의 문자와 마지막 2개의 문자가 같은지 확인
     * ABCD => false, ABAB => true, AB => true, A => false
     * @param str
     * @return
     */
    public boolean areFirstAndLastTwoCharactersTheSame(String str) {

        if (str.length() <= 1)
            return false;
        if (str.length() == 2)
            return true;

        String first2Chars = str.substring(0, 2);

        String last2Chars = str.substring(str.length() - 2);

        return first2Chars.equals(last2Chars);
    }
}
