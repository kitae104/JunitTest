package kr.inhatc.junit.helper;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class QuickBeforeAfterTest {

    @BeforeAll   // 이전에는 @BeforeClass를 사용했지만 JUnit5에서는 @BeforeAll를 사용
    public static void beforeClass(){           // 반드시 static으로 선언
        System.out.println("Before class");
    }

    @BeforeEach  // 이전에는 @Before를 사용했지만 JUnit5에서는 @BeforeEach를 사용
    public void setup(){
        System.out.println("Before test");
    }

    @Test
    public void test1() {
        System.out.println("test1 executed");
    }

    @Test
    public void test2() {
        System.out.println("test2 executed");
    }

    @AfterEach  // 이전에는 @After를 사용했지만 JUnit5에서는 @AfterEach를 사용
    public void teardown(){
        System.out.println("After test");
    }

    @AfterAll   // 이전에는 @AfterClass를 사용했지만 JUnit5에서는 @AfterAll를 사용
    public static void afterClass(){           // 반드시 static으로 선언
        System.out.println("After class");
    }
}